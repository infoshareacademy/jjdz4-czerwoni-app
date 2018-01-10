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
import java.io.IOException;
import java.util.List;

@WebServlet("assign-parent-answer")
public class AssignParentAnswerServlet extends HttpServlet {
    @Inject
    QuestionAnswerDao questionAnswerDaoBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String assignAnswerButton = request.getParameter("assign-parent-answer");
        if (assignAnswerButton!=null){
        List<Answer> answersList = questionAnswerDaoBean.getAllAnswers();
        request.setAttribute("answersList", answersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("assign-parent-answer.jsp");
        requestDispatcher.forward(request,response);
        }

        String addParentAnswerButton = request.getParameter("add-parent-answer");
        if(addParentAnswerButton!=null){
            Answer answer = questionAnswerDaoBean.getAnswerById(Integer.parseInt(request.getParameter("answer")));
            Question question = (Question) request.getSession().getAttribute("question");
            answer.setRelatedQuest(question);
            questionAnswerDaoBean.addAnswer(answer);

        }
    }
}
