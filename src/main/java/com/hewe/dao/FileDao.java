package com.hewe.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hewe.domain.FileModel;

@Repository("fileDao")
public class FileDao implements IFileDao {
	private static final Logger log = Logger.getLogger(FileDao.class);
	@Autowired
	private SessionFactory factory;

	private String className = FileModel.class.getName();

	public void add(FileModel t) {
		log.debug(t.getName() + "save");
		factory.getCurrentSession().save(t);
	}

	public FileModel find(String p) {
		String sql = "from " + className + " where id=?";
		log.debug(p);
		return (FileModel) factory.getCurrentSession().createQuery(sql).setParameter(0, p).getSingleResult();
	}

	public Boolean isExit(String name) {
		log.debug(name + "isExit");
		return null;
	}

	public void update(FileModel t) {
		factory.getCurrentSession().update(t);
		log.debug("update:" + t.getName());
	}

	public void delete(FileModel t) {
		log.debug("filedelete");

	}

	public List<FileModel> getPageData(int startIndex, int pageSize) {
		log.debug("file : getPageData");
		String sql = "from " + className;
		log.debug(sql);
		@SuppressWarnings("unchecked")
		List<FileModel> list = factory.getCurrentSession().createQuery(sql).setFirstResult(startIndex)
				.setMaxResults(pageSize).getResultList();
		return list;
	}

	public List<FileModel> getPageData(int startIndex, int pageSize, Map<String, Object> map) {
		log.debug("file : getPageData map");
		StringBuffer sql = new StringBuffer("from " + className);
		if (map != null) {
			sql.append(" where");
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				sql.append(" " + entry.getKey() + "=" + entry.getValue());
			}
		}
		log.debug(sql.toString());
		@SuppressWarnings("unchecked")
		List<FileModel> list = factory.getCurrentSession().createQuery(sql.toString()).setFirstResult(startIndex)
				.setMaxResults(pageSize).getResultList();
		return list;
	}

	public int getTotalRecord(Map<String, Object> map) {
		StringBuffer sql = new StringBuffer("select count(*) from " + className);
		if (map != null) {
			sql.append(" where");
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				sql.append(" " + entry.getKey() + "=" + entry.getValue());
			}
		}
		log.debug(sql.toString());
		long count = (Long) factory.getCurrentSession().createQuery(sql.toString()).getSingleResult();
		int icount = (int) count;
		log.debug(icount);
		return icount;
	}

}
