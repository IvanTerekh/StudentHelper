package edu.iba.sh.controller.group;

import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GroupDelete")
public class GroupDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupNumber = request.getParameter("groupNumber");
        deleteGroup(groupNumber);
        response.sendRedirect("/GroupList");
//        request.getRequestDispatcher("/GroupList").forward(request, response);
    }

    private void deleteGroup(String groupNumber) throws ServletException {
        try {
            DaoFactory.getGroupDao().deleteByGroupNumber(groupNumber);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

}