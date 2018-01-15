package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.ejb.CategoryServiceLocal;
import com.infoshareacademy.czerwoni.question.ejb.QuestionAnswerServiceLocal;
import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Category;
import com.infoshareacademy.czerwoni.question.domain.Question;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("add-answers")
public class AddAnswersServlet extends HttpServlet {

    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    @Inject
    CategoryServiceLocal categoryService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

       if(request.getParameter("add-answer")!=null) {
           HttpSession session = request.getSession();
           Question question = (Question) session.getAttribute("question");
           List<Answer> answerList;
           answerList = question.getAnswerList();
           Answer answer = new Answer();
           answer.setAnswerName(request.getParameter("answerName"));
           Category category = new Category();
           category.setCategoryName(request.getParameter("categoryName"));
           category.setCategoryAllegroLink(request.getParameter("categoryAllegroLink"));
           categoryService.addCategory(category);
           answer.setRelatedCategory(category);
           questionAnswerService.addAnswer(answer);
           answerList.add(answer);
           question.setAnswerList(answerList);
           questionAnswerService.updateQuestion(question);
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("question-added.jsp");
           requestDispatcher.forward(request, response);
           session.setAttribute("question",null);
       }
        if(request.getParameter("add-next-answer")!=null) {
            HttpSession session = request.getSession();
            Question question = (Question) session.getAttribute("question");
            List<Answer> answerList;
            answerList = question.getAnswerList();
            Answer answer = new Answer();
            answer.setAnswerName(request.getParameter("answerName"));
            Category category = new Category();
            category.setCategoryName(request.getParameter("categoryName"));
            category.setCategoryAllegroLink(request.getParameter("categoryAllegroLink"));
            categoryService.addCategory(category);
            answer.setRelatedCategory(category);
            questionAnswerService.addAnswer(answer);
            answerList.add(answer);
            question.setAnswerList(answerList);
            questionAnswerService.updateQuestion(question);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}
