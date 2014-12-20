package com.diegolirio.votenolivro.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.Vote;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.model.VotingBook;

@Repository("voteDao")
public class VoteDao extends AbstractGenericDao<Vote> {

	public long getCountVotesByVotingBook(VotingBook votingBook) {
		Query query = super.manager.createQuery("Select count(v) from Vote v where v.votingBook.id = :votingBookId");
		query.setParameter("votingBookId", votingBook.getId());
		return (Long) query.getSingleResult();
	}

	public long getCountByVoting(Voting voting) {
		Query query = super.manager.createQuery("Select count(v) from Vote v where v.votingBook.voting.id = :votingId");
		query.setParameter("votingId", voting.getId());
		return (Long) query.getSingleResult();		
	}		
}
