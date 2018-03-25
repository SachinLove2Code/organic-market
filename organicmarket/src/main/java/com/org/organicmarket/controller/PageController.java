package com.org.organicmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.organicmarketstorage.dao.CategoryDao;
import com.org.organicmarketstorage.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
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
}
