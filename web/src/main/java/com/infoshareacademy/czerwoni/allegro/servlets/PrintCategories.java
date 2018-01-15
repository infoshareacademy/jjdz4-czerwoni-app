package com.infoshareacademy.czerwoni.allegro.servlets;

import com.infoshareacademy.czerwoni.allegro.dao.CategoriesRepositoryDao;
import com.infoshareacademy.czerwoni.allegro.domain.AllegroCategory;
import org.xml.sax.SAXException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/allegro-categories")
public class PrintCategories extends HttpServlet {

    @EJB
    CategoriesRepositoryDao categoriesRepositoryDao;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<AllegroCategory> categories = categoriesRepositoryDao.getCategories(0);
    }
}
