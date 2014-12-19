package com.diegolirio.votenolivro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.UserDao;
import com.diegolirio.votenolivro.dao.VoteDao;
import com.diegolirio.votenolivro.model.User;
import com.diegolirio.votenolivro.model.Vote;

@Service("voteService")
public class VoteService {

	@Autowired
	private VoteDao voteDao;
	
	@Autowired
	private UserDao userDao;

	public void saveVoteUser(Vote vote) {
		User user = this.userDao.getUserByEmail(vote.getUser().getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(vote.getUser().getEmail());
			this.userDao.save(user);
			vote.setUser(user);
		}
		this.voteDao.save(vote);
	}

}
