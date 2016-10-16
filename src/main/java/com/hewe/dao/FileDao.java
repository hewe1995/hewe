package com.hewe.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hewe.domain.FileModel;

@Repository("fileDao")
public class FileDao implements IFileDao {

	@Autowired
	private SessionFactory factory;

	private String className = FileModel.class.getName();

	public void add(FileModel t) {
		factory.getCurrentSession().save(t);
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

	public List<FileModel> getPageData(int startIndex, int pageSize) {
		System.out.println("file : getPageData");
		String sql = "from " + className;
		List<FileModel> list = factory.getCurrentSession().createQuery(sql).setFirstResult(startIndex)
				.setMaxResults(pageSize).getResultList();
		return list;
	}

	public int getTotalRecord() {
		String sql = "select count(*) from " + className;
		long count = (Long) factory.getCurrentSession().createQuery(sql).getSingleResult();
		int icount = (int) count;
		return icount;
	}

}
