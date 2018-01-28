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
import java.io.IOException;
import java.util.List;

@WebServlet("show-all-question")
public class ShowAllQuestionServlet extends HttpServlet {
    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Question> questionList = questionAnswerService.getAllQuestions();
        request.setAttribute("questionList",questionList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-all-question.jsp");
        requestDispatcher.forward(request,response);
    }
}
