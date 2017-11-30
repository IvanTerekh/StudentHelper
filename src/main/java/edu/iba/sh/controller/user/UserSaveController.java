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
 * Servlet implementation class StudentSaveController
 */
@WebServlet("/UserSave")
public class UserSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		user.setUser(request.getParameter("user"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		
		String oldUser = request.getParameter("oldUser");
		
		if (oldUser.equals("")){
			addNewUser(user);
		} else {
			updateUser(user, oldUser);
		}
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/userForm.jsp").forward(request, response);
	}

	private void updateUser(User user, String oldUser) throws ServletException {
		try {
			DaoFactory.getUserDao().update(user, oldUser);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

	private void addNewUser(User user) throws ServletException {
		try {
			DaoFactory.getUserDao().create(user);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
