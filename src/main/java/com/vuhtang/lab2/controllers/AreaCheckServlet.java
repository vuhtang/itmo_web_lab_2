package com.vuhtang.lab2.controllers;


import com.vuhtang.lab2.repository.DataManagerImpl;
import com.vuhtang.lab2.utils.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    private ShotChecker shotChecker;
    private Transformer transformer;

    @Override
    public void init() throws ServletException {
        super.init();
        this.shotChecker = new ShotCheckerImpl();
        this.transformer = new TableTransformer();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        try {
            int x = Integer.parseInt(req.getParameter("x"));
            double y = Float.parseFloat(req.getParameter("y"));
            double r = Double.parseDouble(req.getParameter("r"));
            if (validate(x, y, r)) {
                Shot shot = shotChecker.takeShot(x, y, r);
                String html = transformer.transformToHTML(shot);

                Object maybeManager = getServletContext().getAttribute("dataManager");
                if (maybeManager instanceof DataManagerImpl manager) {
                    manager.add(shot);
                }

                PrintWriter out = resp.getWriter();
                out.println(html);
            }
        } catch (NumberFormatException e) {
            resp.sendError(400, "Invalid parameter format");
        }
    }

    private boolean validate(int x, double y, double r) {
        List<Integer> xPossibleValues = Arrays.asList(-4, -3, -2, -1, 0, 1, 2, 3, 4);
        List<Double> rPossibleValues = Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0);
        return (-3 <= y && y <= 5 && xPossibleValues.contains(x) && rPossibleValues.contains(r));
    }
}
