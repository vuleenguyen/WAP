package com.mum.edu.dao;

import java.util.List;

import com.mum.edu.model.Cart;
import com.mum.edu.model.Product;

public interface ProductDAO {
	
	public void saveProduct(Product product);
	
	public List<Product> getAll();

	public List<Product> getProducts(Cart cart);

	public Product getProducts(int productId);
}
