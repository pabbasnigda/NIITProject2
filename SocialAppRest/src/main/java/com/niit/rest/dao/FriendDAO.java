package com.niit.rest.dao;

import java.util.List;

import com.niit.rest.model.Friend;

public interface FriendDAO 
{
	public boolean addFriend(Friend friend);
	public boolean updateFriend(Friend friend);
	public boolean deleteFriend(Friend friend);
	public Friend getFriend(int friendId);
	public List<Friend> getAllFriends();
}
