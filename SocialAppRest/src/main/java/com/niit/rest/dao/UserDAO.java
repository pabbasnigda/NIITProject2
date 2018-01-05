package com.niit.rest.dao;

import java.util.List;


import com.niit.rest.model.UserDetails;

public interface UserDAO 
{
	public boolean addUserDetail(UserDetails user);
	public boolean updateOnlineStatus(String status, UserDetails user);
	public UserDetails getByEmail(String email);
	public List<UserDetails> getAllUserDetails();
	public UserDetails getUserDetails(String username);
	public boolean checkLogin(String username, String password);

}
