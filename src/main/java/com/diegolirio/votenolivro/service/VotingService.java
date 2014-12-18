package com.diegolirio.votenolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.VotingDao;
import com.diegolirio.votenolivro.model.Voting;

@Service("votingService")
public class VotingService {

	@Autowired
	private VotingDao votingDao;

	public List<Voting> getList() {
		return this.votingDao.getList(Voting.class);
	}
	
}
