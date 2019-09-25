package com.revature.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public List<User> getUsers() {
		List<User> users = null;
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			
			cq.select(cq.from(User.class));
			
			Query<User> query = s.createQuery(cq);
			users = query.list();
			log.info("getting all users");
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		try(Session s = HibernateUtil.getSession()){
			User u = s.get(User.class, id);
			log.info("getting User"+u);
			return u;
		}
	}

	@Override
	public User getUserByEmailAndPassword(String e, String p) {
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root);
			cq.where(
					cb.and(
							cb.equal(root.get("email"), e),
							cb.equal(root.get("password"), p)
							)
					
					);
			
			
			Query<User> query = s.createQuery(cq);
			User u = query.getSingleResult();
			log.info("getting user by email and password");
			return u;
		}
		
	}

	@Override
	public User getUserByUsernameAndPassword(String u, String p) {
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root);
			cq.where(
					cb.and(
							cb.equal(root.get("user_id"), u),
							cb.equal(root.get("password"), p)
							)
					
					);
			
			
			Query<User> query = s.createQuery(cq);
			User user = query.getSingleResult();
			log.info("getting user by email and password");
			return user;
		}
	}

	@Override
	public int createUser(User u) {
		int pk =0;
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			pk = (int) s.save(u);
			tx.commit();
		}
		return pk;
	}

	@Override
	public void updateUser(User u) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		}
	}

	@Override
	public void deleteUserById(int id) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.delete(new User(id));
			tx.commit();
		}
	}

}
