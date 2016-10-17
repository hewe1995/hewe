package com.hewe.dao;

import java.util.List;
import java.util.Map;

import com.hewe.domain.FileModel;

public interface IFileDao extends IBaseDao<FileModel, String> {
	public List<FileModel> getPageData(int startIndex, int pageSize);

	public List<FileModel> getPageData(int startIndex, int pageSize, Map<String, Object> map);
}
