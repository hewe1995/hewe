package com.hewe.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hewe.dao.UserDao;
import com.hewe.domain.UserModel;

@Controller
public class LoginController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(path = "/save", method = RequestMethod.GET)
	public String save() {
		UserModel user = new UserModel();
		user.setId("2323");
		user.setPassword("dddd");
		user.setStatus(1);
		user.setUsername("user");
		userDao.add(user);
		return "success";
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
