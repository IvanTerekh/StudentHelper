package edu.iba.sh.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.User;

/**
 * Servlet implementation class StudentForm
 */
@WebServlet("/UserForm")

public class UserFormController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("user");
		User user;
		if (idStr == null){
			user = new User();
			user.setUser("");
		} else {
			user = getUser(idStr);
		}
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/studentForm.jsp").forward(request, response);
	}

	private User getUser(String id) {
		//user to return
		User user = new User();
		user.setUser(id);
		user.setPassword("password");
		user.setRole("Admin");
		return user;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
