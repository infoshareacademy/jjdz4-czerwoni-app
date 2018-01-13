package com.infoshareacademy.czerwoni.servlets;

import com.infoshareacademy.czerwoni.dao.CategoryDao;
import com.infoshareacademy.czerwoni.dao.QuestionAnswerDao;
import com.infoshareacademy.czerwoni.domain.Answer;
import com.infoshareacademy.czerwoni.domain.Category;
import com.infoshareacademy.czerwoni.domain.Question;

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
    QuestionAnswerDao questionAnswerDaoBean;

    @Inject
    CategoryDao categoryDaoBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id =  Integer.parseInt(request.getParameter("id"));
        Question question = questionAnswerDaoBean.getQuestionById(id);
        HttpSession session = request.getSession();
        session.setAttribute("question",question);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession();
        Question question = (Question) session.getAttribute("question");
        List<Answer> answerList = question.getAnswerList();
        Answer answer = new Answer();
        answer.setAnswerName(request.getParameter("answerName"));
        Category category = new Category();
        category.setCategoryName(request.getParameter("categoryName"));
        category.setCategoryAllegroLink(request.getParameter("categoryAllegroLink"));
        categoryDaoBean.addCategory(category);
        answer.setRelatedCategory(category);
        answerList.add(answer);
        question.setAnswerList(answerList);
        questionAnswerDaoBean.updateQuestion(question);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-answers.jsp");
        requestDispatcher.forward(request,response);

    }
}
