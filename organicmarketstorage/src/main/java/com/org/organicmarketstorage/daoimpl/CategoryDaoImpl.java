package com.org.organicmarketstorage.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.org.organicmarketstorage.dao.CategoryDao;
import com.org.organicmarketstorage.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();
	
	static{
		Category category = new Category();
		category.setId(1);
		category.setName("Product 1");
		category.setDiscription("Discription for Product 1");
		category.setImageURL("CAT_1.PNG");
		categories.add(category);
		 
		  category = new Category();
			category.setId(2);
			category.setName("Product 2");
			category.setDiscription("Discription for Product 2");
			category.setImageURL("CAT_1.PNG");
			categories.add(category);
			
			category = new Category();
			category.setId(3);
			category.setName("Product 3");
			category.setDiscription("Discription for Product 3");
			category.setImageURL("CAT_1.PNG");
			categories.add(category);
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
		
		for (Category category : categories) {
			if(category.getId() == id) return category;
		}
		return null;
	}

}
