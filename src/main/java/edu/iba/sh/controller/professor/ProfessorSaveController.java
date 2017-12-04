package edu.iba.sh.controller.professor;

import edu.iba.sh.bean.Professor;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProfessorSave")
public class ProfessorSaveController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Professor professor = new Professor();
        professor.setId(Integer.parseInt(request.getParameter("id")));
        professor.setFirstName(request.getParameter("firstName"));
        professor.setSecondName(request.getParameter("secondName"));
        professor.setFatherName(request.getParameter("fatherName"));
        professor.setBirthDate(request.getParameter("birthDate"));
        professor.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));

        if (professor.getId() < 0){
            addNewProfessor(professor);
        } else {
            updateProfessor(professor);
        }

        request.setAttribute("professor", professor);
        request.getRequestDispatcher("/WEB-INF/jsp/professorForm.jsp").forward(request, response);
    }

    private void updateProfessor(Professor professor) throws ServletException {
        try {
            DaoFactory.getProfessorDao().update(professor);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

    private void addNewProfessor(Professor professor) throws ServletException {
        try {
            DaoFactory.getProfessorDao().create(professor);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }
}
