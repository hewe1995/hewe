package com.hewe.service;

import com.hewe.domain.FileModel;
import com.hewe.util.model.Page;

public interface IFileService extends IBaseService<FileModel, String> {
	public Page getPageDataFile(String pageIndex);
}
