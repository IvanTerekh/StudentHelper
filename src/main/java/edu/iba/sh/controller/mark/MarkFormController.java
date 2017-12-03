package edu.iba.sh.controller.mark;

import edu.iba.sh.bean.Mark;
import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MarkForm")
public class MarkFormController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Mark mark;
        if (idStr == null) {
            mark = new Mark();
            mark.setId(-1);
        } else {
            int id = Integer.parseInt(idStr);
            mark = getMark(id);
        }

        request.setAttribute("mark", mark);
        request.getRequestDispatcher("/WEB-INF/jsp/markForm.jsp").forward(request, response);
    }

    private Mark getMark(int id) throws ServletException {
        try {
            return DaoFactory.getMarkDao().getById(id);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

}