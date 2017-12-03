package edu.iba.sh.controller.student;

import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentDelete")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		deleteStudent(id);
		request.getRequestDispatcher("/StudentList").forward(request, response);
	}

	private void deleteStudent(int id) throws ServletException {
		try {
			DaoFactory.getStudentDao().deleteById(id);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
