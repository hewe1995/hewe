package com.hewe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hewe.dao.IFileDao;
import com.hewe.domain.FileModel;
import com.hewe.util.model.Page;

@Service("fileService")
@Transactional
public class FileService implements IFileService {

	@Autowired
	private IFileDao fileDao;

	public void add(FileModel t) {
		fileDao.add(t);
	}

	public FileModel find(String p) {

		return fileDao.find(p);
	}

	public Boolean isExit(String name) {
		return fileDao.isExit(name);
	}

	public void update(FileModel t) {
		fileDao.update(t);
	}

	public void delete(FileModel t) {
		fileDao.delete(t);
	}

	public Page getPageDataFile(String pageIndex) {
		int totalRecord = fileDao.getTotalRecord();
		Page page = null;
		if (pageIndex == null) {
			page = new Page(1, totalRecord);
		} else {
			page = new Page(Integer.parseInt(pageIndex), totalRecord);
		}
		List list = fileDao.getPageData(page.getStartIndex(), Page.PAGESIZE);

		page.setList(list);

		return page;
	}

}
