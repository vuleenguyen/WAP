package com.mum.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mum.edu.dao.ProductDAO;
import com.mum.edu.dao.impl.ProductDAOImpl;
import com.mum.edu.model.Product;

public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO = new ProductDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		Product product = productDAO.getProducts(productId);
		request.setAttribute("product", product);
		request.getRequestDispatcher("resources/jsp/productDetail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
