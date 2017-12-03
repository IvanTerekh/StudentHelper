package edu.iba.sh.controller.common;

import edu.iba.sh.bean.User;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AuthFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest)){
			chain.doFilter(request, response);
		}
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;

		String url = httpServletRequest.getRequestURI();

		if (loginRequired(url)){
			User user = (User) httpServletRequest.getSession().getAttribute("user");
			if (loggedIn(user)){
				if (accessGranted(user, url)){
					chain.doFilter(request, response);
				} else {
					httpServletRequest.getRequestDispatcher("WEB-INF/jsp/403.jsp").forward(request, response);
				}
			} else {
				httpServletResponse.sendRedirect("login");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean loggedIn(User user) {
		return user != null;
	}

	private boolean loginRequired(String url) {
		return !(url.endsWith("login") ||
				url.endsWith("Authenticate") ||
				url.contains("."));
	}

	private boolean accessGranted(User user, String url) {
		String role = user.getRole();
		if (url.matches("^.*/\\w*(Form|Save|Delete)$")){
			return accessGrantedForEdit(url, role);
		} else if (url.endsWith("UserList")) {
			return accessGrantedForViewUsers(url, role);
		}
		return true;
	}

	private boolean accessGrantedForViewUsers(String url, String role) {
		return role.equals("admin");
	}

	private boolean accessGrantedForEdit(String url, String role) {
		if (role.equals("admin")){
			return true;
		} else if (role.equals("professor")){
			return url.matches("^.*/Mark\\w*$");
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
