package edu.iba.sh.controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

@WebServlet("/StudentSave")
public class StudentSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));
		student.setFirstName(request.getParameter("firstName"));
		student.setGroupNumber(request.getParameter("groupNumber"));
		student.setSecondName(request.getParameter("secondName"));
		
		if (student.getId() < 0){
			addNewStudent(student);
		} else {
			updateStudent(student);
		}
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/jsp/studentForm.jsp").forward(request, response);
	}

	private void updateStudent(Student student) throws ServletException {
		try {
			DaoFactory.getStudentDao().update(student);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

	private void addNewStudent(Student student) throws ServletException {
		try {
			DaoFactory.getStudentDao().create(student);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
