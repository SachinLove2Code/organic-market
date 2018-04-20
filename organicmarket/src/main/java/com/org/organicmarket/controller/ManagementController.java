package com.org.organicmarket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.organicmarket.util.FileUploadUtility;
import com.org.organicmarketstorage.dao.CategoryDao;
import com.org.organicmarketstorage.dao.ProductDao;
import com.org.organicmarketstorage.dto.Category;
import com.org.organicmarketstorage.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "ManageProducts");

		Product newProduct = new Product();
		newProduct.setSupplierId(1);
		newProduct.setActive(true);

		mv.addObject("product", newProduct);

		if (operation != null) {
			if (operation.equals("product")) {

				mv.addObject("message", "Product Submitted Succesfully!");
			}
		}

		return mv;
	}

	// Handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
			Model model,HttpServletRequest httpServletRequest) {

		// checking if any errors are there
		if (result.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "ManageProducts");
			model.addAttribute("message", "Failed to submit the product!");
			
			return "page";
		}
		logger.info(mProduct.toString());
		productDao.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(httpServletRequest,mProduct.getFile(),mProduct.getCode()); 
		}

		return "redirect:/manage/products?operation=product";
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDao.list();
	}
}
