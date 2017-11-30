package edu.iba.sh.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.User;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/UserList")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = getUserList();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp").forward(request, response);
	}
	
	private List <User> getUserList() throws ServletException {
		try {
			return DaoFactory.getUserDao().getAll();
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
