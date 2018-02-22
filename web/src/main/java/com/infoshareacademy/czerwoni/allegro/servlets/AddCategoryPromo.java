package com.infoshareacademy.czerwoni.allegro.servlets;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.service.CategoriesService;
import com.infoshareacademy.czerwoni.allegro.service.DataPromoService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@WebServlet("/add-category-promo")
public class AddCategoryPromo extends HttpServlet {

    @Inject
    DataPromoService dataPromoService;

    @Inject
    CategoriesService categoriesService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addCategoryToPromo(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void addCategoryToPromo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean catAdded = false;
        if (req.getParameter("id") != null) {
            catAdded = dataPromoService.addCategory(Integer.parseInt(req.getParameter("id")));
        }

        if (!catAdded) {
            req.setAttribute("errorMessage", "Nie odnaleziono kategorii!");
        } else {
            req.setAttribute("okMessage", "Kategoria dodana poprawnie!");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }
}
