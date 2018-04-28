package com.org.organicmarketstorage.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.org.organicmarketstorage.dao.UserDao;
import com.org.organicmarketstorage.dto.Address;
import com.org.organicmarketstorage.dto.Cart;
import com.org.organicmarketstorage.dto.User;

/**
 * @author Sachin
 *
 */
public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user;
	private Cart cart;
	private Address address;
	
	/**
	 * 
	 */
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.org.organicmarketstorage");
		context.refresh();
		
		userDao = (UserDao) context.getBean("userDao");
	}

}
