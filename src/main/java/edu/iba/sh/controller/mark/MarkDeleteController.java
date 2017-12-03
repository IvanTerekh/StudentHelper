package edu.iba.sh.controller.mark;

import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MarkDelete")
public class MarkDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        deleteMark(id);
        request.getRequestDispatcher("/MarkList").forward(request, response);
    }

    private void deleteMark(int id) throws ServletException {
        try {
            DaoFactory.getMarkDao().deleteById(id);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

}
