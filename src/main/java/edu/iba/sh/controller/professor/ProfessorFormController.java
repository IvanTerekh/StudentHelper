package edu.iba.sh.controller.professor;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.Professor;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

@WebServlet("/ProfessorForm")
public class ProfessorFormController extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Professor professor;
        if (idStr == null) {
            professor = new Professor();
            professor.setId(-1);
        } else {
            int id = Integer.parseInt(idStr);
            professor = getProfessor(id);
        }

        request.setAttribute("professor", professor);
        request.getRequestDispatcher("/WEB-INF/jsp/professorForm.jsp").forward(request, response);
    }

    private Professor getProfessor(int id) throws ServletException {
        try {
            return DaoFactory.getProfessorDao().getById(id);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

}