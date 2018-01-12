package com.niit.rest.dao;

import com.niit.rest.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	void saveProfilePicture(ProfilePicture profilePicture);
	ProfilePicture getProfilePicture(String username);
	
}