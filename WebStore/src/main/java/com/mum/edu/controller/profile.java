package com.mum.edu.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateUtils;

import com.mum.edu.dao.OrderHistoryDAO;
import com.mum.edu.dao.UserDAO;
import com.mum.edu.dao.impl.OrderHistoryDAOImpl;
import com.mum.edu.dao.impl.UserDAOImpl;
import com.mum.edu.model.OrderHistory;
import com.mum.edu.model.User;

@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAOImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CHECK IF USER LOGGED-IN
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.getRequestDispatcher("resources/jsp/login.jsp").forward(request, response);
		}
		
		List<OrderHistory> orderHistory = orderHistoryDAO.getOrderHistory(user.getUserId());
		
		request.setAttribute("orderHistory", orderHistory);
		request.setAttribute("currentUser", user);
		request.getRequestDispatcher("resources/jsp/profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// UPDATE USERINFO
		
		// CHECK IF USER LOGGED-IN
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.getRequestDispatcher("resources/jsp/login.jsp").forward(request, response);
		}
		
		// GET INFO FROM FORM
		String email = request.getParameter("email");
		String fName = request.getParameter("fName");
		String bdate = request.getParameter("bdate");
		String password = request.getParameter("password"); 
		
		user.setFullName(fName);
		user.setBirthDate(parseDate(bdate));
		user.setEmail(email);
		user.setPassWord(password);
		
		UserDAO userDAO = new UserDAOImpl();
		
		userDAO.update(user);
		
		request.setAttribute("currentUser", user);
		request.setAttribute("currentUser", user);
		request.setAttribute("successMsg", "<div class='alert alert-success'>Your profile updated successfully !</div>");
		
		request.getRequestDispatcher("resources/jsp/profile.jsp").forward(request, response);
	}
	
	private Date parseDate(String date) {
		try {
			return DateUtils.parseDate(date, "mm-DD-yyyy");
		} catch (ParseException e) {
			return null;
		}
	}
	
}
