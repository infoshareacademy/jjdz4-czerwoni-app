package com.infoshareacademy.czerwoni.users.servlets;

import com.infoshareacademy.czerwoni.users.domain.Roles;
import com.infoshareacademy.czerwoni.users.domain.Users;
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
public class AddUserServlet extends HttpServlet {

    @Inject
    AuthorizedUsersServiceLocal authorizedUsersService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<String> rolesList = authorizedUsersService.getRolesNameList();
        request.setAttribute("rolesList", rolesList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-user.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String role = request.getParameter("roles");

        if (!authorizedUsersService.isEmailUserExist(email)) {
            Users users = new Users(login, authorizedUsersService.getHexPassword(password), name, surname, email);
            Roles roles = new Roles(login, role, role );

            authorizedUsersService.addAuthorizedUser(users, roles);
            request.setAttribute("users", users);
        } else {
            Users users1 = authorizedUsersService.getUserByEmail(email);
            Roles roles1 = authorizedUsersService.getRolesByLogin(users1.getLogin());

            users1.setLogin(login);
            users1.setPassword(authorizedUsersService.getHexPassword(password));
            users1.setName(name);
            users1.setSurname(surname);
            users1.setEmail(email);
            roles1.setUserGroup(role);
            roles1.setUserRole(role);
            roles1.setUserLogin(login);

            authorizedUsersService.updateAuthorizedUser(users1, roles1);
            request.setAttribute("users", users1);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-added.jsp");
        requestDispatcher.forward(request, response);
    }
}
