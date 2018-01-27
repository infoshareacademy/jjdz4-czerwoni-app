package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Question;
import com.infoshareacademy.czerwoni.question.ejb.QuestionAnswerServiceLocal;

import javax.ejb.EJB;
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
    QuestionAnswerServiceLocal questionAnswerService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addQuestion(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

//        session.removeAttribute("answersList");
//        session.removeAttribute("question");
        session.removeAttribute("isUpdateAnswer");
        List<Answer> answersList = questionAnswerService.getAnswersWithoutRelatedQuestion();
        request.setAttribute("answersListWithoutRelatedQuestion", answersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-question.jsp");
        requestDispatcher.forward(request, response);
    }


    private void addQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionName = request.getParameter("questionName");
        Integer questionLevel;
        try {
            questionLevel = Integer.parseInt(request.getParameter("questionLevel"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            request.setAttribute("NFErrorMessage", "Musisz podać liczbę!!!");
            List<Answer> answersList = questionAnswerService.getAnswersWithoutRelatedQuestion();
            request.setAttribute("answersListWithoutRelatedQuestion", answersList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-question.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        Question question = new Question();
        question.setQuestionName(questionName);
        question.setQuestionLevel(questionLevel);
        questionAnswerService.addQuestion(question);
        HttpSession session = request.getSession();
        session.removeAttribute("isUpdateAnswer");
        session.setAttribute("question", question);
        session.setAttribute("mode", "editMode");
        Answer answer = questionAnswerService.getAnswerById(Integer.parseInt(request.getParameter("answer")));
        answer.setRelatedQuest(question);
        questionAnswerService.updateAnswer(answer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
        requestDispatcher.forward(request, response);
    }
}
