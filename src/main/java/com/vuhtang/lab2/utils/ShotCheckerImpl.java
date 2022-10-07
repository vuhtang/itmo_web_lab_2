package com.vuhtang.lab2.utils;

import java.util.Date;

public class ShotCheckerImpl implements ShotChecker {
    @Override
    public Shot takeShot(Double x, Double y, Double r) {
        long start = System.nanoTime();
        String RESULT = check(x, y, r) ? "HIT" : "MISS";
        Long EXEC_TIME = System.nanoTime() - start;
        Date CURR_TIME = new Date();
        return new Shot(x, y, r, CURR_TIME, EXEC_TIME, RESULT);
    }

    private boolean check(Double x, Double y, Double r) {
        return (x >= 0 && y >= 0 && x <= r / 2 && y <= r)
                || (x <= 0 && y <= 0 && x <= r && y <= r && y >= -x - r)
                || (x >= 0 && y <= 0 && x * x + y * y <= r * r);
    }
}
