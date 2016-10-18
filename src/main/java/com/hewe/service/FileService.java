package com.hewe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hewe.dao.IFileDao;
import com.hewe.domain.FileModel;
import com.hewe.util.model.Page;

@Service("fileService")
@Transactional
public class FileService implements IFileService {
	private static final Logger log = Logger.getLogger(FileService.class);
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
		int totalRecord = fileDao.getTotalRecord(null);
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

	public Page getPageDataFile(String pageIndex, Map<String, Object> map) {
		log.debug("getPageDataFile map");
		int totalRecord = fileDao.getTotalRecord(map);
		Page page = null;
		if (pageIndex == null) {
			page = new Page(1, totalRecord);
		} else {
			page = new Page(Integer.parseInt(pageIndex), totalRecord);
		}
		List list = fileDao.getPageData(page.getStartIndex(), Page.PAGESIZE, map);

		page.setList(list);

		return page;
	}

}
