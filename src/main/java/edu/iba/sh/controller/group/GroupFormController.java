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

@WebServlet("/GroupForm")
public class GroupFormController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupNumber = request.getParameter("groupNumber");
        Group group;
        if (groupNumber == null){
            group = new Group();
            group.setGroupNumber("");
        } else {
            group = getGroup(groupNumber);
        }
        request.setAttribute("group", group);
        request.getRequestDispatcher("/WEB-INF/jsp/groupForm.jsp").forward(request, response);
    }

    private Group getGroup(String groupNumber) throws ServletException {
        try {
            return DaoFactory.getGroupDao().getByGroupNumber(groupNumber);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }
}
