package com.mum.edu.dao.impl;

import java.sql.*;
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
	public void updateProduct(Product product) {

		String query = "UPDATE PRODUCT SET PRICE=? , " + "BRIEF_INFORMATION=? ," + "DETAIL_INFORMATION=? ,"
				+ "count= ?";

		try (Connection con = DBconnection.getMySQLConnection(); Statement stmt = con.createStatement();) {
			PreparedStatement p = con.prepareStatement(query);
			p.setDouble(1, product.getPrice());
			p.setString(2, product.getBriefInformation());
			p.setString(3, product.getDetailInformation());
			p.setInt(4, product.getCount());
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
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub

	}
	
	public List<Product> getProducts() {
		List<Product> productList = new ArrayList<>();

		String query = "SELECT * FROM PRODUCT";

		try (Connection con = DBconnection.getMySQLConnection(); Statement stmt = con.createStatement();) {
			PreparedStatement p = con.prepareStatement(query);
			
		    ResultSet rs = stmt.executeQuery(query);

		    while (rs.next())
		      {
		    	Product prod = new Product();
		    	prod.setProductId( rs.getInt("id"));
		    	prod.setProductName(rs.getString("name"));
		    	prod.setBriefInformation(rs.getString("briefInformation"));
		    	prod.setDetailInformation(rs.getString("detailInformation"));
		    	prod.setPrice(rs.getDouble("price"));
		    	prod.setBrand(rs.getString("brand"));
		    	
		    	productList.add(prod);
		      }
		    
			boolean reachable = con.isValid(10);// 10 sec

			System.out.println(reachable);
		    
			stmt.close();
		} catch (SQLException s) {
			System.out.println("Exception thrown in retrieveUser ....");
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return productList;
	}

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
		} catch (SQLException s) {
			System.out.println("Exception thrown in retrieveUser ....");
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}

		return result;
	}
}
