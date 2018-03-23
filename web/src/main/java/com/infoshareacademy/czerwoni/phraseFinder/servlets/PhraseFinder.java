package com.infoshareacademy.czerwoni.phraseFinder.servlets;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.repository.DataPromoRepository;
import com.infoshareacademy.czerwoni.phraseFinder.domain.FoundData;
import com.infoshareacademy.czerwoni.phraseFinder.service.PhraseService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/phrase-finder")
public class PhraseFinder extends HttpServlet {

//    @Inject
//    DataPromoRepository dataPromoRepository;

    @Inject
    PhraseService phraseService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String category = request.getParameter("phrase");
        Integer limit;
        try {
            limit = Integer.parseInt(request.getParameter("limit"));
        }
        catch (NumberFormatException nfe){
            limit=5;
        }
        // String error = null;


//        Map<AllegroCategory, String> firstNPhrases = phraseService.getFirstXCategories(category,limit);
//        if (firstNPhrases.isEmpty())    {
//            error = phraseService.errorResponse(category);
//        }
//
//        Map<AllegroCategory, String> breadCrumbsMap = new HashMap<>();
//        for (AllegroCategory allegroCategory : firstNPhrases.keySet())
//        {
//            {
//                breadCrumbsMap.put(allegroCategory, dataPromoRepository.getBreadCrumbsString(allegroCategory.getCatId()));
//            }
//        }

        FoundData foundData = phraseService.dataToPrint(category, limit);

        request.setAttribute("phraseMap", foundData.getFirstNPhrases());
        request.setAttribute("error", foundData.getError());
        request.setAttribute("breadCrumbsMap", foundData.getBreadCrumbsMap());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/phrase-finder.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that finds categories by phrase";
    }
}