package com.infoshareacademy.czerwoni.servlets;

import com.infoshareacademy.czerwoni.dao.CategoryDao;
import com.infoshareacademy.czerwoni.dao.QuestionAnswerDao;
import com.infoshareacademy.czerwoni.domain.Answer;
import com.infoshareacademy.czerwoni.domain.Category;
import com.infoshareacademy.czerwoni.domain.Question;


import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("show-category")
public class ShowCategoryServlet extends HttpServlet {

    @Inject
    QuestionAnswerDao questionAnswerDaoBean;

    @Inject
    CategoryDao categoryDaoBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer answerId;
        HttpSession session = request.getSession();
        try {
            answerId = Integer.parseInt(request.getParameter("answerRadio"));
        }
        catch (NumberFormatException nfe){
            nfe.printStackTrace();
            request.setAttribute("noChoiceError","Musisz zaznaczyć odpowiedź!!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("question.jsp");
            requestDispatcher.forward(request,response);
            return;
        }
        request.setAttribute("selectedRadio", answerId);
        Answer answer = questionAnswerDaoBean.getAnswerById(answerId);
        if (isNextRelatedQuestion(answer)) {
            request.setAttribute("isNextQuestion", true);
        }
        Category category = categoryDaoBean.getCategoryById(answer.getRelatedCategory().getCategoryId());
        request.setAttribute("category", category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-category.jsp");
        requestDispatcher.forward(request, response);
    }

    boolean isNextRelatedQuestion(Answer answer) {
        if (answer.getRelatedQuest() != null) {
            return true;
        }
        return false;
    }
}
