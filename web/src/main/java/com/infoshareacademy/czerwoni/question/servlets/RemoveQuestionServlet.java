package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Question;
import com.infoshareacademy.czerwoni.question.ejb.CategoryServiceLocal;
import com.infoshareacademy.czerwoni.question.ejb.QuestionAnswerServiceLocal;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("remove-question")
public class RemoveQuestionServlet extends HttpServlet {
    @Inject
    QuestionAnswerServiceLocal questionAnswerService;
    @Inject
    CategoryServiceLocal categoryService;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session =request.getSession();
        Integer questionId = Integer.parseInt(request.getParameter("questRadio"));
        Question question = questionAnswerService.getQuestionById(questionId);
        for (Answer answer :question.getAnswerList()){
            questionAnswerService.removeAnswer(answer);
            categoryService.removeCategory(answer.getRelatedCategory());
        }

        questionAnswerService.removeQuestion(question);


    }

}
