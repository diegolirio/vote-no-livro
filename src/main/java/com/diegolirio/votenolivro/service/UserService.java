package com.diegolirio.votenolivro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.UserDao;
import com.diegolirio.votenolivro.model.User;

@Service("userService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public User getUserIfExistOrSaveNotExist(String email) {
		User user = this.userDao.getUserByEmail(email);
		if(user == null) {
			user = new User();
			user.setEmail(email);
			this.userDao.save(user);
		}
		return user;
	}

	
}
