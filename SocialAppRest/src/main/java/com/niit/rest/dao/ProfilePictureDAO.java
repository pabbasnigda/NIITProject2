package com.niit.rest.dao;

import com.niit.rest.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	public boolean save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}