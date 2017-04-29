package com.mum.edu.dao;

import java.sql.SQLException;
import java.util.List;

import com.mum.edu.model.OrderHistory;

public interface OrderHistoryDAO {
	
	public void save(OrderHistory orderHistory) throws SQLException;
	
	public List<OrderHistory> getOrderHistory(Integer userId);
}
