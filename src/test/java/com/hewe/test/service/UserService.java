package com.hewe.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hewe.test.dao.IUserDao;
import com.hewe.test.model.UserModel;

@Service("userService")
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	public void add(UserModel t) {
		userDao.add(t);
	}

	public UserModel find(String p) {
		return userDao.find(p);
	}

	public Boolean isExit(String name) {
		return userDao.isExit(name);
	}

	public void update(UserModel t) {
		userDao.update(t);
	}

	public void delete(UserModel t) {
		userDao.delete(t);

	}

	public UserModel findUser(String username, String password) {

		return userDao.find(username, password);
	}

}
