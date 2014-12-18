package com.diegolirio.votenolivro.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.Voting;

@Repository("votingDao")
public class VotingDao extends AbstractGenericDao<Voting> {

	public Voting getByDescription(String description) {
		Query query = super.manager.createQuery("Select v from Voting v where v.description = :desc");
		query.setParameter("desc", description);
		try {
			return (Voting) query.getSingleResult();
		} catch(NoResultException e) {
			return null;	
		}
	}

	
	
}
