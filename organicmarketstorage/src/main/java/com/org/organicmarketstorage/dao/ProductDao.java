package com.org.organicmarketstorage.dao;

import java.util.List;

import com.org.organicmarketstorage.dto.Product;

public interface ProductDao {

	List<Product> list();
	
	Product get(int productId);
	
	boolean add(Product product);
	boolean upadte(Product product);
	boolean delete(Product product);
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductByCategory(int category);
	List<Product> getLatestActiveProducts (int count);
	
	
}
