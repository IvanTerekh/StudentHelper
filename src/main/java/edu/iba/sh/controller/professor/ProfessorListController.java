package edu.iba.sh.controller.professor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.Professor;
import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

@WebServlet("/ProfessorList")
public class ProfessorListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Professor> professors = getProfessorList();
		request.setAttribute("professors", professors);
		request.getRequestDispatcher("/WEB-INF/jsp/professorList.jsp").forward(request, response);
	}
	
	private List <Professor> getProfessorList() throws ServletException {
		try {
			return DaoFactory.getProfessorDao().getAll();
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}