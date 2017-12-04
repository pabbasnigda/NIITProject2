package com.niit.rest.testcases;

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
	
	/*@Ignore
	@Test
	public void addFriendTest()
	{
		Friend friend= new Friend();
		friend.setUserId(547);
		friend.setStatus("A");
		
		assertTrue("Problem in Inserting friend",friendDAO.addFriend(friend));
	}*/
	
	@Ignore
	@Test
	public void updateFriendTest()
	{
		Friend friend=(Friend)friendDAO.getFriend(18);
		friend.setStatus("N");
		assertTrue("Problem in updating friend",friendDAO.updateFriend(friend));
	}
	
	/*@Ignore
	@Test
	public void deleteFriendTest()
	{
		Friend friend=(Friend)friendDAO.getFriend(20);
		assertTrue("Problem in deletion",friendDAO.deleteFriend(friend));
	}*/
	
	/*@Ignore
	@Test
	public void getFriendTest()
	{
		Friend friend=(Friend)friendDAO.getFriend(19);
		System.out.println("Friend status:" + friend.getStatus());
		System.out.println("Friend ID:" + friend.getFriendId());
		System.out.println("User ID:" + friend.getUserId());
		assertNotNull("friend not found", friend);
	}*/
	
	@Ignore
	@Test
	public void getAllFriendsTest()
 	{
		List<Friend> friendList=(List<Friend>)friendDAO.getAllFriends();
		assertNotNull("Friend list not found ",friendList.get(0));
		for(Friend friend:friendList)
		{
			System.out.println("FriendID:"+friend.getFriendId() + "Status:"+friend.getStatus());
		}
 	}
}

