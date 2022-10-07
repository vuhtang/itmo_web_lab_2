package com.vuhtang.lab2.utils;

import java.util.Date;

public record Shot(Double x, Double y, Double r, Date currTime, Long execTime, String result) {
}
