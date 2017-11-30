package edu.iba.sh.controller.group;

import edu.iba.sh.bean.Group;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GroupList")
public class GroupListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Group> groups = getGroups();

        request.setAttribute("groups", groups);
        request.getRequestDispatcher("WEB-INF/jsp/groupList.jsp").forward(request, response);
    }


    public List<Group> getGroups() throws ServletException {
        try {
            return DaoFactory.getGroupDao().getAll();
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }
}
