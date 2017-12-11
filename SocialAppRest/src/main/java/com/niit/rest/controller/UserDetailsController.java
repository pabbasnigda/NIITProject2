package com.niit.rest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.rest.dao.UserDAO;
import com.niit.rest.model.UserDetails;


@RestController
public class UserDetailsController 
{
	@Autowired 
	UserDAO userDAO;
	
	@PostMapping(value="/insertUserDetails")
	public ResponseEntity<String> insertUser(@RequestBody UserDetails user)
	{
		if(userDAO.addUserDetails(user))
		{
			return new ResponseEntity<String>("User Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	
	@PostMapping(value="/deleteUserDetails")
	public ResponseEntity<String> deleteUser(@RequestBody UserDetails user)
	{
		if(userDAO.addUserDetails(user))
		{
			return new ResponseEntity<String>("User deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping(value="/getAllUsers")
	public ResponseEntity<ArrayList<UserDetails>> getAllUserDetails()
	{
		ArrayList listUserDetails=(ArrayList)userDAO.getAllUserDetails();
		return new ResponseEntity<ArrayList<UserDetails>>(listUserDetails,HttpStatus.SERVICE_UNAVAILABLE);
	}

}