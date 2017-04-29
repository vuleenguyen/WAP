package com.mum.edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderHistory {

	private int orderHistoryId;
	private User user;
	private Date orderDate;
	private String cardNumber;
	private String state;
	private String city;
	private String street;
	private String zipCode;
	private double totalAmount;

	private String phone;
	private String email;
	
	// list product to Checkout
	private List<Product> productOrders;
	
	public OrderHistory(){};
	
	public OrderHistory(User user, Date orderDate, String cardNumber, String state, String city, String street,
			String zipCode, double totalAmount, String phone, String email) {
		this.user = user;
		this.orderDate = orderDate;
		this.cardNumber = cardNumber;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.totalAmount = totalAmount;
		this.phone = phone;
		this.email = email;
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Product> getProductOrders() {
		if (productOrders == null) {
			return new ArrayList<>();
		}
		return productOrders;
	}

	public void setProductOrders(List<Product> productOrders) {
		this.productOrders = productOrders;
	}
	

}
