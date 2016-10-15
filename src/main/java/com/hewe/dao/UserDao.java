package com.hewe.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hewe.domain.UserModel;

@Repository("userDao")
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(UserModel user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserModel find(String username, String password) {
		try {

			Session ss = sessionFactory.getCurrentSession();
			String sql = "from UserModel where username=? and password =?";
			ss.createQuery(sql).setParameter(0, username).setParameter(1, password);

		} catch (Exception e) {
		}
		return null;
	}
}
