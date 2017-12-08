package edu.iba.sh.controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

@WebServlet("/StudentList")
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = getStudentList();
		request.setAttribute("studentList", students);
		request.getRequestDispatcher("/WEB-INF/jsp/studentList.jsp").forward(request, response);
	}
	
	private List <Student> getStudentList() throws ServletException {
		try {
			return DaoFactory.getStudentDao().getAll();
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
