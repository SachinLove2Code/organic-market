package com.org.organicmarketstorage.dao;

import java.util.List;

import com.org.organicmarketstorage.dto.Address;
import com.org.organicmarketstorage.dto.Cart;
import com.org.organicmarketstorage.dto.User;

public interface UserDao {

	boolean addUser(User user);
	
	User getByEmail(String email);
	
	boolean updateCart(Cart cart);
	
	boolean addAddress(Address address);
	
	Address getBillingAddess(User user);
	List<Address> listShippingAddresses(User user);
	
}
