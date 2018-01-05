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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.rest.dao.BlogDAO;
import com.niit.rest.dao.UserDAO;
import com.niit.rest.model.Blog;
import com.niit.rest.model.UserDetails;



@RestController
public class BlogController 
{

	@Autowired
	private BlogDAO blogDAO;
	

	@Autowired
	private UserDAO userDAO;


	@PostMapping(value ="/insertBlog")
	public ResponseEntity<String> insertBlog(@RequestBody Blog blog,HttpSession session)
	{
		//userDAO.getUserDetails(username)
		
		UserDetails	userDetail=(UserDetails)session.getAttribute("üser");

		blog.setCreateDate(new java.util.Date());
		//blog.setUserId(userDetail.getUser_Id());
		blog.setStatus("N");
		blog.setLikes(0);
		
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@RequestMapping(value="/updateBlog")
	public  ResponseEntity<String> updateBlog(@RequestBody Blog blog)
	{
		Blog tempBlog=blogDAO.getBlog(blog.getBlogId());	
		tempBlog.setBlogName(blog.getBlogName());
		tempBlog.setBlogContent(blog.getBlogContent());
		if(blogDAO.updateBlog(tempBlog))
		{
			return new ResponseEntity<String>("Blog Update",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Blog updation",HttpStatus.SERVICE_UNAVAILABLE);
			
		}
	}
	
	@RequestMapping(value="/getAllBlogs")
	public ResponseEntity<ArrayList<Blog>> getAllBlogs()
	{
		ArrayList listBlogs = (ArrayList)blogDAO.getAllBlogs();
		return new ResponseEntity<ArrayList<Blog>>(listBlogs,HttpStatus.OK);
	}
	
	@GetMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId") int blogId) {
		Blog tempblog = blogDAO.getBlog(blogId);
		System.out.println("deletion in blog");
		if (blogDAO.deleteBlog(tempblog)) 
		{			
			return new ResponseEntity<String>("Blog deleted", HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<String>("problem deleting blog", HttpStatus.METHOD_FAILURE);
		}
	}
	
	@GetMapping("/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogId") int blogId) {
		Blog tempblog = blogDAO.getBlog(blogId);

		if (blogDAO.approveBlog(tempblog)) {
			return new ResponseEntity<String>("Blog approved", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("error in Blog updation", HttpStatus.METHOD_FAILURE);
		}
	}

	@GetMapping("/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId") int blogId) 
	{
		Blog tempblog = blogDAO.getBlog(blogId);
		if (blogDAO.rejectBlog(tempblog)) {
			return new ResponseEntity<String>("Blog rejected", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("error in Blog updation", HttpStatus.METHOD_FAILURE);

		}
	}
	@GetMapping("/incLike/{blogId}")
	public ResponseEntity<String> incrementLike(@PathVariable("blogId") int blogId)
	{
		Blog tempblog=blogDAO.getBlog(blogId);
		if(blogDAO.incrementLike(tempblog))
		{
			return new ResponseEntity<String>("like incremented",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("error in like increment",HttpStatus.METHOD_FAILURE);
		}
	}
}