package com.org.organicmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.organicmarketstorage.dao.ProductDao;
import com.org.organicmarketstorage.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JasonDataController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		return productDao.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id){
		return productDao.listActiveProductByCategory(id);
	}
}
