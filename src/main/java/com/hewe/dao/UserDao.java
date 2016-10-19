package com.hewe.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hewe.domain.FileModel;
import com.hewe.domain.UserModel;

@Repository("userDao")
public class UserDao implements IUserDao {
	private static final Logger log = Logger.getLogger(UserDao.class);

	@Autowired
	private SessionFactory factory;

	private String className = UserModel.class.getName();

	public void add(UserModel t) {
		log.debug("useradd");
		try {
			Session ss = factory.getCurrentSession();
			ss.save(t);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public UserModel find(String p) {
		log.debug("userfind");
		return null;
	}

	public Boolean isExit(String name) {
		log.debug("userisexit");
		return null;
	}

	public void update(UserModel t) {
		log.debug("userupdate");
	}

	public void delete(UserModel t) {
		log.debug("userdelete");
	}

	public UserModel find(String username, String password) {

		UserModel user = null;
		try {
			Session ss = factory.getCurrentSession();
			String sql = "from " + className + " where username=? and password=?";
			user = (UserModel) ss.createQuery(sql).setParameter(0, username).setParameter(1, password)
					.getSingleResult();
			log.debug("userfind");
			return user;
		} catch (NoResultException noresult) {
			user = null;
			return user;
		} catch (Exception e) {
			log.error(e.getMessage());
			user = null;
			return user;
		}
	}

	public int getTotalRecord(Map<String, Object> map) {
		try {
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
			log.debug("user count :" + icount);
			return icount;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return 0;
	}

	public List<UserModel> getPageData(int startIndex, int pageSize) {
		String sql = "from " + className;
		log.debug("startIndex" + startIndex + "pageSize :" + pageSize);
		List<UserModel> list = factory.getCurrentSession().createQuery(sql).setFirstResult(startIndex)
				.setMaxResults(pageSize).getResultList();
		return list;
	}

	public UserModel findByName(String username) {
		UserModel user = null;
		try {
			user = (UserModel) factory.getCurrentSession().createQuery("from " + className + " where username=?")
					.setParameter(0, username).getSingleResult();
		} catch (NoResultException noresult) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
