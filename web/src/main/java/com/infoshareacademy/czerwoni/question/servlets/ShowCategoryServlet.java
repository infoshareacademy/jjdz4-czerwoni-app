package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Category;
import com.infoshareacademy.czerwoni.question.ejb.CategoryServiceLocal;
import com.infoshareacademy.czerwoni.question.ejb.QuestionAnswerServiceLocal;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("show-category")
public class ShowCategoryServlet extends HttpServlet {

    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    @Inject
    CategoryServiceLocal categoryService;

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
        Answer answer = questionAnswerService.getAnswerById(answerId);
        if (isNextRelatedQuestion(answer)) {
            request.setAttribute("isNextQuestion", true);
        }
        Category category = categoryService.getCategoryById(answer.getRelatedCategory().getCategoryId());
        request.setAttribute("category", category);
        List<Category> categoryList = null;

        if(((List<Category>) session.getAttribute("categoryList"))==null) {
            categoryList= new ArrayList<>();
        }
        else if (((List<Category>) session.getAttribute("categoryList"))!=null) {
            categoryList = (List<Category>) session.getAttribute("categoryList");
        }
        categoryList.add(category);

        session.setAttribute("categoryList", categoryList);
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
