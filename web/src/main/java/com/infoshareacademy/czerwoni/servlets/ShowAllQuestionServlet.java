package com.infoshareacademy.czerwoni.servlets;

import com.infoshareacademy.czerwoni.dao.QuestionAnswerDao;
import com.infoshareacademy.czerwoni.domain.Question;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("show-all-question")
public class ShowAllQuestionServlet extends HttpServlet {
    @Inject
    QuestionAnswerDao questionAnswerDaoBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Question question = questionAnswerDaoBean.getQuestionById(2);
        request.setAttribute("questionName", question.getQuestionName());
        request.setAttribute("questionLevel", question.getQuestionLevel());
        request.setAttribute("answers", question.getAnswerList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-all-question.jsp");
        requestDispatcher.forward(request,response);
    }
}
