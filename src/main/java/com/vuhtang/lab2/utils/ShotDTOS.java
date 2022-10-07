package com.vuhtang.lab2.utils;

import java.text.SimpleDateFormat;
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

    record ShotDTO(String x, String y, String r, String currTime, String execTime, String result) {
        private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        private ShotDTO(Shot shot) {
            this(String.format("%.4f", shot.x()),
                    String.format("%.4f", shot.y()),
                    String.format("%.1f", shot.r()),
                    format.format(shot.currTime()),
                    String.format("%.6f ms", (float) shot.execTime() / 1000000),
                    shot.result()
            );
        }
    }
}
