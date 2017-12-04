package com.niit.rest.dao;

import java.util.List;

import org.hibernate.Session;
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

	@Override
	@Transactional
	public boolean addFriend(Friend friend) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateFriend(Friend friend) 
	{
		try
		{
		sessionFactory.getCurrentSession().update(friend);
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
	public boolean deleteFriend(Friend friend) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(friend);
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
	public List<Friend> getAllFriends() 
	{
		Session session=sessionFactory.openSession();
		List<Friend> friendList=(List<Friend>)session.createQuery("from Friend").list();
		session.close();
		return friendList;
	}

	@Override
	@Transactional
	public Friend getFriend(int friendId) 
	{
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class, friendId);
		session.close();
		return friend;
	}
}
