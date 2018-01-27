package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Question;
import com.infoshareacademy.czerwoni.question.ejb.CategoryServiceLocal;
import com.infoshareacademy.czerwoni.question.ejb.QuestionAnswerServiceLocal;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("remove-question")
public class RemoveQuestionServlet extends HttpServlet {
    @Inject
    QuestionAnswerServiceLocal questionAnswerService;
    @Inject
    CategoryServiceLocal categoryService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
        request.setAttribute("question",question);
        for (Answer answer :question.getAnswerList()){
            questionAnswerService.removeAnswer(answer);
            categoryService.removeCategory(answer.getRelatedCategory());
        }
        Question questionNoAnswer = questionAnswerService.getQuestionById(questionId);
        questionAnswerService.removeQuestion(questionNoAnswer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-message.jsp");
        requestDispatcher.forward(request,response);


    }

}
