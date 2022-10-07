package com.vuhtang.lab2.controllers;

import com.vuhtang.lab2.repository.DataManagerImpl;
import com.vuhtang.lab2.utils.JSONTransformer;
import com.vuhtang.lab2.utils.Transformer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    private Transformer transformer;

    @Override
    public void init() throws ServletException {
        super.init();
        this.transformer = new JSONTransformer();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object maybeManager = getServletContext().getAttribute("dataManager");
        if (maybeManager instanceof DataManagerImpl manager) {

            String responseHTML = transformer.transform(manager.getAll());

            PrintWriter out = resp.getWriter();
            out.println(responseHTML);
        } else {
            resp.sendError(400);
        }
    }
}
