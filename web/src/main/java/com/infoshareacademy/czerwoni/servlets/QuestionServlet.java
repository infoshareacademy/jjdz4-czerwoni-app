package com.infoshareacademy.czerwoni.servlets;

import com.infoshareacademy.czerwoni.dao.QuestionAnswerDao;
import com.infoshareacademy.czerwoni.domain.Answer;
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

@WebServlet("questions")
public class QuestionServlet extends HttpServlet {

    @Inject
    QuestionAnswerDao questionAnswerDaoBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer answerId = Integer.parseInt(request.getParameter("answerRadio"));
        Answer answer = questionAnswerDaoBean.getAnswerById(answerId);
        System.out.println("Wybrana odpowiedź to: "+answerId);
        Question question = questionAnswerDaoBean.getQuestionById(answer.getRelatedQuest().getQuestionId());
        HttpSession session = request.getSession();
        session.setAttribute("question",question);
        session.setAttribute("answer",answer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("question.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Question question = questionAnswerDaoBean.getQuestionById(1);
        HttpSession session = request.getSession();
        session.setAttribute("question",question);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("question.jsp");
        requestDispatcher.forward(request,response);
    }
}
