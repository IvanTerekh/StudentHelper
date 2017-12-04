package edu.iba.sh.controller.professor;

import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProfessorDelete")
public class ProfessorDeleteController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        deleteProfessor(id);
        request.getRequestDispatcher("/ProfessorList").forward(request, response);
    }

    private void deleteProfessor(int id) throws ServletException {
        try {
            DaoFactory.getProfessorDao().deleteById(id);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

}
