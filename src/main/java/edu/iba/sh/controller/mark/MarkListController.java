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
import java.util.List;

@WebServlet("/MarkList")
public class MarkListController  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mark> marks = getMarkList();
        request.setAttribute("marks", marks);
        request.getRequestDispatcher("/WEB-INF/jsp/markList.jsp").forward(request, response);
    }

    private List <Student> getStudentList() throws ServletException {
        try {
            return DaoFactory.getStudentDao().getAll();
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

    public List<Mark> getMarkList() throws ServletException {
        try {
            return DaoFactory.getMarkDao().getAll();
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }
}