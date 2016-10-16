package com.hewe.service;

import com.hewe.domain.UserModel;
import com.hewe.util.model.Page;

public interface IUserService extends IBaseService<UserModel, String> {
	public UserModel findUser(String username, String password);

	public Page getPageDataUser(String pageIndex);
}
