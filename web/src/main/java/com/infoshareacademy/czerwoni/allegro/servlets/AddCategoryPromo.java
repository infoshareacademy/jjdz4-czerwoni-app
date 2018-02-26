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
import java.util.Map;

@WebServlet("/add-category-promo")
public class AddCategoryPromo extends HttpServlet {

    @Inject
    DataPromoService dataPromoService;

    @Inject
    CategoriesService categoriesService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("nameSearch") == null
                && req.getParameter("idSearch") != null
                && req.getParameter("addCategoryByName") == null) {
            addCategoryById(req, resp);
        } else if (req.getParameter("nameSearch") != null
                && req.getParameter("idSearch") == null
                && req.getParameter("addCategoryByName") == null) {
            displayCategoryByName(req, resp);
        } else if (req.getParameter("nameSearch") == null
                && req.getParameter("idSearch") == null
                && req.getParameter("addCategoryByName") != null) {
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

    private void displayCategoryByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<AllegroCategory, String> categories = dataPromoService.getSearchedCategories(req.getParameter("name"));
        req.setAttribute("categoriesMap", categories);

        if (categories.isEmpty()) {
            req.setAttribute("errorMessageName", "Nie odnaleziono kategorii!");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void addCategoryByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder categoryIdString = new StringBuilder(req.getParameter("addCategoryByName"));
        Integer categoryId;
        categoryId = Integer.parseInt(categoryIdString.delete(0, 17).toString());

        boolean catAdded = dataPromoService.addCategory(categoryId);

        if (!catAdded) {
            req.setAttribute("errorMessageName", "Nie odnaleziono kategorii!");
        } else {
            req.setAttribute("okMessageName", "Kategoria dodana poprawnie!");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }
}
