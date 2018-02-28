package com.infoshareacademy.czerwoni.allegro.servlets;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
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

@WebServlet("/remove-category-promo")
public class RemoveCategoryPromo extends HttpServlet {

    @Inject
    DataPromoService dataPromoService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("idRemove") != null
                && req.getParameter("showList") == null
                && req.getParameter("removeCategoryFromList") == null) {
            removeCategoryById(req, resp);
        } else if (req.getParameter("idRemove") == null
                && req.getParameter("showList") != null
                && req.getParameter("removeCategoryFromList") == null) {
            showAllPromotedCategories(req, resp);
        } else if (req.getParameter("idRemove") == null
                && req.getParameter("showList") == null
                && req.getParameter("removeCategoryFromList") != null) {
            removeCategoryFromList(req, resp);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("remove-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void removeCategoryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean catRemoved = false;

        if (req.getParameter("id") != null) {
            try {
                catRemoved = dataPromoService.removeCategory(Integer.parseInt(req.getParameter("id")));
            } catch (NumberFormatException e) {
                req.setAttribute("errorMessageId", "Wprowadzono niepoprawne dane!");

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("remove-category-promo.jsp");
                requestDispatcher.forward(req, resp);
            }
        }

        if (!catRemoved) {
            req.setAttribute("errorMessageId", "Nie odnaleziono kategorii!");
        } else {
            req.setAttribute("okMessageId", "Kategoria usunięta!");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("remove-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showAllPromotedCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Map<AllegroCategory, String> categoriesMap = dataPromoService.getPromotedCategories();

        if (categoriesMap.isEmpty()) {
            req.setAttribute("errorMessageDelete", "Brak promowanych kategorii!");
        } else {
            req.setAttribute("categoriesMap", categoriesMap);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("remove-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void removeCategoryFromList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder categoryIdString = new StringBuilder(req.getParameter("removeCategoryFromList"));
        Integer categoryId;
        categoryId = Integer.parseInt(categoryIdString.delete(0, 22).toString());

        boolean catAdded = dataPromoService.removeCategory(categoryId);

        if (!catAdded) {
            req.setAttribute("errorMessageDelete", "Błąd podczas usuwania kategorii!");
        } else {
            req.setAttribute("okMessageDelete", "Kategoria usunięta poprawnie!");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("remove-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }
}
