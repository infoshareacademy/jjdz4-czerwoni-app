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
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/add-category-promo")
public class AddCategoryPromo extends HttpServlet {

    @Inject
    DataPromoService dataPromoService;

    @Inject
    CategoriesService categoriesService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("idSearch") != null && req.getParameter("nameSearch") == null) {
            addCategoryById(req, resp);
        } else if (req.getParameter("nameSearch") != null && req.getParameter("idSearch") == null) {
            addCategoryByName(req, resp);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void addCategoryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean catAdded = false;

        if (req.getParameter("id") != null) {
            try {
                catAdded = dataPromoService.addCategory(Integer.parseInt(req.getParameter("id")));
            } catch (NumberFormatException e) {
                req.setAttribute("errorMessageId", "Wprowadzono niepoprawne dane!");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
                requestDispatcher.forward(req, resp);
            }
        }

        if (!catAdded) {
            req.setAttribute("errorMessageId", "Nie odnaleziono kategorii!");
        } else {
            req.setAttribute("okMessageId", "Kategoria dodana poprawnie!");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void addCategoryByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<AllegroCategory, String> categories = dataPromoService.getSearchedCategories(req.getParameter("name"));
        req.setAttribute("categoriesMap", categories);

        if (categories.isEmpty()) {
            req.setAttribute("errorMessageName", "Nie odnaleziono kategorii!");
        }

        boolean catAdded = false;

        if (req.getParameter("addCategoryByName") != null) {
            catAdded = dataPromoService.addCategory(Integer.parseInt(req.getParameter("addCategoryById")));
        }

        if (catAdded) {
            req.setAttribute("okMessageName", "Kategoria dodana poprawnie");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }
}
