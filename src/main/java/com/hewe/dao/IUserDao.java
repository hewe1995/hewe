package com.hewe.dao;

import java.util.List;

import com.hewe.domain.UserModel;

public interface IUserDao extends IBaseDao<UserModel, String> {
	public UserModel find(String username, String password);

	public List<UserModel> getPageData(int startIndex, int pageSize);
}
