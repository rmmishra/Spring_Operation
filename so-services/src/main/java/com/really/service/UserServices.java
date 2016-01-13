package com.really.service;

import java.util.List;

import com.really.model.UserData;

public interface UserServices {
	public UserData loginUser(UserData userData);
	public int registerUser(UserData u);
	public boolean updateUserInfo(UserData u);
	public boolean deleteUserInfo(UserData u);
	public List<UserData> viewUserInfo();

}
