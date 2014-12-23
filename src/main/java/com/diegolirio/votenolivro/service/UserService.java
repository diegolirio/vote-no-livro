package com.diegolirio.votenolivro.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.UserDao;
import com.diegolirio.votenolivro.model.User;

@Service("userService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	public User getUserIfExistOrSaveNotExist(String email) {
		User user = this.userDao.getUserByEmail(email);
		if(user == null) {
			user = new User();
			user.setEmail(email);
			this.userDao.save(user);
		}
		return user;
	}

	public User getUserByEmail(String email) {
		return this.userDao.getUserByEmail(email);
	}

	public void save(User user) {
		if(user.getId() == 0) {
			User userByEmail = this.getUserByEmail(user.getEmail());
			if(userByEmail == null) // se não existe o usuario com o mesmo email cadastrado!!! 
				this.userDao.save(user);
			else {
				userByEmail.setEmail(user.getEmail());
				userByEmail.setName(user.getName());
				userByEmail.setNickname(user.getNickname());
				userByEmail.setPassword(user.getPassword());
				this.userDao.update(userByEmail);
			}
		}
		else
			this.userDao.update(user);
	}	

	public boolean login(User user) {
		return this.userDao.login(user);
	}

	public boolean recoverPassword(User user) {
		User userRecover = this.userDao.getUserByEmail(user.getEmail());
		if(userRecover == null || StringUtils.isEmpty(user.getPassword())) {
			return false;
		} else {
			// Send Email.. 
		}
		return true;
	}

}
