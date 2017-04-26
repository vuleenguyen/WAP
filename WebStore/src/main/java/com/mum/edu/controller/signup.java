package com.mum.edu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateUtils;

import com.mum.edu.common.Constant;
import com.mum.edu.dao.UserDAO;
import com.mum.edu.dao.impl.UserDAOImpl;
import com.mum.edu.model.Role;
import com.mum.edu.model.User;

@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO userDAO = new UserDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("resources/jsp/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// AFTER SUBMIT
		// GET FIELD VALUES FROM "JSP FILE"
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String fName = request.getParameter("fName");
		String bdate = request.getParameter("bdate");
		String password = request.getParameter("password");


		// check if user name already exists
		try {
			if (userDAO.getUser(userName) != null) {
				request.setAttribute("error", "User is registered");
				request.getRequestDispatcher("resources/jsp/signup.jsp");
				return;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		User user = new User(userName, password, fName, null, null, null, null, null, parseDate(bdate), email,
				Role.GUEST);
		userDAO.save(user);
	}

	private Date parseDate(String date) {
		try {
			return DateUtils.parseDate(date, "mm-DD-yyyy");
		} catch (ParseException e) {
			return null;
		}
	}

}
