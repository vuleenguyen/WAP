package com.mum.edu.dao;

import java.util.List;

import com.mum.edu.model.Product;

public interface ProductDAO {
	
	public void saveProduct(Product product);
	
	public List<Product> getAll();
}
