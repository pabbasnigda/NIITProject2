/*package com.niit.rest.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.rest.dao.UserDAO;
import com.niit.rest.config.Dbconfig;
import com.niit.rest.model.UserDetails;


@ComponentScan("com.niit.rest.*")
public class UserTest 
{
	@Autowired
	private static UserDAO  userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.rest.*");
		context.refresh();

		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void saveUserTest()
	{
		UserDetails user= new UserDetails();
		user.setFirstName("Sneha");
		user.setLastName("shetty");
		user.setUserName("sneha12");
		user.setEmail("sneha12@gmail.com");
		user.setContact("9874512356");
		user.setEnabled(true);
		user.setPassword("abcde");
		user.setOnline(true);
		user.setRole("USER1");
		
		assertTrue("problem in creating user",userDAO.saveUser(user));
	}
		
}
*/