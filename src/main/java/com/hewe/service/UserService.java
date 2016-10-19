package com.hewe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hewe.dao.IUserDao;
import com.hewe.domain.UserModel;
import com.hewe.util.model.Page;

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

	public Page getPageDataUser(String pageIndex) {
		int totalRecord = userDao.getTotalRecord(null);
		Page page = null;
		if (pageIndex == null) {
			page = new Page(1, totalRecord);
		} else {
			page = new Page(Integer.parseInt(pageIndex), totalRecord);
		}
		List list = userDao.getPageData(page.getStartIndex(), Page.PAGESIZE);

		page.setList(list);
		return page;
	}

	public UserModel findUserByName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByName(username);
	}

}
