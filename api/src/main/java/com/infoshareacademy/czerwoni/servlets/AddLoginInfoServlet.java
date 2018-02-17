package com.infoshareacademy.czerwoni.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddLoginInfo")
public class AddLoginInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (areParamsValid(req)) {
            // serviceBean.addLoginInfo();
            PrintWriter writer = resp.getWriter();
            writer.println("login: " + req.getParameter("login")
                    + " loginTime: " + req.getParameter("loginTime")
            );
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private boolean areParamsValid(HttpServletRequest req) {
        return !((req.getParameter("login") == null)
                || req.getParameter("login").isEmpty()
                || (req.getParameter("loginTime") == null)
                || req.getParameter("loginTime").isEmpty()
        );
    }
}
