package com.infoshareacademy.czerwoni.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetData")
public class GetDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html><html><body> jestem w GetData"
                + "</body></html>");
    }
}
