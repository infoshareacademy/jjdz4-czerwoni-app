package com.infoshareacademy.czerwoni.users.servlets;

import com.infoshareacademy.czerwoni.users.ejb.TokenService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/init")
public class InitServlet extends HttpServlet {

    @Inject
    private TokenService tokenService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String token = tokenService.generateToken();
        setTokenCookie(resp, token);

        req.setAttribute("authToken", token);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void setTokenCookie(HttpServletResponse resp, String token) {
        String cookieName = tokenService.buildCookieName(tokenService.LOGIN_URI);
        //Lock the cookie from JS access and we use the SameSite attribute protection
        String cookieSpec = String.format("%s=%s; Path=%s; HttpOnly; SameSite=Strict",
                cookieName, token, tokenService.LOGIN_URI);
        resp.addHeader("Set-Cookie", cookieSpec);
    }
}
