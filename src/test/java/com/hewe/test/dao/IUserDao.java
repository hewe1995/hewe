package com.hewe.test.dao;

import com.hewe.test.model.UserModel;

public interface IUserDao extends IBaseDao<UserModel, String> {
	public UserModel find(String username, String password);
}
