package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Question;
import com.infoshareacademy.czerwoni.question.dao.QuestionAnswerDao;

import javax.ejb.EJB;
import javax.management.MBeanServer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("add-question")
public class AddQuestionServlet extends HttpServlet {
    @EJB
    QuestionAnswerDao questionAnswerDaoBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionName = request.getParameter("questionName");
        Integer questionLevel;
        try {
            questionLevel = Integer.parseInt(request.getParameter("questionLevel"));
        }
        catch (NumberFormatException nfe){
            nfe.printStackTrace();
            request.setAttribute("NFErrorMessage","Musisz podać liczbę!!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-question.jsp");
            requestDispatcher.forward(request,response);
            return;
        }
        Question question = new Question();
        question.setQuestionName(questionName);
        question.setQuestionLevel(questionLevel);
        questionAnswerDaoBean.addQuestion(question);
        HttpSession session = request.getSession();
        session.setAttribute("question",question);
        session.setAttribute("mode", "editMode");
        Answer answer = questionAnswerDaoBean.getAnswerById(Integer.parseInt(request.getParameter("answer")));
        answer.setRelatedQuest(question);
        questionAnswerDaoBean.updateAnswer(answer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Answer> answersList = questionAnswerDaoBean.getAnswersWithoutRelatedQuestion();
        HttpSession session = request.getSession();
        session.setAttribute("answersList", answersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-question.jsp");
        requestDispatcher.forward(request,response);
    }
}
