package com.org.organicmarketstorage.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.organicmarketstorage.dao.ProductDao;
import com.org.organicmarketstorage.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> list() {
		
		return sessionFactory
				.getCurrentSession()
				   .createQuery("FROM Product" ,Product.class)
				   		.getResultList();
	}

	@Override
	public Product get(int productId) {
		try {
			return sessionFactory
					.getCurrentSession()
						.get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean upadte(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.upadte(product);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return  false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveproducts = "FROM Product Where active=  :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveproducts, Product.class).setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
	  String selectProductbasedOnCategoryId = "FROM Product WHERE active = :active AND categoryId = :categoryId";
	  
		return sessionFactory.getCurrentSession().createQuery(selectProductbasedOnCategoryId,Product.class)
				.setParameter("active", true)
					.setParameter("categoryId", categoryId)
						.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		return null;
	}
}
