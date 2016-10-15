package com.hewe.test.dao;

import org.springframework.stereotype.Repository;

import com.hewe.test.model.FileModel;

@Repository("fileDao")
public class FileDao implements IFileDao {

	public void add(FileModel t) {
		System.out.println("fileadd");

	}

	public FileModel find(String p) {
		System.out.println("filefind");
		return null;
	}

	public Boolean isExit(String name) {
		System.out.println("fileisExit");
		return null;
	}

	public void update(FileModel t) {
		System.out.println("fileupdate");

	}

	public void delete(FileModel t) {
		System.out.println("filedelete");

	}

}
