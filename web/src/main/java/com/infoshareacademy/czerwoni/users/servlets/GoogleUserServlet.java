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
            Users users = new Users();
            Roles roles = new Roles();
            users.setName(name);
            users.setLogin(email);
            users.setEmail(email);
            users.setPassword(authorizedUsersService.getHexPassword(email));

            roles.setUserLogin(email);
            roles.setUserRole("user");
            roles.setUserGroup("user");

            authorizedUsersService.addAuthorizedUser(users,roles);
        }
        LoginServlet.loginUser(request, response, "guser", "Guser1");

    }
}
