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
import java.util.stream.Collectors;

@WebServlet("/add-category-promo")
public class AddCategoryPromo extends HttpServlet {

    @Inject
    DataPromoService dataPromoService;

    @Inject
    CategoriesService categoriesService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("id", req.getParameter("id"));
        req.getSession().setAttribute("categoryName", req.getParameter("categoryName"));
        String categoryName = req.getSession().getAttribute("categoryName").toString();
        Integer id;
        try {
            id = Integer.parseInt(req.getSession().getAttribute("id").toString());
        } catch (NumberFormatException e) {
            id = null;
        }

        if (categoryName.isEmpty() && id != null) {
            dataPromoService.addCategory(categoriesService.getCategoryById(id));
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AllegroCategory> categories;

        try {
            categories = dataPromoService
                    .getSearchedCategories(req.getSession().getAttribute("categoryName").toString());
        } catch (NullPointerException e) {
            categories = null;
        }

        if (categories != null) {
            req.setAttribute("searchedCategories", categories);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-category-promo.jsp");
        requestDispatcher.forward(req, resp);
    }
}
