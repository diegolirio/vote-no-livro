package com.diegolirio.votenolivro.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.Publisher;

@Repository("publisherDao")
public class PublisherDao extends AbstractGenericDao<Publisher> {

	public Publisher getByName(String name) {
		Query query = super.manager.createQuery("Select p from Publisher p where p.name = :name");
		query.setParameter("name", name);
		try {
			return (Publisher) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

}
