package com.mum.edu.dao;

import java.sql.SQLException;

import com.mum.edu.model.OrderHistory;

public interface OrderHistoryDAO {
	
	public void save(OrderHistory orderHistory) throws SQLException;
}
