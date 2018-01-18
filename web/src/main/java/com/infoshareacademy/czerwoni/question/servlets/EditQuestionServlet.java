package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Answer;
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
import java.util.List;

@WebServlet("update-question")
public class EditQuestionServlet extends HttpServlet{
    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();
        Integer questionId = Integer.parseInt(request.getParameter("questRadio"));
        Question question = questionAnswerService.getQuestionById(questionId);
        session.setAttribute("question",question);
        Answer relatedAnswer = questionAnswerService.getRelatedAnswerByQuest(question);
        session.setAttribute("relatedAnswer",relatedAnswer);
        List<Answer> answersList = questionAnswerService.getAnswersWithoutRelatedQuestion();
        session.setAttribute("answersList", answersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-question.jsp");
        requestDispatcher.forward(request,response);
    }
}
