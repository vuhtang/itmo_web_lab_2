package com.vuhtang.lab2.utils;

import com.google.gson.Gson;

import java.util.List;

public class JSONTransformer implements Transformer {
    @Override
    public String transform(List<Shot> shots) {
        Gson gson = new Gson();
        ShotDTOS shotDTOS = new ShotDTOS(shots);
        return gson.toJson(shotDTOS);
    }
}
