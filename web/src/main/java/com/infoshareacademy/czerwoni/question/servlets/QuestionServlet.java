package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Category;
import com.infoshareacademy.czerwoni.question.domain.Question;
import com.infoshareacademy.czerwoni.question.ejb.QuestionAnswerServiceLocal;
import com.infoshareacademy.czerwoni.question.domain.Answer;

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

@WebServlet("questions")
public class QuestionServlet extends HttpServlet {

    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer answerId = Integer.parseInt(request.getParameter("answerRadio"));
        Answer answer = questionAnswerService.getAnswerById(answerId);
        Question question = questionAnswerService.getQuestionById(answer.getRelatedQuest().getQuestionId());
        HttpSession session = request.getSession();
        session.setAttribute("question",question);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("question.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Question question = questionAnswerService.getQuestionById(1);
        HttpSession session = request.getSession();
        session.setAttribute("question",question);
        List<Category> categoryList = new ArrayList<>();
        session.setAttribute("categoryList", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("question.jsp");
        requestDispatcher.forward(request,response);
    }
}
