package com.mum.edu.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mum.edu.model.Role;
import com.mum.edu.model.User;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest in = (HttpServletRequest)request;
		HttpServletResponse out = (HttpServletResponse) response;
		HttpSession session = in.getSession();
		
		User authenticate = (session != null) ? (User)session.getAttribute("user") : null;
		
		boolean loggedIn = authenticate != null;
		boolean resourceRequest = in.getRequestURI().matches(".*(css|jpg|png|gif|js)");
		
		if (in.getRequestURI().contains("/WebStore/checkout") && !loggedIn) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("resources/jsp/login.jsp");
			dispatcher.forward(request, response);
		} else {
			if (!resourceRequest) {
				out.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
				out.setHeader("Pragma", "no-cache"); // HTTP 1.0.
				out.setDateHeader("Expires", 0); // Proxies.
			}
			if (in.getRequestURI().contains("/WebStore/AdminPanel") || 
					in.getRequestURI().contains("/WebStore/manager")) {
				if (loggedIn && authenticate.getRole() == Role.GUEST) {
					request.getRequestDispatcher("resources/jsp/errorPage.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("resources/jsp/errorPage.jsp").forward(request, response);
				}
			}
			chain.doFilter(in, out);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {

	}

}
