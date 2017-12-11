package edu.iba.sh.controller.common;

//import edu.iba.sh.jms.JmsBrowser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class IndexController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> messages = getMessages();
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	private List<String> getMessages(){
		return new ArrayList<String>(){{
			add("message1");
			add("message2");
		}};
//		JmsBrowser jmsBrowser = new JmsBrowser();
//		return jmsBrowser.getMessages();
	}
}
