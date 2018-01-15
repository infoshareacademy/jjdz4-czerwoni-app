package com.infoshareacademy.czerwoni.allegro.servlets;

import com.infoshareacademy.czerwoni.allegro.dao.CategoriesService;
import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/allegro-categories")
public class PrintCategories extends HttpServlet {

    @EJB
    CategoriesService categoriesService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<AllegroCategory, String> categories = categoriesService.getCategories(0);
        req.setAttribute("list", categories);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/allegro-categories.jsp");
        requestDispatcher.forward(req, resp);
    }


}
