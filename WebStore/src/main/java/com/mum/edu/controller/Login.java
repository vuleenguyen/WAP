package com.mum.edu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.mum.edu.common.Constant;
import com.mum.edu.dao.UserDAO;
import com.mum.edu.dao.impl.UserDAOImpl;
import com.mum.edu.model.User;

public class Login extends HttpServlet {
	UserDAO userDAO = new UserDAOImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (!Objects.isNull(user)) {
			request.getSession().invalidate();
		} 
		request.getRequestDispatcher("resources/jsp/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String[] rememberMeChk = request.getParameterValues("rememberMeChk");
		try {
			User user = userDAO.getUser(userName);
			if (Objects.isNull(user) || !StringUtils.equals(user.getUserName(), userName) 
					|| !StringUtils.equals(user.getPassWord(), passWord)) {
				request.setAttribute("error", Constant.INVALID_USERNAME_OR_PASSWORD);
				request.getRequestDispatcher("resources/jsp/login.jsp").forward(request, response);
				return;
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if (checkRemember(rememberMeChk)) {
				// add Cookie
				Cookie cookie = new Cookie("username", user.getUserName());
				cookie.setMaxAge(60*60*24);
				response.addCookie(cookie);
			} else {
				// remove Cookie
				Cookie[] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if (StringUtils.equals(cookie.getName(), "username")) {
						cookie.setMaxAge(0);
						cookie.setValue(null);
						response.addCookie(cookie);
					}
				}
			}
			// send redirect to the page 
			response.sendRedirect("product.do");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean checkRemember(String[] rememberMeChk) {
		return rememberMeChk != null && rememberMeChk[0] != null;
	}
}
