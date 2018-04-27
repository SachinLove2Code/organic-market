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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.org.organicmarket.util.FileUploadUtility;
import com.org.organicmarket.validator.ProductValidator;
import com.org.organicmarketstorage.dao.CategoryDao;
import com.org.organicmarketstorage.dao.ProductDao;
import com.org.organicmarketstorage.dto.Category;
import com.org.organicmarketstorage.dto.Product;

/**
 * @author Sachin
 *
 */
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
			}else if(operation.equals("category")){
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}
		return mv;
	}

	// handling edit product
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "ManageProducts");
		
		Product nProduct = productDao.get(id);
		mv.addObject("product", nProduct);
		return mv;
		
	}
	
	// Handling product submission
	

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
			Model model,HttpServletRequest httpServletRequest) {

		if(mProduct.getId() == 0){
			new ProductValidator().validate(mProduct, result);
		}else{
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, result);
			}
		}
		
		
		// checking if any errors are there
		if (result.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "ManageProducts");
			model.addAttribute("message", "Failed to submit the product!");
			
			return "page";
		}
		logger.info(mProduct.toString());
		if(mProduct.getId() == 0){
			// create a new product record
		productDao.add(mProduct);
		}else{
			// updating the product if id is not 0
			productDao.upadte(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(httpServletRequest,mProduct.getFile(),mProduct.getCode()); 
		}

		return "redirect:/manage/products?operation=product";
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDao.list();
	}
	
	@RequestMapping(value ="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String productActivation(@PathVariable int id){
		// is going to fetch the product by id fro data basse
		Product product = productDao.get(id);
		boolean isActive = product.isActive();
		
		// activation and deactivating
		product.setActive(!product.isActive());
		productDao.upadte(product);
		return (isActive)? "You have successfully deactivated the product with id " + product.getId() 
		: "You have successfully activated the product with id " + product.getId();
	}
	
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
	
	
	// handling category submission
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String addingNewCategory(@ModelAttribute Category category){
		// adding a new category
		categoryDao.add(category);
		return "redirect:/manage/products?operation=category";
		
	}
	
	
	
	
	
}
