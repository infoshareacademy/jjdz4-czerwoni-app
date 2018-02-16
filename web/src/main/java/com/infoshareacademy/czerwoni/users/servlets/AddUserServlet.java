package com.infoshareacademy.czerwoni.users.servlets;

import com.infoshareacademy.czerwoni.users.domain.Roles;
import com.infoshareacademy.czerwoni.users.ejb.AuthorizedUsersServiceLocal;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("add-user")
public class AddUserServlet extends HttpServlet{

    @Inject
    AuthorizedUsersServiceLocal authorizedUsersService;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<Roles> rolesList = authorizedUsersService.getRolesNameList();
        request.setAttribute("rolesList", rolesList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-user.jsp");
        requestDispatcher.forward(request,response);



    }
}
