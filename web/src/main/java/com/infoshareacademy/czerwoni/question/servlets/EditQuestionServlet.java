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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session =request.getSession();
        Integer questionId=null;
        try {
            questionId = Integer.parseInt(request.getParameter("questRadio"));
        }
        catch (NumberFormatException nfe){
            nfe.printStackTrace();
            request.setAttribute("NFErrorMessage", "Musisz wybrać pytanie!!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-all-question");
            requestDispatcher.forward(request,response);
        }
        Question question = questionAnswerService.getQuestionById(questionId);
        session.setAttribute("question",question);
        Answer relatedAnswer = questionAnswerService.getRelatedAnswerByQuest(question);
        session.setAttribute("relatedAnswer",relatedAnswer);
        List<Answer> answersList = questionAnswerService.getAnswersWithoutRelatedQuestion();
        session.setAttribute("answersWithoutRelQuestList", answersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-question.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer questionLevel;
        try {
            questionLevel = Integer.parseInt(request.getParameter("questionLevel"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            request.setAttribute("NFErrorMessage", "Musisz podać liczbę!!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-question");
            requestDispatcher.forward(request,response);
        }
    }
}
