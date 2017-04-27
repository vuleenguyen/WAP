package com.mum.edu.model;

public class Checkout {

	private int cartNumber;
	private String fullName;
	private String street;
	private String city;
	private String zipCode;
	private String state;
	private String Phone;
	private String email;
	private String dateOfOrder;
	private double totalAmount;

	// USERID

	public Checkout() {

	}

	public Checkout(int cartNumbr, String fullName, String street, String city, String zipCode, String state, String phone,
			String email, String dateOfOrder, double totalAmount) {
		super();
		this.cartNumber = cartNumbr;
		this.fullName = fullName;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		Phone = phone;
		this.email = email;
		this.dateOfOrder = dateOfOrder;
		this.totalAmount = totalAmount;
	}

	public int getCartNumber() {
		return getCartNumber();
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}