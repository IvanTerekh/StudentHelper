package edu.iba.sh.controller.user;

import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDeleteController
 */
@WebServlet("/UserDelete")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		deleteStudent(user);
		request.getRequestDispatcher("/UserList").forward(request, response);
	}

	private void deleteStudent(String user) throws ServletException {
		try {
			DaoFactory.getUserDao().deleteByUser(user);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
