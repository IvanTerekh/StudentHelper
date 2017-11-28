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

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/UserList")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> students = getUserList();
		request.setAttribute("userList", students);
		request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp").forward(request, response);
	}
	
	private List <User> getUserList(){
		List <User> list = new ArrayList <User>();
		
		User user = new User();
		user.setUser("Jane");
		user.setPassword("password");
		user.setRole("Admin");
		
		return list;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
