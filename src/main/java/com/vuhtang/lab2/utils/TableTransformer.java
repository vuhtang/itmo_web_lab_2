package com.vuhtang.lab2.utils;

import java.text.SimpleDateFormat;

public class TableTransformer implements Transformer {
    @Override
    public String transformToHTML(Shot shot) {
        StringBuilder response = new StringBuilder("<tr>");
        String pattern = "HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        appendTD(response, String.format("%.1f", shot.r()));
        appendTD(response, shot.x());
        appendTD(response, String.format("%.4f", shot.y()));
        appendTD(response, shot.result());
        appendTD(response, simpleDateFormat.format(shot.currTime()));
        appendTD(response, String.format("%.6f ms", (float) shot.execTime() / 1000000));
        response.append("</tr>");
        return response.toString();
    }

    private void appendTD(StringBuilder builder, Object o) {
        builder.append("<td>");
        builder.append(o.toString());
        builder.append("</td>");
    }
}
