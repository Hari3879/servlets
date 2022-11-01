package com.ojas.Dao;

import java.util.List;

import com.ojas.model.Products;

public interface ProductDao {
	public String createProduct(Products product);
	public Products viewProduct(int pid);
	public List<Products> viewAllProducts();
	public String updateProduct(int pid,Products updateProduct);
	public String deleteProduct(int pid);

}
