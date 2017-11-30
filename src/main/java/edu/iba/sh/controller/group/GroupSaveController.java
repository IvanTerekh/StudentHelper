package edu.iba.sh.controller.group;

import edu.iba.sh.bean.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GroupSave")
public class GroupSaveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Group group = new Group();
        group.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));
        group.setGroupNumber(request.getParameter("groupNumber"));

        String oldGroupNumber = request.getParameter("oldGroupNumber");

        if(oldGroupNumber.equals("")){
            addGroup(group);
        } else {
            updateGroup(group);
        }

        request.setAttribute("group", group);
        request.getRequestDispatcher("WEB-INF/jsp/groupForm.jsp").forward(request, response);
    }

    private void updateGroup(Group group) {
        System.out.println("Group was updated");
    }

    private void addGroup(Group group) {
        System.out.println("Group was added");
    }
}
