package com.mum.edu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mum.edu.common.RuleSetFactory;
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
		String action = request.getParameter("action");
		
		if("ajaxcall".equals(action)){
			User user = (User)request.getSession().getAttribute("user");
			
//			OrderHistory orderHistory = orderHistoryDAO.getOrderHistory(user.getUserId());
			
			List<String> list = new ArrayList<>();
		    list.add("item1");
		    list.add("item2");
		    list.add("item3");
		    String jsonList = new Gson().toJson(list);
		    
		    
		    Map<String, String> options = new LinkedHashMap<>();
			options.put("orderNumber", "#0000123");
		    options.put("orderDate", "2 days ago");
		    options.put("itemList", jsonList);
		    String json = new Gson().toJson(options);
		    
		    
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    
		} else {
			RequestDispatcher view = request.getRequestDispatcher("resources/jsp/checkout.jsp");
			view.forward(request, response);
		}
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
		OrderHistory orderHistory = new OrderHistory(null, new Date(), cardNumber, state, city, street, zipcode, 
				0.0, phone, email);
		
		try {
			RuleSetFactory.getRuleSet(orderHistory).applyRule(orderHistory);
		} catch (Exception errorMessange) {
			request.setAttribute("error", errorMessange.getMessage());
			request.getRequestDispatcher("resources/jsp/checkout.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		if (user == null || user.getUserName() == null || cart == null || cart.getProductId().size() ==0 || cart.getProducts().size() == 0) {
			request.setAttribute("error", "Can not checkout");
			request.getRequestDispatcher("resources/jsp/checkout.jsp").forward(request, response);
			return;
		}
		
		List<Product> products = cart.getProducts();
		orderHistory.setUser(user);
		orderHistory.setProductOrders(products);
		orderHistory.setTotalAmount(cart.calculateMoney());
		try {
			orderHistoryDAO.save(orderHistory);
		} catch (SQLException e) {
			request.getRequestDispatcher("resources/jsp/errorPage.jsp").forward(request, response);;
			throw new RuntimeException();
		}
		session.setAttribute("cart", null);
		request.getRequestDispatcher("resources/jsp/thankyou.jsp").forward(request, response);;
	}
	
}
