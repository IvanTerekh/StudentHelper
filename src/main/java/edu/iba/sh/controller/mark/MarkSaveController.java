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

@WebServlet("/MarkSave")
public class MarkSaveController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mark mark = new Mark();
        mark.setId(Long.parseLong(request.getParameter("id")));
        mark.setStudyId(Long.parseLong(request.getParameter("studyId")));
        mark.setStudentId(Long.parseLong(request.getParameter("studentId")));
        mark.setDate(request.getParameter("date"));
        mark.setProfessorId(Long.parseLong(request.getParameter("professorId")));
        mark.setMark(Integer.parseInt(request.getParameter("mark")));
        mark.setComments(request.getParameter("comments"));

        if (mark.getId() < 0){
            addNewMark(mark);
        } else {
            updateMark(mark);
        }

        request.setAttribute("mark", mark);
        request.getRequestDispatcher("/WEB-INF/jsp/markForm.jsp").forward(request, response);
    }

    private void updateMark(Mark mark) throws ServletException {
        try {
            DaoFactory.getMarkDao().update(mark);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

    private void addNewMark(Mark mark) throws ServletException {
        try {
            DaoFactory.getMarkDao().create(mark);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

}
