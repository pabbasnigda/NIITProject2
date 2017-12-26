package com.niit.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.rest.model.UserDetails;

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
	public boolean saveUser(UserDetails user) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			user.setEnabled(true);
			user.setOnline(false);
			session.save(user);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Transactional
	public boolean updateUser(UserDetails user) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Transactional
	public boolean deleteUser(int id) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			UserDetails user = session.get(UserDetails.class, id);
			session.delete(user);
			return true;	
		}
		catch(Exception e)
		{	
			System.out.println("Exception raised: "+e);
			return false;
		}
	}

	@Transactional
	public UserDetails getUserById(int userId) 
	{
		String queryString = "from UserDetails where c_user_id = :userId";
		UserDetails userObj = (UserDetails) sessionFactory.getCurrentSession().createQuery(queryString).setParameter("userId",userId).uniqueResult();
		return userObj;
	}

	@Transactional
	public UserDetails getUserByEmail(String email) 
	{
		String queryString = "from UserDetails where email = :email";
		UserDetails userObj = (UserDetails) sessionFactory.getCurrentSession().createQuery(queryString).setParameter("email",email).uniqueResult();
		return userObj;
	}

	@Transactional
	public UserDetails getUserByName(String name) 
	{
		String queryString = "from UserDetails where username = :name";
		UserDetails userObj = (UserDetails) sessionFactory.getCurrentSession().createQuery(queryString).setParameter("name",name).uniqueResult();
		return userObj;
	}

	@Transactional
	public List<UserDetails> getAllUsers() 
	{
		String queryString = "from UserDetails";
		List<UserDetails> userList = sessionFactory.getCurrentSession().createQuery(queryString).list();
		return userList;
	}

	@Override
	public boolean checkIfExistingUser(UserDetails user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkIfValidUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
		
}