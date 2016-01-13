package com.really.repository;

import java.util.List;

import com.really.model.UserData;

public interface UserRepository 
{
	
	public List<UserData> loginUser(String userEmail, String pwd);
	public int registerUser(UserData u);
	public boolean updateUserInfo(UserData u);
	public boolean deleteUserInfo(UserData u);
	public List<UserData> viewUserInfo();

}
