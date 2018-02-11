package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Category;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("add-answers")
public class AddAnswersServlet extends HttpServlet {

    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    @Inject
    CategoryServiceLocal categoryService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("add-answer") != null) {
            addAnswerAndExit(request, response);
        }
        if (request.getParameter("add-next-answer") != null) {
            addNextAnswer(request, response);
        }
        if (request.getParameter("remove-answer") != null) {
            removeAnswer(request, response);
        }
        if (request.getParameter("edit-answer") != null) {
            editAnswer(request, response);
        }
    }

    private void addNextAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("isUpdateAnswer");
        session.removeAttribute("answer");

        Question question = (Question) session.getAttribute("question");
        List<Answer> answerList;
        answerList = question.getAnswerList();
        Answer answer = new Answer();
        answer.setAnswerName(request.getParameter("answerName"));
        Category category = new Category();
        category.setCategoryName(request.getParameter("categoryName"));
        category.setCategoryAllegroLink(request.getParameter("categoryAllegroLink"));
        categoryService.addCategory(category);
        answer.setRelatedCategory(category);
        questionAnswerService.addAnswer(answer);
        answerList.add(answer);
        question.setAnswerList(answerList);

        questionAnswerService.updateQuestion(question);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addAnswerAndExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("isUpdateAnswer") != null) {
            Answer answer = (Answer) session.getAttribute("answer");
            answer.setAnswerName(request.getParameter("answerName"));
            answer.getRelatedCategory().setCategoryName(request.getParameter("categoryName"));
            answer.getRelatedCategory().setCategoryAllegroLink(request.getParameter("categoryAllegroLink"));

            categoryService.updateCategory(answer.getRelatedCategory());
            questionAnswerService.updateAnswer(answer);
            Question question = (Question) session.getAttribute("question");
            session.setAttribute("question", questionAnswerService.getQuestionById(question.getQuestionId()));
        } else {
            Question question = (Question) session.getAttribute("question");
            List<Answer> answerList;
            answerList = question.getAnswerList();
            Answer answer = new Answer();
            answer.setAnswerName(request.getParameter("answerName"));
            Category category = new Category();
            category.setCategoryName(request.getParameter("categoryName"));
            category.setCategoryAllegroLink(request.getParameter("categoryAllegroLink"));

            categoryService.addCategory(category);
            answer.setRelatedCategory(category);
            questionAnswerService.addAnswer(answer);
            answerList.add(answer);
            question.setAnswerList(answerList);
            questionAnswerService.updateQuestion(question);
        }
        session.removeAttribute("answer");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("question-added.jsp");
        requestDispatcher.forward(request, response);
        session.setAttribute("question", null);
    }

    private void removeAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Answer answer = questionAnswerService.getAnswerById(Integer.parseInt(request.getParameter("answerRadio")));

        questionAnswerService.removeAnswer(answer);
        categoryService.removeCategory(answer.getRelatedCategory());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-message.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer answerId = null;
        try {
            answerId = Integer.parseInt(request.getParameter("answerRadio"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            request.setAttribute("NFErrorMessage", "Musisz wybrać pytanie!!!");
            session.setAttribute("isUpdateAnswer", true);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
            requestDispatcher.forward(request, response);
        }
        session.setAttribute("isUpdateAnswer", true);
        session.removeAttribute("answer");
        Answer answer = questionAnswerService.getAnswerById(answerId);
        request.setAttribute("radioAnswerId", answerId);
        session.setAttribute("answer", answer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
        requestDispatcher.forward(request, response);
    }
}
