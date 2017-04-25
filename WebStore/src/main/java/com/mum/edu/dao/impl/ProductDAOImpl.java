package com.mum.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mum.edu.config.DBconnection;
import com.mum.edu.dao.ProductDAO;
import com.mum.edu.model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void saveProduct(Product product) {
		String query = "INSERT INTO PRODUCT"
				+ "(PRODUCTID, BRIEF_INFORMATION, DETAIL_INFORMATION, BRAND, PRICE,FIRST_IMAGE,SECOND_IMAGE,COUNT,PRODUCT_NAME) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
		try (Connection con = DBconnection.getMySQLConnection(); Statement stmt = con.createStatement();) {
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1, 0);
			p.setString(2, product.getBriefInformation());
			p.setString(3, product.getDetailInformation());
			p.setString(4, product.getBrand());
			p.setDouble(5, product.getPrice());
			p.setString(6, product.getFirstImage());
			p.setString(7, product.getSecondImage());
			p.setInt(8, product.getCount());
			p.setString(9, product.getProductName());
			p.executeUpdate();
			stmt.close();
		} catch (SQLException s) {
			System.out.println("Exception thrown in retrieveUser ....");
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		} 
	}

	@Override
	public List<Product> getAll() {
		String query = "SELECT * from PRODUCT";
		List<Product> result = new ArrayList<>();
		try (Connection con = DBconnection.getMySQLConnection(); Statement stmt = con.createStatement();) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String briefInformation = rs.getString("BRIEF_INFORMATION");
				String detailInformation = rs.getString("DETAIL_INFORMATION");
				String brand = rs.getString("BRAND");
				String firstImage = rs.getString("FIRST_IMAGE");
				String secondImage = rs.getString("SECOND_IMAGE");
				Double price = rs.getDouble("PRICE");
				Integer count = rs.getInt("COUNT");
				String productName = rs.getString("PRODUCT_NAME");
				Product product = new Product(productName, briefInformation, detailInformation, brand, price, firstImage, secondImage, count);
				result.add(product);
			}
			stmt.close();
		} catch (SQLException s) {
			System.out.println("Exception thrown in retrieveUser ....");
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		} 
		return result;
	}

}
