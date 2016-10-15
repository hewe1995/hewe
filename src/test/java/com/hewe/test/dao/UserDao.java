package com.hewe.test.dao;

import org.springframework.stereotype.Repository;

import com.hewe.test.model.UserModel;

@Repository("userDao")
public class UserDao implements IUserDao {

	public void add(UserModel t) {
		System.out.println("useradd");
	}

	public UserModel find(String p) {
		System.out.println("userfind");
		return null;
	}

	public Boolean isExit(String name) {
		System.out.println("userisexit");
		return null;
	}

	public void update(UserModel t) {
		System.out.println("userupdate");
	}

	public void delete(UserModel t) {
		System.out.println("userdelete");
	}

	public UserModel find(String username, String password) {
		System.out.println("userfind");
		return null;
	}

}
