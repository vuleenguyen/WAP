package com.mum.edu.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

import com.mum.edu.common.Constant;
import com.mum.edu.dao.ProductDAO;
import com.mum.edu.dao.impl.ProductDAOImpl;
import com.mum.edu.model.Product;

@MultipartConfig
public class ProductManager extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (StringUtils.equals(action, "insert")) {
			request.getRequestDispatcher("resources/jsp/insertProduct.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("resources/jsp/productManager.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String realPath = request.getServletContext().getRealPath(Constant.IMAGE_RESOURCE);
		realPath = customPath(realPath);

		String productName = request.getParameter("productName");
		String briefInformation = request.getParameter("briefInformation");
		String detailInformation = request.getParameter("detailInformation");
		String brand = request.getParameter("brand");
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer count = Integer.parseInt(request.getParameter("count"));

		Product product = new Product(productName, briefInformation, detailInformation, brand, price, null, null,
				count);

		String firstImage = uploadImpage(request.getPart("firstImage"), realPath);
		String secondImage = uploadImpage(request.getPart("secondImage"), realPath);
		product.setFirstImage(firstImage);
		product.setSecondImage(secondImage);
		
		productDAO.saveProduct(product);
	}

	private String uploadImpage(Part filePart, String realPath) throws IOException {
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		File file = new File(realPath + File.separator + fileName);
		try (InputStream input = filePart.getInputStream()) {
			Files.copy(input, file.toPath());
		}
		return fileName;
	}

	private String customPath(String realPath) {
		return realPath.replaceAll("\\\\", "/");
	}
}
