package com.mum.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mum.edu.dao.ProductDAO;
import com.mum.edu.dao.impl.ProductDAOImpl;
import com.mum.edu.model.Cart;
import com.mum.edu.model.Product;

public class ProductController extends HttpServlet implements Controller {
	
	private static final long serialVersionUID = 1L;
	
	private ProductDAO dao = new ProductDAOImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart shoppingCart;
		if (request.getParameter("addCart") != null) {
			HttpSession session = request.getSession();
			shoppingCart = (Cart) session.getAttribute("cart");
			if (shoppingCart == null) {
				shoppingCart = new Cart();
				session.setAttribute("cart", shoppingCart);
			}
			Integer productId = Integer.parseInt(request.getParameter("addCart"));
			shoppingCart.getProductId().add(productId);
			session.setAttribute("cart", shoppingCart);
		} 
		
		List<Product> products = dao.getAll();
		request.setAttribute("products", products);
		request.getRequestDispatcher("resources/jsp/product.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
}
