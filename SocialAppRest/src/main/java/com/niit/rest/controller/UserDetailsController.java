package com.niit.rest.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.niit.rest.dao.UserDAO;
import com.niit.rest.model.UserDetails;

@RestController
public class UserDetailsController 
{	
	@Autowired 
	UserDAO userDAO;
		
	@RequestMapping(value="/getAllUsers")
	public List <UserDetails> getAllUser()
	{
		return userDAO.getAllUserDetails();
	}
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDetails userDetail)
	{
		userDetail.setRole("user");
		if(userDAO.addUserDetail(userDetail))
		{
			return new ResponseEntity<UserDetails>(userDetail,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in registration",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginStatus(@RequestBody UserDetails userDetail,HttpSession session)
	{
		UserDetails user=userDAO.getUserDetails(userDetail.getUsername());
		boolean userExists = userDAO.checkLogin(user.getUsername(), user.getPassword());
		System.out.println(userDetail.getUsername());
		
		System.out.print(userExists);
		
		if (userExists) 
		{
			userDAO.updateOnlineStatus("Y",user);
			session.setAttribute("username", user.getUsername());
			return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
		} 
		else 
		{
			Error error = new Error("unable to login user details");
			return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	 
	}
	
	@GetMapping(value = "/logout/{username}")
	public ResponseEntity<String> loggingout(@PathVariable("username") String username) 
	{
		UserDetails user = userDAO.getUserDetails(username);
		if (userDAO.updateOnlineStatus("N", user)) {
			return new ResponseEntity<String>("Successful logout", HttpStatus.OK);
		} 
		else 
		{
			return new ResponseEntity<String>("error in logout", HttpStatus.SERVICE_UNAVAILABLE);
		}
	
	}
}