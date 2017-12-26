package com.niit.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.rest.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO
{	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	BlogDAO blogDAO;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean addBlog(Blog blog) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	@Transactional
	public boolean updateBlog(Blog blog) 
	{
		try
		{
		sessionFactory.getCurrentSession().update(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}

	@Transactional
	public boolean deleteBlog(Blog blog) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}

	@Transactional
	public Blog getBlog(int blogId) 
	{
		Session session=sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class, blogId);
		session.close();
		return blog;
	}
	
	@Transactional
	public List<Blog> getAllBlogs() 
	{
		Session session=sessionFactory.openSession();
		List<Blog> blogList=session.createQuery("from Blog where status != 'PENDING'").list();
		session.close();
		return blogList;
	}

	@Transactional
	public boolean approveBlog(Blog blog) 
	{
		try{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
	}

	@Transactional
	public boolean rejectBlog(Blog blog) 
	{
		try{
			blog.setStatus("N");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}
	}

	@Override
	@Transactional
	public boolean incrementLike(Blog blog) 
	{
		try 
		{
			blog.setLikes(blog.getLikes() + 1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} 
		catch(Exception e) 
		{
			System.out.println("exception arised" + e);
			return false;
		}
	}

	@Transactional
	public List<Blog> getAllBlogs(int userId) 
	{
		Session session = sessionFactory.openSession();
		List<Blog> blogList= session.createQuery("from Blog where userId = :userId")
				.setParameter("userId", userId).list();
		
		session.close();
		
		return blogList;
	}

	@Transactional
	public List<Blog> getAllPendingBlogs() 
	{
		Session session = sessionFactory.openSession();
		
		List<Blog> blogList= session.createQuery("from Blog where status = 'PENDING'").list();
		
		session.close();
		
		return blogList;
	}

	@Transactional
	public List<Blog> getAllApprovedBlog() 
	{
		Session session = sessionFactory.openSession();
		
		List<Blog> blogList= session.createQuery("from Blog where status = 'APPROVED'").list();
		
		session.close();
		
		return blogList;
	}

}

