package com.infoshareacademy.czerwoni.phraseFinder.servlets;

import com.infoshareacademy.czerwoni.phraseFinder.dao.PhraseService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/phrase-finder")
public class PhraseFinder extends HttpServlet {

    @Inject
    PhraseService phraseService;

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           String category = request.getParameter("phrase");

           request.setAttribute("phrase",phraseService.getCategoryByPhrase(category));
           request.setAttribute("link",phraseService.getLinkByPhrase(category));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/phrase-finder.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that finds categories by phrase";
    }
}
