package com.diegolirio.votenolivro.dao;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.Vote;

@Repository("voteDao")
public class VoteDao extends AbstractGenericDao<Vote> {
	
}
