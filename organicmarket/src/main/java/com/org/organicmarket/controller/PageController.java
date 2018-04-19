package com.org.organicmarket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.organicmarket.exception.ProductNotFoundException;
import com.org.organicmarketstorage.dao.CategoryDao;
import com.org.organicmarketstorage.dao.ProductDao;
import com.org.organicmarketstorage.dto.Category;
import com.org.organicmarketstorage.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("inside pg - Info");
		logger.debug("inside pg - DEBUG");
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch the single category
		Category category = null;
		 category = categoryDao.get(id);
		
		 // passing the list of the category
		 mv.addObject("categories", categoryDao.list());
		 
		 // passing the single category
		 mv.addObject("category", category);
		 
		mv.addObject("title",category.getName());

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	
/*
 *  single view product page
 * 
 */
	
	@RequestMapping(value ="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		Product product = productDao.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		// update the view count
		product.setViews(product.getViews() +1);
		productDao.upadte(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowproduct", true);
		return mv;
	}
	
	
	
	
	
}
