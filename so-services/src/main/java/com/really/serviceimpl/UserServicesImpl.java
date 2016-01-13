package com.really.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.really.model.UserData;
import com.really.repository.UserRepository;
import com.really.service.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository repository;
	
	public UserData loginUser(UserData user) {
		
		UserData userData=(UserData)user;
		List<UserData> userList=null;
		if(user!=null)
		{
			if(user.getEmail()!=null && user.getPwd()!=null)
			{
				userList=repository.loginUser(userData.getEmail(), userData.getPwd());
			}
		}
		if(userList.size()==0)
		{
			userData=null;
		}
		else {
			userData=(UserData)userList.get(0);
			
		}
		return userData;
	}

	public int registerUser(UserData u) {
		// TODO Auto-generated method stub
		return repository.registerUser(u);
	}

	public boolean updateUserInfo(UserData u) {
		// TODO Auto-generated method stub
		return repository.updateUserInfo(u);
	}

	public boolean deleteUserInfo(UserData u) {
		// TODO Auto-generated method stub
		return repository.deleteUserInfo(u);
	}

	public List<UserData> viewUserInfo() {
		// TODO Auto-generated method stub
		return repository.viewUserInfo();
	}

}
