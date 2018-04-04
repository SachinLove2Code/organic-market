package com.org.organicmarketstorage.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.org.organicmarketstorage.dao.CategoryDao;
import com.org.organicmarketstorage.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDao categoryDao;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.org.organicmarketstorage");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}

/*	@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("Product 1");
		category.setDiscription("Discription for Product 1");
		category.setImageURL("CAT_1.PNG");
		
		assertEquals("Suucessfully added a category inside the table!", true, categoryDao.add(category));

	}*/
	
	
	@Test
	public void testCRUDCategory() {
		category = new Category();

		category.setName("Product 4");
		category.setDiscription("Discription for Product 4");
		category.setImageURL("CAT_4.PNG");
		
		assertEquals("Sucessfully added a category inside the table!", true, categoryDao.add(category));
		
//		fetching the and updating the category based on id
		category = categoryDao.get(2);
		category.setName("Product 1");
		assertEquals("Successfully updating the category based on id",true,categoryDao.update(category));
		
		// deleting the category
		assertEquals("Successfully delete the category from table based on id",true,categoryDao.delete(category));
		
		// fetching the list of category
		assertEquals("Successfully fetching  the list from table ",1, categoryDao.list().size());

	}
}
