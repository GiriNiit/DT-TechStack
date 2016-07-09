package com.company.dao;

import java.util.List;

import com.company.model.Product;

public interface ProductDAO {
	public void addProduct( Product product );
	public void deleteProduct( int productId );
	public void updateProduct( Product product );
	public List<Product> getAllProductss();
	public Product getProductById( int productId );
	List<Product> getAllProducts();
}