package com.infoshareacademy.czerwoni.users.servlets;

import com.infoshareacademy.czerwoni.users.domain.Roles;
import com.infoshareacademy.czerwoni.users.domain.Users;
import com.infoshareacademy.czerwoni.users.ejb.AuthorizedUsersServiceLocal;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("google-user")
public class GoogleUserServlet extends HttpServlet {

    @Inject
    AuthorizedUsersServiceLocal authorizedUsersService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        request.setAttribute("name",request.getParameter("name"));
        request.setAttribute("email",request.getParameter("email"));

        if(!authorizedUsersService.isEmailUserExist(email)){
            Users users = new Users(email, authorizedUsersService.getHexPassword(email), name, name, email);
            Roles roles = new Roles(email,"user","user");

            authorizedUsersService.addAuthorizedUser(users,roles);
        }
        LoginServlet.loginUser(request, response, "guser", "Guser1");
        authorizedUsersService.addStatsToApi(email, LocalDateTime.now());

    }
}
