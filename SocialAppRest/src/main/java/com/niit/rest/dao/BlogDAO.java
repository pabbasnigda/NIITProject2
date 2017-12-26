package com.niit.rest.dao;

import java.util.List;

import com.niit.rest.model.Blog;

public interface BlogDAO 
{
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getAllBlogs();
	
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public List<Blog> getAllBlogs(int userId);
	public List<Blog> getAllPendingBlogs();
	public List<Blog> getAllApprovedBlog();
	public boolean incrementLike(Blog blog);
}
