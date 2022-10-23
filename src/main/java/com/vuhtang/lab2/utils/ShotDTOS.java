package com.vuhtang.lab2.utils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ShotDTOS {
    private final List<ShotDTO> shots;

    public ShotDTOS(List<Shot> shots) {
        this.shots = new ArrayList<>();
        for (Shot shot : shots) {
            this.shots.add(new ShotDTO(shot));
        }
    }

    record ShotDTO(String x, String y, String r, String execTime, String currTime, String result) {
        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        private ShotDTO(Shot shot) {
            this(String.format("%.4f", shot.x()),
                    String.format("%.4f", shot.y()),
                    String.format("%.1f", shot.r()),
                    shot.currTime().format(formatter),
                    String.format("%.6f ms", (float) shot.execTime() / 1000000),
                    shot.result()
            );
        }
    }
}
