package com.hewe.test.service;

import com.hewe.test.model.UserModel;

public interface IUserService extends IBaseService<UserModel, String> {
	public UserModel findUser(String username, String password);
}
