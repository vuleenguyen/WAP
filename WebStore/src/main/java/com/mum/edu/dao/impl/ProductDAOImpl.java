package com.mum.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mum.edu.config.DBconnection;
import com.mum.edu.dao.ProductDAO;
import com.mum.edu.model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void saveProduct(Product product) {
		String query = "INSERT INTO PRODUCT"
				+ "(PRODUCTID, BRIEF_INFORMATION, DETAIL_INFORMATION, BRAND, PRICE,FIRST_IMAGE,SECOND_IMAGE,COUNT) VALUES"
				+ "(?,?,?,?,?,?,?,?)";
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
			p.executeUpdate();
			stmt.close();
		} catch (SQLException s) {
			System.out.println("Exception thrown in retrieveUser ....");
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		} 
	}

}
