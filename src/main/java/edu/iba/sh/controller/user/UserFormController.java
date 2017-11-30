package edu.iba.sh.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.User;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

/**
 * Servlet implementation class StudentForm
 */
@WebServlet("/UserForm")
public class UserFormController extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userStr = request.getParameter("user");
		User user;
		if (userStr == null){
			user = new User();
			user.setUser("");
		} else {
			user = getUser(userStr);
		}
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/userForm.jsp").forward(request, response);
	}

	private User getUser(String user) throws ServletException {
		try {
			return DaoFactory.getUserDao().getByUser(user);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}
}
