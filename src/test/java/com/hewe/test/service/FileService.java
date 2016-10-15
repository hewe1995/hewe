package com.hewe.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hewe.test.dao.IFileDao;
import com.hewe.test.model.FileModel;

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

}
