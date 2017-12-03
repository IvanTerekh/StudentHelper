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

@WebServlet("/Authenticate")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AuthenticationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			User userBean = DaoFactory.getUserDao().getByUserAndPassword(user, password);
			if (userBean == null){
				request.setAttribute("message", "User or password is incorrect");
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("user", userBean);
				response.sendRedirect("Index");
			}
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
