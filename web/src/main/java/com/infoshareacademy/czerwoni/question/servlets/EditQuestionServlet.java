package com.infoshareacademy.czerwoni.question.servlets;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Question;
import com.infoshareacademy.czerwoni.question.ejb.QuestionAnswerServiceLocal;

import javax.ejb.EJBTransactionRolledbackException;
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
public class EditQuestionServlet extends HttpServlet {
    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer questionId = null;
        try {
            questionId = Integer.parseInt(request.getParameter("questRadio"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            request.setAttribute("NFErrorMessage", "Musisz wybrać pytanie!!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-all-question");
            requestDispatcher.forward(request, response);
        }
        Question question = questionAnswerService.getQuestionById(questionId);
        Answer relatedAnswer = null;
        if (question.getQuestionLevel() != 1) {
            relatedAnswer = questionAnswerService.getRelatedAnswerByQuest(question);
        }
        session.setAttribute("relatedAnswer", relatedAnswer);
        session.setAttribute("question", question);
        List<Answer> answersList = questionAnswerService.getAnswersWithoutRelatedQuestion();
        session.setAttribute("answersWithoutRelQuestList", answersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-question.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer questionLevel = null;
        try {
            questionLevel = Integer.parseInt(request.getParameter("questionLevel"));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            request.setAttribute("NFErrorMessage", "Musisz podać liczbę!!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-question");
            requestDispatcher.forward(request, response);
        }
        String editButton = request.getParameter("edit-button");
        Question question = (Question) session.getAttribute("question");
        question.setQuestionName(request.getParameter("questionName"));
        question.setQuestionLevel(questionLevel);
        Answer answer = (Answer) session.getAttribute("relatedAnswer");
        Answer newRelatedAnswer;
        Integer newAnswerId = Integer.parseInt(request.getParameter("answer"));


        switch (editButton) {
            case "save-changes": {
                session.removeAttribute("isUpdateAnswer");
                if (answer != null && newAnswerId>0) {
                    answer.setRelatedQuest(null);
                    questionAnswerService.updateAnswer(answer);
                    newRelatedAnswer = questionAnswerService.getAnswerById(newAnswerId);
                    newRelatedAnswer.setRelatedQuest(question);
                    questionAnswerService.updateAnswer(newRelatedAnswer);
                    request.setAttribute("question",question);
                }
                questionAnswerService.updateQuestion(question);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-message.jsp");
                requestDispatcher.forward(request,response);
                break;
            }
            case "goto-answer": {
                session.removeAttribute("isUpdateAnswer");
                session.removeAttribute("answer");
                checkQuestionHasRelatedAnswer(question, answer, newAnswerId);
                questionAnswerService.updateQuestion(question);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
                requestDispatcher.forward(request,response);
                break;
            }
            case "goto-update-answer": {
                session.setAttribute("isUpdateAnswer", true);
                session.removeAttribute("answer");
                checkQuestionHasRelatedAnswer(question, answer, newAnswerId);
                questionAnswerService.updateQuestion(question);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
                requestDispatcher.forward(request,response);
                break;
            }

        }

    }

    private void checkQuestionHasRelatedAnswer(Question question, Answer answer, Integer newAnswerId) {
        Answer newRelatedAnswer;
        if (answer != null && newAnswerId>0) {
            answer.setRelatedQuest(null);
            questionAnswerService.updateAnswer(answer);
            newRelatedAnswer = questionAnswerService.getAnswerById(newAnswerId);
            newRelatedAnswer.setRelatedQuest(question);
            questionAnswerService.updateAnswer(newRelatedAnswer);
        }
    }
}

