package com.infoshareacademy.czerwoni.users.servlets;

import com.infoshareacademy.czerwoni.users.domain.ApiStats;
import com.infoshareacademy.czerwoni.users.domain.Users;
import com.infoshareacademy.czerwoni.users.ejb.ApiStatsService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@WebServlet("/reports")
public class ReportServlet extends HttpServlet {

    @Inject
    ApiStatsService apiStatsService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("reports.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<ApiStats> stats = Collections.EMPTY_LIST;

        if (req.getParameter("showAll") != null
                && req.getParameter("userName") == null
                && req.getParameter("email") == null) {
            stats = apiStatsService.getLoginCount();
        }/* else if(req.getParameter("showAll") == null
                && req.getParameter("userName") == null
                && req.getParameter("email") != null) {
//            stats = apiStatsService.getReportByEmail(req.getParameter("email"));
        }*/

        req.setAttribute("statsList", stats);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("reports.jsp");
        requestDispatcher.forward(req, resp);
    }
}
