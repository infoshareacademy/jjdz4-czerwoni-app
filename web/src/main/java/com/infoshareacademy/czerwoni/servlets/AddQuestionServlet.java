package com.infoshareacademy.czerwoni.servlets;

import com.infoshareacademy.czerwoni.dao.QuestionAnswerDao;
import com.infoshareacademy.czerwoni.domain.Answer;
import com.infoshareacademy.czerwoni.domain.Question;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("add-question")
public class AddQuestionServlet extends HttpServlet {
    @EJB
    QuestionAnswerDao questionAnswerDaoBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionName = request.getParameter("questionName");
        Integer questionLevel = Integer.parseInt(request.getParameter("questionLevel"));
        Question question = new Question();
        question.setQuestionName(questionName);
        question.setQuestionLevel(questionLevel);
        questionAnswerDaoBean.addQuestion(question);
        HttpSession session = request.getSession();
        session.setAttribute("question",question);
        session.setAttribute("mode", "editMode");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-question.jsp");
        requestDispatcher.forward(request,response);

    }
}
