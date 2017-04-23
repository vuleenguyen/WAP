package com.mum.edu.model;

import java.util.Date;
import java.util.List;

public class Order {
	
	private Integer orderId;
	private Date orderDate;
	private String orderInformation;
	private User user;
	private List<Product> orderProducts;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderInformation() {
		return orderInformation;
	}
	public void setOrderInformation(String orderInformation) {
		this.orderInformation = orderInformation;
	}
	public List<Product> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<Product> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
	
}
