package com.diegolirio.votenolivro.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.User;

@Repository("userDao")
public class UserDao extends AbstractGenericDao<User> {

	public User getUserByEmail(String email) {
		Query query = super.manager.createQuery("Select u from User u where u.email = :email");
		query.setParameter("email", email);
		try {
			return (User) query.getSingleResult();
		} catch(Exception e) {
			return null;
		}
	}

	public boolean login(User user) {
		Query query = super.manager.createQuery("Select u from User u where u.email = :email and u.password = :password");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		try {
			user = (User) query.getSingleResult();
		} catch(NoResultException e) {
			return false;
		}
		return true;
	}


}
