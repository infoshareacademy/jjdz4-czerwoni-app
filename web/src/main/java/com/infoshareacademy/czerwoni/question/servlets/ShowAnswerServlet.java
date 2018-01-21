package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.ejb.QuestionAnswerServiceLocal;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("show-answer")
public class ShowAnswerServlet extends HttpServlet{
    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer answerId = Integer.parseInt(request.getParameter("answerRadio"));
        Answer answer = questionAnswerService.getAnswerById(answerId);
        request.setAttribute("answer", answer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
        requestDispatcher.forward(request,response);

    }
}
