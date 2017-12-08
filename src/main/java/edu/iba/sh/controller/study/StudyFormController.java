package edu.iba.sh.controller.study;

import edu.iba.sh.bean.Student;
import edu.iba.sh.bean.Study;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudyForm")
public class StudyFormController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Study study;
        if (idStr == null) {
            study = new Study();
            study.setId(-1);
        } else {
            int id = Integer.parseInt(idStr);
            study = getStudy(id);
        }

        request.setAttribute("study", study);
        request.getRequestDispatcher("/WEB-INF/jsp/studyForm.jsp").forward(request, response);
    }

    private Study getStudy(int id) throws ServletException {
        try {
            return DaoFactory.getStudyDao().getById(id);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }
}
