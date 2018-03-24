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

        // Cookie cookie = new Cookie("sessionID", token);
      /*  cookie.setPath("/");
        //cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 1);
        resp.addCookie(cookie);  */

        String reqURI = req.getRequestURI();
        //Here we lock the cookie from JS access and we use the SameSite new attribute protection
        String cookieSpec = String.format("%s=%s; Path=%s; HttpOnly; SameSite=Strict",
                tokenService.buildCookieName(reqURI), token, reqURI);
        resp.addHeader("Set-Cookie", cookieSpec);
        //Add cookie header to give access to the token to the JS code
        resp.setHeader(tokenService.CSRF_TOKEN_NAME, token);


        req.setAttribute("authToken", token);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
