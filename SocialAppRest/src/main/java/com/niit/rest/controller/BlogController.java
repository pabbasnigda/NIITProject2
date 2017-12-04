package com.niit.rest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.rest.dao.BlogDAO;
import com.niit.rest.model.Blog;

@RestController
public class BlogController 
{
	@Autowired
	BlogDAO blogDAO;
	
	@PostMapping(value="/insertBlog")
	public ResponseEntity<String> insertBlog(@RequestBody Blog blog)
	{
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in responseentity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}	
	@PostMapping(value="/updateBlog")
	public ResponseEntity<String> updateBlog(@RequestBody Blog blog)
	{
		Blog tempBlog=blogDAO.getBlog(blog.getBlogId());
		
		tempBlog.setBlogName(blog.getBlogName());
		tempBlog.setBlogContent(blog.getBlogContent());
		
		if(blogDAO.updateBlog(tempBlog))
		{
			return new ResponseEntity<String>("Blog updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in responseentity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@GetMapping(value="/getAllBlogs")
	public ResponseEntity<ArrayList<Blog>> getAllBlogs()
	{
		ArrayList listblogs= (ArrayList)blogDAO.getAllBlogs();
		
		return new ResponseEntity<ArrayList<Blog>>(listblogs,HttpStatus.OK);
	}
	@PostMapping(value="/deleteBlog")
	public ResponseEntity<String> deleteBlog(@RequestBody Blog blog)
	{
		Blog tempBlog=blogDAO.getBlog(blog.getBlogId());
		if(blogDAO.deleteBlog(tempBlog))
		{
			return new ResponseEntity<String>("Blog deleted successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in responseentity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
