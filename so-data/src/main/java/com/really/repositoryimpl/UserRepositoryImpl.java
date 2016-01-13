package com.really.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.really.model.UserData;
import com.really.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository
{

	@Autowired
	private HibernateTemplate ht;
	
	public List<UserData> loginUser(String email, String pwd) {
		
		List<UserData> list=ht.find("from UserData ud where ud.email=? and ud.pwd=?", email,pwd);
		return list;
	}

	public int registerUser(UserData u) {
		
		int st=(Integer) ht.save(u);
		return st;
	}

	public boolean updateUserInfo(UserData u) {
		boolean st=false;
		ht.saveOrUpdate(u);
		st=true;
		return st;
	}

	public boolean deleteUserInfo(UserData u) {
		boolean st=false;
		ht.delete(u);
		st=true;
		return st;
	}

	public List<UserData> viewUserInfo() {
		List<UserData> list=ht.loadAll(UserData.class);
		return list;
	}

}
