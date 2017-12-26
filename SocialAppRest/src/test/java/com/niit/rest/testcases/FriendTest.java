/*package com.niit.rest.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.rest.config.Dbconfig;
import com.niit.rest.dao.FriendDAO;
import com.niit.rest.model.Friend;

import jdk.nashorn.internal.ir.annotations.Ignore;

@ComponentScan("com.niit.rest")
public class FriendTest 
{
	@Autowired
	private static FriendDAO friendDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.rest.*");
		context.refresh();
		
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	
	@Ignore
	@Test
	public void saveFriendTest() 
	{
		Friend friend = new Friend();
		friend.setFriendId(548);
		friend.setStatus("R");
		friend.setUsername("snigda");
		friend.setFriendname("shailu");
		assertTrue("problem in friend", friendDAO.createFriend(friend));
	}
	
	@Ignore
	@Test
	public void getAllFriendRequestTest() 
	{
		List<Friend> listFriends = friendDAO.getAllFriendRequest("Sony");
		assertNotNull("problem in list friends", listFriends);
		for (Friend friend : listFriends) 
		{
			System.out.println("current username:::" + friend.getUsername());
			System.out.println("friend name::::" + friend.getFriendname());
			System.out.println("status::::" + friend.getStatus());
		}
	}
	
	@Ignore
	@Test
	public void getFriendId() 
	{
		Friend friend = (Friend) friendDAO.getFriend(547);
		assertNotNull("error", friend);
		System.out.println("friend status::::" + friend.getStatus());
	}
	
	@Ignore
	@Test
	public void getAllApprovedFriendTest() 
	{
		List<Friend> listFriends = friendDAO.getApprovedFriends("Sony");
		assertNotNull("problem in listFriends", listFriends);
		for (Friend friend : listFriends) {
			System.out.println("current user name:::" + friend.getUsername());
			System.out.println("current friend name:" + friend.getFriendname());
			System.out.println("status:::" + friend.getStatus());
		}
	}
	
	@Ignore
	@Test
	public void approveFriendRequest()
	{
		Friend friend=friendDAO.getFriend(548);
		assertTrue("problem in approving",friendDAO.approveFriendRequest(friend));
	}
	
	
	@Test
	public void rejectFriendRequest()
	{
		Friend friend=friendDAO.getFriend(547);
		assertTrue("problem in approving",friendDAO.rejectFriendRequest(friend));
	}
}*/