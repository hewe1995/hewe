package com.hewe.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hewe.domain.FileModel;
import com.hewe.domain.UserModel;

@Repository("userDao")
public class UserDao implements IUserDao {
	@Autowired
	private SessionFactory factory;

	private String className = UserModel.class.getName();

	public void add(UserModel t) {
		System.out.println("useradd");
		try {
			Session ss = factory.getCurrentSession();
			ss.save(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserModel find(String p) {
		System.out.println("userfind");
		return null;
	}

	public Boolean isExit(String name) {
		System.out.println("userisexit");
		return null;
	}

	public void update(UserModel t) {
		System.out.println("userupdate");
	}

	public void delete(UserModel t) {
		System.out.println("userdelete");
	}

	public UserModel find(String username, String password) {
		System.out.println("userfind");
		UserModel user = null;
		try {
			Session ss = factory.getCurrentSession();
			String sql = "from " + className + " where username=? and password=?";
			user = (UserModel) ss.createQuery(sql).setParameter(0, username).setParameter(1, password)
					.getSingleResult();
			return user;
		} catch (NoResultException noresult) {
			user = null;
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			user = null;
			return user;
		}
	}

	public int getTotalRecord() {
		try {
			String sql = "select count(*) from " + className;
			long count = (Long) factory.getCurrentSession().createQuery(sql).getSingleResult();
			int icount = (int) count;
			System.out.println("user count :" + icount);
			return icount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<UserModel> getPageData(int startIndex, int pageSize) {
		String sql = "from " + className;
		System.out.println("startIndex" + startIndex + "pageSize :" + pageSize);
		List<UserModel> list = factory.getCurrentSession().createQuery(sql).setFirstResult(startIndex)
				.setMaxResults(pageSize).getResultList();
		return list;
	}

}
