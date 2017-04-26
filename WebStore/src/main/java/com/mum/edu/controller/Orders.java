package com.mum.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.mum.edu.dao.ProductDAO;
import com.mum.edu.dao.impl.ProductDAOImpl;
import com.mum.edu.model.Cart;
import com.mum.edu.model.Product;

@WebServlet("/orderList")
public class Orders extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ProductDAO dao = new ProductDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			request.getRequestDispatcher("resources/jsp/orderList.jsp").forward(request, response);
			return;
		}
		if (StringUtils.equals(request.getParameter("action"), "delete")) {
			Integer productId = Integer.parseInt(request.getParameter("productId"));
			cart.getProductId().remove(productId);
			cart.deleteProduct(productId);
			session.setAttribute("cart", cart);
		} else {
			List<Product> products = dao.getProducts(cart);
			if (products != null && !products.isEmpty()) {
				cart.setProducts(products);
				session.setAttribute("cart", cart);
			}
		}
		request.setAttribute("money", calculate(cart.getProducts()));
		request.getRequestDispatcher("resources/jsp/orderList.jsp").forward(request, response);
	}
	
	private double calculate(List<Product> products) {
		double result = 0.0;
		for(int i=0; i < products.size() ; i++) {
			result += products.get(i).getPrice();
		}
		return result;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
