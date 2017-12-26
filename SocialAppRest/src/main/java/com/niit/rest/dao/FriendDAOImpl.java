package com.niit.rest.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.rest.model.Friend;

@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO
{
	@Autowired 
	SessionFactory sessionFactory;
	@Autowired
	FriendDAO friendDAO;
	
	public FriendDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}


	@Transactional
	public boolean createFriend(Friend friend) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("exception arised " + e);
			return false;
		}
	}

	
	@Transactional
	public List<Friend> getAllFriendRequest(String username) 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friend where username=:username");
		query.setParameter("username", username);
		List<Friend> listFriends = query.list();
		return listFriends;
	}

	
	@Transactional
	public List<Friend> getApprovedFriends(String username) 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friend where username=:username and status='A'");
		query.setParameter("username", username);
		List<Friend> listFriends = query.list();
		return listFriends;
	}

	@Transactional
	public Friend getFriend(int friendId) 
	{
		Session session = sessionFactory.openSession();
		Friend friend = (Friend) session.get(Friend.class, friendId);
		return friend;
	}


	@Transactional
	public boolean rejectFriendRequest(Friend friend) 
	{
		try 
		{
			friend.setStatus("R");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("exception arised" + e);
			return false;
		}
	}

	
	@Transactional
	public boolean approveFriendRequest(Friend friend) 
	{
		try 
		{
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("exception arised" + e);
			return false;
		}
	}
}
