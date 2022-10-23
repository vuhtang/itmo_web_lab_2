package com.vuhtang.lab2.utils.parser;

import com.vuhtang.lab2.utils.Shot;

import java.time.DateTimeException;
import java.time.LocalDateTime;


public class ShotsParser {

    public static Shot parseShot(String[] values) {
        try {
            Double x = Double.parseDouble(values[1]);
            Double y = Double.parseDouble(values[2]);
            Double r = Double.parseDouble(values[3]);
            LocalDateTime currTime = LocalDateTime.parse(values[4]);
            Long execTime  = Long.parseLong(values[5]);
            String result = values[6];
            return new Shot(x, y, r, currTime, execTime, result);
        } catch (NumberFormatException | DateTimeException ex) {
            return new Shot(0D, 0D, 0D, LocalDateTime.now(), 0L, "");
        }
    }
}
