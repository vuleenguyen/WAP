package com.mum.edu.dao;

import java.util.List;

import com.mum.edu.model.Cart;
import com.mum.edu.model.Product;

public interface ProductDAO {
	
	public void saveProduct(Product product);
	public void updateProduct(Product product,int idToUpdate);
	public void deleteProduct(int idToUpdate);
	public List<Product> getProducts();	
	public List<Product> getAll();

	public List<Product> getProducts(Cart cart);

	public Product getProducts(int productId);
}
