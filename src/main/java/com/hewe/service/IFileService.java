package com.hewe.service;

import java.util.Map;

import com.hewe.domain.FileModel;
import com.hewe.util.model.Page;

public interface IFileService extends IBaseService<FileModel, String> {
	public Page getPageDataFile(String pageIndex);

	public Page getPageDataFile(String pageIndex, Map<String, Object> map);
}
