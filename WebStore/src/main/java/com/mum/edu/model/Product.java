package com.mum.edu.model;

public class Product {
	private Integer productId;
	private String productName;
	private String briefInformation;
	private String detailInformation;
	private String brand;
	private Double price;
	private String firstImage;
	private String secondImage;
	private Integer count;
	

	public Product(String productName, String briefInformation, String detailInformation,
			String brand, Double price, String firstImage, String secondImage, Integer count) {
		this.productName = productName;
		this.briefInformation = briefInformation;
		this.detailInformation = detailInformation;
		this.brand = brand;
		this.price = price;
		this.firstImage = firstImage;
		this.secondImage = secondImage;
		this.count = count;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getBriefInformation() {
		return briefInformation;
	}

	public void setBriefInformation(String briefInformation) {
		this.briefInformation = briefInformation;
	}

	public String getDetailInformation() {
		return detailInformation;
	}

	public void setDetailInformation(String detailInformation) {
		this.detailInformation = detailInformation;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public String getSecondImage() {
		return secondImage;
	}

	public void setSecondImage(String secondImage) {
		this.secondImage = secondImage;
	}
	
	

}
