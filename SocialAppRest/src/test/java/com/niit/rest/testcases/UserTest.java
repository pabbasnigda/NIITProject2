package com.niit.rest.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.rest.dao.UserDAO;
import com.niit.rest.config.Dbconfig;
import com.niit.rest.model.Forum;
//import com.nii.model.Job;
import com.niit.rest.model.UserDetails;


@ComponentScan("com.niit.rest")
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
	
	@Ignore
	@Test
	public void addUserTest()
	{
		UserDetails user=new UserDetails();
		user.setUserId(14);
		user.setFirstName("Snigda");
		user.setLastName("pabba");
		user.setEmailId("snigda@gmail.com");
		user.setPassword("56789");
		user.setRole("User");
		user.setStatus("P");
		user.setIsOnline("O");
		assertTrue("Problem in Inserting user", userDAO.addUserDetails(user));

	}

	@Ignore
	@Test
	public void getAllUserTest()
	{
		List<UserDetails> userList=(List<UserDetails>)userDAO.getAllUserDetails();
		assertNotNull("Job list not found ",userList.get(0));
		for(UserDetails user:userList)
		{
			System.out.println("EmailID:"+ user.getEmailId() + "Status:"+ user.getStatus());
		}
	}
	
}
