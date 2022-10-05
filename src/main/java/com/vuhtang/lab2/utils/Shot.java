package com.vuhtang.lab2.utils;

import java.util.Date;

public record Shot(Integer x, Double y, Double r, Date currTime, Long execTime, String result) {
}
