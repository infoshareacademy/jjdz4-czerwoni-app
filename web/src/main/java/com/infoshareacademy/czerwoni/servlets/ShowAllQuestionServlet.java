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
import java.util.List;

@WebServlet("show-all-question")
public class ShowAllQuestionServlet extends HttpServlet {
    @Inject
    QuestionAnswerDao questionAnswerDaoBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Question> questionList = questionAnswerDaoBean.getAllQuestions();
        request.setAttribute("questionList",questionList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-all-question.jsp");
        requestDispatcher.forward(request,response);
    }
}
