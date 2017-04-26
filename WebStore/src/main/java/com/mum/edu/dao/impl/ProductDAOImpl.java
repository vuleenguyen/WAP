package com.mum.edu.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mum.edu.config.DBconnection;
import com.mum.edu.dao.ProductDAO;
import com.mum.edu.model.Cart;
import com.mum.edu.model.Product;
import com.mum.edu.model.User;

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
	public void updateProduct(Product product ,int idToUpdate) {

		
		String query = "UPDATE PRODUCT "+
                " SET PRODUCT_NAME =IFNULL(? , PRODUCT_NAME)," +
                          "BRIEF_INFORMATION =IFNULL(? , BRIEF_INFORMATION)," +
                          "DETAIL_INFORMATION =IFNULL(? , DETAIL_INFORMATION)," +
                          "PRICE = GREATEST(?, -1 )"+
                          " WHERE PRODUCTID="+idToUpdate;
		
		try (Connection con = DBconnection.getMySQLConnection(); Statement stmt = con.createStatement();) {
			PreparedStatement p = con.prepareStatement(query);
			p.setString(1, product.getProductName());
			p.setString(2, product.getBriefInformation());
			p.setString(3, product.getDetailInformation());
			p.setDouble(4, product.getPrice());
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
	public void deleteProduct(int idToDel) {
		String query = "delete from product where PRODUCTID = ?";
		
		try (Connection con = DBconnection.getMySQLConnection(); Statement stmt = con.createStatement();) {
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1, idToDel);
			p.execute();
			stmt.close();
		} catch (SQLException s) {
			System.out.println("Exception thrown in retrieveUser ....");
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
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
		    	prod.setProductId( rs.getInt("PRODUCTID"));
		    	prod.setProductName(rs.getString("PRODUCT_NAME"));
		    	prod.setBriefInformation(rs.getString("BRIEF_INFORMATION"));
		    	prod.setDetailInformation(rs.getString("DETAIL_INFORMATION"));
		    	prod.setPrice(rs.getDouble("PRICE"));
		    	prod.setBrand(rs.getString("BRAND"));
		    	
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
				Integer productId = rs.getInt("PRODUCTID");
				String briefInformation = rs.getString("BRIEF_INFORMATION");
				String detailInformation = rs.getString("DETAIL_INFORMATION");
				String brand = rs.getString("BRAND");
				String firstImage = rs.getString("FIRST_IMAGE");
				String secondImage = rs.getString("SECOND_IMAGE");
				Double price = rs.getDouble("PRICE");
				Integer count = rs.getInt("COUNT");
				String productName = rs.getString("PRODUCT_NAME");
				Product product = new Product(productName, briefInformation, detailInformation, brand, price, firstImage, secondImage, count);
				product.setProductId(productId);
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

	@Override
	public List<Product> getProducts(Cart cart) {
		List<Integer> productIds = cart.getProductId();
		List<Product> result = new ArrayList<>();
		for(Integer productId : productIds) {
			Product product = getProduct(productId);
			result.add(product);
		}
		return result;
	}

	private Product getProduct(Integer productId) {
		String query = "SELECT * from PRODUCT where PRODUCTID = '" + productId + "';";
		Product product = null;
		try (Connection con = DBconnection.getMySQLConnection(); Statement stmt = con.createStatement();) {
			System.out.println("the query: " + query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Integer id = rs.getInt("PRODUCTID");
				String briefInformation = rs.getString("BRIEF_INFORMATION");
				String detailInformation = rs.getString("DETAIL_INFORMATION");
				String brand = rs.getString("BRAND");
				String firstImage = rs.getString("FIRST_IMAGE");
				String secondImage = rs.getString("SECOND_IMAGE");
				Double price = rs.getDouble("PRICE");
				Integer count = rs.getInt("COUNT");
				String productName = rs.getString("PRODUCT_NAME");
				product = new Product(productName, briefInformation, detailInformation, brand, price, firstImage, secondImage, count);
				product.setProductId(id);
			}
			stmt.close();
		} catch (SQLException s) {
			System.out.println("Exception thrown in retrieveUser ....");
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
		return product;
	}

	@Override
	public Product getProducts(int productId) {
		return getProduct(productId);
	}

}
