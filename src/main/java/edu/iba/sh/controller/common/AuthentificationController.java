package edu.iba.sh.controller.common;

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
 * Servlet implementation class AuthentificationController
 */
@WebServlet("/Authenticate")
public class AuthentificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			User userBean = DaoFactory.getUserDao().getByUserAndPassword(user, password);
			if (userBean == null){
				request.setAttribute("message", "User or password is incorrect");
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("Index");
			}
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
