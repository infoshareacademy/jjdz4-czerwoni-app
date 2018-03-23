package com.infoshareacademy.czerwoni.users.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/init")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        // set cookie (token)
        // set attribute (token)
        // dispatcher.forward(index.jsp)
        String token = UUID.randomUUID().toString();

        Cookie cookie = new Cookie("sessionID", token);
      /*  cookie.setPath("/");
        //cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 1);
        resp.addCookie(cookie);  */
        //resp.addHeader();
        // req.getRe
        req.setAttribute("authToken", token);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
