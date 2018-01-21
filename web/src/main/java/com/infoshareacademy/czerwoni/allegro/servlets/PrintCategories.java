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
import java.util.List;
import java.util.Map;

@WebServlet("/allegro-categories")
public class PrintCategories extends HttpServlet {

    @EJB
    CategoriesService categoriesService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int parentID = Integer.parseInt(req.getParameter("parent"));
        Map<AllegroCategory, String> categories = categoriesService.getCategories(parentID);
        AllegroCategory mainCategory = categoriesService.getMainCategory(parentID);
        String lastCategoryLink = null;
        List<AllegroCategory> breadCrumbs = categoriesService.getBreadCrumbs(parentID);
        if (parentID != 0) lastCategoryLink = mainCategory.generateLink();
        req.setAttribute("mainCat", mainCategory);
        req.setAttribute("list", categories);
        req.setAttribute("lastCatLink", lastCategoryLink);
        req.setAttribute("breadCrumbs", breadCrumbs);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/allegro-categories.jsp");
        requestDispatcher.forward(req, resp);
    }
}
