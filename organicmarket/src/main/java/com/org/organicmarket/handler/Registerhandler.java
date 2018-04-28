package com.org.organicmarket.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.org.organicmarket.model.RegisterModel;
import com.org.organicmarketstorage.dao.UserDao;
import com.org.organicmarketstorage.dto.Address;
import com.org.organicmarketstorage.dto.Cart;
import com.org.organicmarketstorage.dto.User;

@Component
class Registerhandler {

	@Autowired
	private UserDao userDao;
	
	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel,User user){
		
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel,Address billing){
		registerModel.setBilling(billing);
	}
	
	public String validateUser(User user, MessageContext error){
		String transtionvalue ="success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password dose not match confirm passord!").build());
			transtionvalue = "failure";
		}
		
		// unique email address
		
		if(userDao.getByEmail(user.getEmail()) != null){
			
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email address is already used !").build());
			transtionvalue = "failure";
		}
		
		return transtionvalue;
	}
	
	public String saveAll(RegisterModel  model){
		String transtionValue = "success";
		
		// fetching the user
		User user = model.getUser();
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		// save the user
		userDao.addUser(user);
		
		// fetch the address
		
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		//save the address
		userDao.addAddress(billing);
		
		return transtionValue;
	}
}
