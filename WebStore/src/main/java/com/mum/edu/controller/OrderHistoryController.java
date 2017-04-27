package com.mum.edu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mum.edu.dao.OrderHistoryDAO;
import com.mum.edu.dao.impl.OrderHistoryDAOImpl;
import com.mum.edu.model.Cart;
import com.mum.edu.model.OrderHistory;
import com.mum.edu.model.Product;
import com.mum.edu.model.User;

@WebServlet("/checkout")
public class OrderHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("resources/jsp/checkout.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipCode");
		String state = request.getParameter("state");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String cardNumber = request.getParameter("cartNumber");
		
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		if (user == null || user.getUserName() == null || cart == null || cart.getProductId().size() ==0 || cart.getProducts().size() == 0) {
			request.setAttribute("error", "Can not checkout");
			request.getRequestDispatcher("resources/jsp/checkout.jsp").forward(request, response);
			return;
		}
		
		
		List<Product> products = cart.getProducts();
		OrderHistory orderHistory = new OrderHistory(user, new Date(), cardNumber, state, city, street, zipcode, 
				calculate(products), phone, email);
		orderHistory.setProductOrders(products);
		try {
			orderHistoryDAO.save(orderHistory);
			session.setAttribute("cart", null);
		} catch (SQLException e) {
			request.getRequestDispatcher("resources/jsp/errorPage.jsp").forward(request, response);;
			throw new RuntimeException();
		}
		request.getRequestDispatcher("resources/jsp/thankyou.jsp").forward(request, response);;
	}
	
	private double calculate(List<Product> products) {
		double result = 0.0;
		for(int i=0; i < products.size() ; i++) {
			result += products.get(i).getPrice();
		}
		return result;
	}
}
