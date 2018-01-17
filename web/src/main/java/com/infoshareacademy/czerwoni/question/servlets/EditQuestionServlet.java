package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Question;
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

@WebServlet("update-question")
public class EditQuestionServlet extends HttpServlet{
    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();
        Integer questionId = Integer.parseInt(request.getParameter("questRadio"));
        Question question = questionAnswerService.getQuestionById(questionId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-question");
        requestDispatcher.forward(request,response);
    }
}
