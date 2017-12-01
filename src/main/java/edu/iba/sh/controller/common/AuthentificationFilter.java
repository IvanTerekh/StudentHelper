package edu.iba.sh.controller.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AuthentificationFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest)){
			chain.doFilter(request, response);	
		}
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		String url = httpServletRequest.getRequestURI();
		
		if (httpServletRequest.getSession().getAttribute("user") != null ||
				url.endsWith("login") ||
				url.endsWith("Authentificate") ||
				url.contains(".")){
			chain.doFilter(request, response);
		} else {
			httpServletResponse.sendRedirect("login");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
