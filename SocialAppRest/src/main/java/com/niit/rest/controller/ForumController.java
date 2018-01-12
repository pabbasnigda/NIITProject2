package com.niit.rest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.rest.dao.ForumDAO;
import com.niit.rest.dao.UserDAO;
import com.niit.rest.model.Blog;
import com.niit.rest.model.Forum;
import com.niit.rest.model.UserDetails;



@RestController
public class ForumController 
{
	@Autowired 
	ForumDAO forumDAO;
	@Autowired
	private UserDAO userDAO;
	
	@PostMapping(value="/insertForum")
	public ResponseEntity<String> insertForum(@RequestBody Forum forum,HttpSession session)
	{
		UserDetails	userDetail=(UserDetails)session.getAttribute("üser");
		
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("N");
		
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@PostMapping(value="/updateForum")
	public ResponseEntity<String> updateForum(@RequestBody Forum forum)
	{
		Forum tempForum=forumDAO.getForum(forum.getForumId());
		
		tempForum.setForumName(forum.getForumName());
		tempForum.setForumContent(forum.getForumContent());
		//tempForum.setUserId(forum.getUserId());
		
		if(forumDAO.updateForum(tempForum))
		{
			return new ResponseEntity<String>("Forum updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@GetMapping(value="/getAllForums")
	public ResponseEntity<ArrayList<Forum>> getAllForums()
	{
		ArrayList listForums=(ArrayList)forumDAO.getAllForums();
		return new ResponseEntity<ArrayList<Forum>>(listForums,HttpStatus.OK);
	}
	
	@GetMapping("/deleteForum/{forumId}")
	 public ResponseEntity<String> deleteForum(@PathVariable("forumId") int forumId) 
	{
		Forum tempforum = forumDAO.getForum(forumId);
		System.out.println("deletion in forum");
		if (forumDAO.deleteForum(tempforum)) 
		{			
			return new ResponseEntity<String>("forum deleted", HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<String>("problem deleting forum", HttpStatus.METHOD_FAILURE);
		}
	}
	
	@GetMapping("/approveForum/{forumId}")
	public ResponseEntity<String> approveForum(@PathVariable("forumId") int forumId) 
	{
		Forum tempforum = forumDAO.getForum(forumId);

		if (forumDAO.approveForum(tempforum)) 
		{
			return new ResponseEntity<String>("forum approved", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("error in forum approved", HttpStatus.METHOD_FAILURE);
		}
	}
	
	@GetMapping("/rejectForum/{forumId}")
	public ResponseEntity<String> rejectForum(@PathVariable("forumId") int forumId) 
	{
		Forum tempforum = forumDAO.getForum(forumId);
		if (forumDAO.rejectForum(tempforum)) 
		{
			return new ResponseEntity<String>("forum rejected", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("error in forum rejected", HttpStatus.METHOD_FAILURE);

		}
	}
}