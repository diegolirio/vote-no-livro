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

	public void setVotingDao(VotingDao votingDao) {
		this.votingDao = votingDao;
	}

	
	public List<Voting> getList() {
		return this.votingDao.getList(Voting.class);
	}

	public void save(Voting voting) {
		if(voting.getId() == 0)
			this.votingDao.save(voting);
		else
			this.votingDao.update(voting);
	}

	public Voting getByDescription(String description) {
		return this.votingDao.getByDescription(description);
	}

	public Voting get(long id) {
		return this.votingDao.get(Voting.class, id);
	}

	
}
