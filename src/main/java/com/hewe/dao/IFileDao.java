package com.hewe.dao;

import java.util.List;

import com.hewe.domain.FileModel;

public interface IFileDao extends IBaseDao<FileModel, String> {
	public List<FileModel> getPageData(int startIndex, int pageSize);
}
