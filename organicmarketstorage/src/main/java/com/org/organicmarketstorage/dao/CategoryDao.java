package com.org.organicmarketstorage.dao;

import java.util.List;

import com.org.organicmarketstorage.dto.Category;

public interface CategoryDao {

	
	List<Category> list();
	Category get(int id);
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
}
