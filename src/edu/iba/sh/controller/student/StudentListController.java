package edu.iba.sh.controller.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.Student;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/StudentList")
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = getStudentList();
		request.setAttribute("studentList", students);
		request.getRequestDispatcher("/WEB-INF/jsp/studentList.jsp").forward(request, response);
	}
	
	private List <Student> getStudentList(){
		List <Student> list = new ArrayList <Student>();
		
		Student s = new Student();
		s.setId(1);
		s.setAvgMark(2);
		s.setFirstName("Pavel");
		s.setGroupNumber("11");
		s.setSecondName("Piniuta");
		list.add(s);
		
		s = new Student();
		s.setId(2);
		s.setAvgMark(9);
		s.setFirstName("Yauheniya");
		s.setGroupNumber("10");
		s.setSecondName("Makarevich");
		list.add(s);
		
		s = new Student();
		s.setId(3);
		s.setAvgMark(8.5);
		s.setFirstName("Ivan");
		s.setGroupNumber("10");
		s.setSecondName("Terekh");
		list.add(s);
		
		return list;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
