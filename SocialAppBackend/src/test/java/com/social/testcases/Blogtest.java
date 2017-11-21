package com.social.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.social.config.Dbconfig;
import com.social.dao.BlogDAO;
import com.social.model.Blog;

@ComponentScan("com.social")
public class Blogtest 
{
	 @Autowired
	 private static BlogDAO blogDAO;
	
	 	@SuppressWarnings("resource")
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.register(Dbconfig.class);
			context.scan("com.social.*");
			context.refresh();
			
			blogDAO=(BlogDAO)context.getBean("blogDAO");
		}
	 	
	 	@Test
	 	public void addBlogTest()
	 	{
			Blog blog=new Blog();
			//blog.setBlogId(1001);
			blog.setBlogName("Advanced java");
			blog.setBlogContent("Java advance concepts");
			blog.setUsername("snigda");
			blog.setStatus("A");
			blog.setLikes(5);
			blog.setCreateDate(new java.util.Date());
			
			assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	 	}
}
