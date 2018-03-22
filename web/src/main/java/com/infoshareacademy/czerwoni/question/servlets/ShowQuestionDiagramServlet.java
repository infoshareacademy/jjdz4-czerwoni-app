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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("show-question-diagram")
public class ShowQuestionDiagramServlet extends HttpServlet {
    @Inject
    QuestionAnswerServiceLocal questionAnswerService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Question> questionList = questionAnswerService.getAllQuestions();
        request.setAttribute("questionList", questionList);
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"pl\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>What do you want?</title>\n" +
                "    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"\n" +
                "            integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\n" +
                "            crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js\"\n" +
                "            integrity=\"sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh\"\n" +
                "            crossorigin=\"anonymous\"></script>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\"\n" +
                "          integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\" crossorigin=\"anonymous\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/fontello/css/fontello.css\" type=\"text/css\">\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js\"\n" +
                "            integrity=\"sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ\"\n" +
                "            crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n" +
                "    <meta name=\"google-signin-client_id\"\n" +
                "          content=\"830889560506-bfd7gjnpsj4o3ss6n24f2pis4dscu4u9.apps.googleusercontent.com\">\n" +
                "</head>\n" +
                "<body class=\"bg-dark\">\n" +
//                "<div class=\"container\">\n" +
//                "    <%@include file=\"header.jsp\" %>\n" +
//                "    <%@include file=\"links.jsp\" %>\n" +
                "    <div>\n" +
//                "        <div class=\"row mt-3 pl-2 pr-2 pt-3 border border-secondary\">\n" +
                "            <div class=\"tree\">");

        printQuestionTree(writer, questionAnswerService.getAllQuestions().get(0).getQuestionId());

        writer.println(" </div>\n" +
                "        </div>\n" +
                "        <div class=\"row m-0\">\n" +
                "            <span class=\"mx-auto p-2\">&#169 infoShare Academy</span>\n" +
//                "        </div>\n" +
                "    </div>\n" +
//                "</div>\n" +
                "</body>\n" +
                "</html>");




//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-question-diagram1.jsp");
//        requestDispatcher.include(request, response);
    }

    private void printQuestionTree(PrintWriter writer, int questionId) {
            Question question = questionAnswerService.getQuestionById(questionId);

            writer.println("<ul>");
                writer.println("<li >");
                    writer.println("<a href = \"#\" >"+question.getQuestionName()+"</a >");
                        writer.println("<ul >");
                        for (Answer a:question.getAnswerList()) {
                            writer.println("<li >");
                            writer.println("<a href = \""+a.getRelatedCategory().getCategoryAllegroLink() +"\" target=\"_blank\" >" + a.getAnswerName() + "</a >");
                            if(a.getRelatedQuest()!=null){
                                printQuestionTree(writer, a.getRelatedQuest().getQuestionId());
                            }
                            writer.println("</li >");
                        }
                        writer.println("</ul >");
                writer.println("</li >");
            writer.println("</ul >");



    }
}