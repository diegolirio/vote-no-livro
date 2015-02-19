package com.diegolirio.votenolivro.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.User;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.model.Voting.Status;

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

	@SuppressWarnings("unchecked")
	public List<Voting> getListByStatus(Status status) {
		Query query = super.manager.createQuery("Select v from Voting v where v.status = :status");
		query.setParameter("status", status);
		return (List<Voting>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Voting> getListByUser(User user) {
		Query query = super.manager.createQuery("Select v from Voting v where v.userOwner.id = :userId");
		query.setParameter("userId", user.getId());
		return (List<Voting>) query.getResultList();
	}

	
	
}
