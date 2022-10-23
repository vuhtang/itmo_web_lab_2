package com.vuhtang.lab2.repository;

import com.vuhtang.lab2.utils.Shot;
import com.vuhtang.lab2.utils.parser.ShotsParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlManager implements DataManager{
    private static final String URL = "jdbc:mysql://db:3306/demodb";
    private static final String ADD = "INSERT INTO Shots (x, y, r, currTime, execTime, result)" +
            " VALUES (?, ?, ?, ?, ?, ?);";
    private final Connection connection;

    public SqlManager() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(URL,
                System.getenv("DB_USER"), System.getenv("DB_PASSWORD"));
    }

    @Override
    public void add(Shot shot) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setDouble(1, shot.x());
            statement.setDouble(2, shot.y());
            statement.setDouble(3, shot.r());
            statement.setString(4, shot.currTime().toString());
            statement.setLong(5, shot.execTime());
            statement.setString(6, shot.result());
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    @Override
    public void removeAll() {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Shots");
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    @Override
    public List<Shot> getAll() {
        try {
            Statement statement = connection.createStatement();
            List<Shot> shots = new ArrayList<>();
            ResultSet result = statement.executeQuery("SELECT * FROM Shots;");
            while (result.next()) {
                String[] values = new String[7];
                for (int i = 1; i < 7; i++) {
                    values[i] = result.getString(i);
                }
                shots.add(ShotsParser.parseShot(values));
            }
            statement.close();
            return shots;
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return new ArrayList<>();
    }
}
