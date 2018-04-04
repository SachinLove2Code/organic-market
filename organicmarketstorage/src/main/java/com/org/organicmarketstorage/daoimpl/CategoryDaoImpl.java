package com.org.organicmarketstorage.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.organicmarketstorage.dao.CategoryDao;
import com.org.organicmarketstorage.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	static {
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
		String hql = "From Category Where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("active", true);
		return query.getResultList();
	}

	// getting single category based on id
	@Override
	public Category get(int id) {
		/*
		 * for (Category category : categories) { if(category.getId() == id)
		 * return category; }
		 */
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override

	public boolean add(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// updationg the single category
	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
