package com.mum.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mum.edu.config.DBconnection;
import com.mum.edu.dao.OrderHistoryDAO;
import com.mum.edu.model.OrderHistory;
import com.mum.edu.model.Product;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
	
	@Override
	public void save(OrderHistory orderHistory) throws SQLException {
		String query = "INSERT INTO ORDERHISTORY"
				+ "(ORDERID, USERID, DATE_OF_ORDER, CART_NUMBER, STATE,CITY,STREET,ZIPCODE,TOTAL_AMOUNT,PHONE,EMAIL) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		String queryToInsertOrder_Product = "INSERT INTO ORDERHISTORY_PRODUCT (ID,ORDERID,PRODUCTID) VALUES (?,?,?)";
		String updateProduct = "UPDATE PRODUCT SET count = count - ? WHERE PRODUCTID = ?";
		Connection con = null;
		try {
			con = DBconnection.getMySQLConnection();
			con.setAutoCommit(false);
			
			PreparedStatement p = con.prepareStatement(query, com.mysql.jdbc.Statement.RETURN_GENERATED_KEYS);
			p.setInt(1, 0);
			p.setInt(2, orderHistory.getUser().getUserId());
			p.setDate(3, new java.sql.Date(orderHistory.getOrderDate().getTime()));
			p.setString(4, orderHistory.getCardNumber());
			p.setString(5, orderHistory.getState());
			p.setString(6, orderHistory.getCity());
			p.setString(7, orderHistory.getStreet());
			p.setString(8, orderHistory.getZipCode());
			p.setDouble(9, orderHistory.getTotalAmount());
			p.setString(10, orderHistory.getPhone());
			p.setString(11, orderHistory.getEmail());

			int executeUpdate = p.executeUpdate();
			if (executeUpdate == 0) {
				throw new SQLException("Create Order failed, now rows affect");
			}
			
			int orderId; // This is order Id to save for products
			
			try (ResultSet generateKeys = p.getGeneratedKeys()) {
				if (generateKeys.next()) {
					orderId = generateKeys.getInt(1);
				} else {
					throw new SQLException("Creating order failed, no id obtained");
				}
			}
			PreparedStatement statementOrder_Product = con.prepareStatement(queryToInsertOrder_Product);
			
			for(Product product : orderHistory.getProductOrders()) {
				statementOrder_Product.setInt(1, 0);
				statementOrder_Product.setInt(2, orderId);
				statementOrder_Product.setInt(3, product.getProductId());
				statementOrder_Product.addBatch();
			}
			statementOrder_Product.executeBatch();
			
			
			PreparedStatement updateProductStm = con.prepareStatement(updateProduct);
			for(Product product : orderHistory.getProductOrders()) {
				updateProductStm.setInt(1, 1);
				updateProductStm.setInt(2, product.getProductId());
				updateProductStm.executeUpdate();
			}
			
			con.commit();
			
			statementOrder_Product.close();
			p.close();
		} catch (SQLException s) {
			System.out.println("Exception thrown in retrieveUser ....");
			if (con != null) con.rollback();
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		} 
	}

}
