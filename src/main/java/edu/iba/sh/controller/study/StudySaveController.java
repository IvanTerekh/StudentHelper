package edu.iba.sh.controller.study;

import edu.iba.sh.bean.Study;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudySave")
public class StudySaveController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Study study = new Study();
        study.setId(Integer.parseInt(request.getParameter("id")));
        study.setName(request.getParameter("name"));
        study.setHours(Integer.parseInt(request.getParameter("hours")));
        study.setProfessorId(Long.parseLong(request.getParameter("professorId")));
        study.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));

        if (study.getId() < 0){
            addNewStudy(study);
        } else {
            updateStudy(study);
        }

        request.setAttribute("study", study);
        request.getRequestDispatcher("/WEB-INF/jsp/studyForm.jsp").forward(request, response);
    }

    private void updateStudy(Study study) throws ServletException {
        try {
            DaoFactory.getStudyDao().update(study);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

    private void addNewStudy(Study study) throws ServletException {
        try {
            DaoFactory.getStudyDao().create(study);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }
}