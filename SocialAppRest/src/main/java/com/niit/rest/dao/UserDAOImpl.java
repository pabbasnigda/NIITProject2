package com.niit.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.rest.model.UserDetails;
import com.niit.rest.model.Forum;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{	
		this.sessionFactory=sessionFactory;
	}
		
	@Transactional
	public boolean updateOnlineStatus(String status, UserDetails user) 
	{
		try
		{
			user.setIsOnline(status);
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:" +e);
			return false;
		}	
	}


	
	@Transactional
	public boolean addUserDetails(UserDetails user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:" +e);
			return false;
		}	
	}


	public List<UserDetails> getAllUserDetails() 
	{
		Session session=sessionFactory.openSession();
		List<UserDetails> user=(List<UserDetails>)session.createQuery("from UserDetails").list();
		session.close();
		return user;
	}

	@Transactional
	public UserDetails getUserDetails(String username) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			UserDetails user=(UserDetails)session.get(UserDetails.class,username);
			session.close();
			return user;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return null;
	}


	@Override
	public boolean checkLogin(UserDetails user) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			
			Query query=(Query) session.createQuery("from UserDetails where username=uname and password=pwd");
			query.setParameter("uname", user.getUsername());
			query.setParameter("pwd", user.getPassword());
			
			UserDetails userDetail=(UserDetails)query.getResultList().get(0);
			session.close();
			if(userDetail==null)
				return false;
			else
				return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}