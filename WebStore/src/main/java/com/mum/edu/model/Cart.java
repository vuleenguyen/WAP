package com.mum.edu.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
	private List<Integer> productId;
	private List<Product> products;
	private int size;
	private double money;
	
	public Cart() {
		productId = new ArrayList<>();
	}

	public List<Integer> getProductId() {
		return productId;
	}

	public void setProductId(List<Integer> productId) {
		this.productId = productId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void deleteProduct(Integer productId) {

		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (productId.equals(product.getProductId())) {
				iterator.remove();
			}
		}
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		size = productId.size();
		return size;
	}
	
	public double getMoney() {
		money = calculateMoney();
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Double calculateMoney() {
		double result = 0.0;
		for (int i = 0; i < products.size(); i++) {
			result += products.get(i).getPrice();
		}
		return result;
	}

}
