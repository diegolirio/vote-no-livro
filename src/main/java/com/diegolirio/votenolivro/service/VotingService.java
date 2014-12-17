package com.diegolirio.votenolivro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.VotingDao;

@Service("votingService")
public class VotingService {

	@Autowired
	private VotingDao votingDao;
	
}
