package com.mum.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mum.edu.dao.ProductDAO;
import com.mum.edu.dao.impl.ProductDAOImpl;
import com.mum.edu.model.Product;

/**
 * Servlet implementation class AdminPanel
 */
@WebServlet("/AdminPanel")
public class AdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPanel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// GET PARAMETERS
		String action 		= request.getParameter("action") == null ? "" :  request.getParameter("action") ;
		int idToUpdate		= request.getParameter("id") == null ? -1 : Integer.parseInt(request.getParameter("id"));
		String name			= request.getParameter("name") == null ? "" : request.getParameter("name");
		String briefInfo	= request.getParameter("briefInformation") == null ? "" : request.getParameter("briefInformation");
		String detailInfo	= request.getParameter("detailInformation") == null ? "" : request.getParameter("detailInformation");
		String brand		= request.getParameter("brand") == null ? "" : request.getParameter("brand");
		
		int count			= request.getParameter("count") == null ? -1 : Integer.parseInt(request.getParameter("count"));
		double price		= request.getParameter("price") == null ? -1 : Double.parseDouble( request.getParameter("price"));
		
		
		//CRATE OBJECTS TO ACCESS DB
		ProductDAO productDAO = new ProductDAOImpl();
		Product product =  new Product(name, briefInfo, detailInfo, brand, price, null, null, count);
		
		switch (action) {
		case "update":
			
			productDAO.updateProduct(product,idToUpdate);
			
			break;
		case "delete":
			productDAO.deleteProduct(idToUpdate);
			break;
		}
		
		List<Product> products = productDAO.getProducts();
		
		for (Product product2 : products) {
			System.out.println(product2.getPrice());
		}
		
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("resources/jsp/adminPanel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
