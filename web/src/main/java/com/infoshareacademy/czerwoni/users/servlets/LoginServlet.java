package com.infoshareacademy.czerwoni.users.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        loginUser(request, response, login, password);
    }

    public static void loginUser(HttpServletRequest request, HttpServletResponse response, String login, String password) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            request.login(login, password);
        } catch (ServletException se) {
            request.setAttribute("errorMessage", se.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        if (request.getHeader("Referer").contains("index.jsp") || request.getHeader("Referer").contains("/")) {
            session.setAttribute("login",login);
            response.sendRedirect(request.getHeader("Referer"));
            return;
        }
        session.setAttribute("login",login);
        response.sendRedirect(request.getHeader("Referer"));
    }
}

