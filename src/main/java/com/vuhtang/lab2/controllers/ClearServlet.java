package com.vuhtang.lab2.controllers;

import com.vuhtang.lab2.repository.DataManagerImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ClearServlet", value = "/clear")
public class ClearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object maybeManager = getServletContext().getAttribute("dataManager");
        if (maybeManager instanceof DataManagerImpl manager) {
            manager.removeAll();
            resp.setStatus(200);
        } else {
            resp.sendError(400);
        }
    }
}
