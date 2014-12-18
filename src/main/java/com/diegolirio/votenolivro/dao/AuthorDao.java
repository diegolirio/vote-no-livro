package com.diegolirio.votenolivro.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.Author;

@Repository("authorDao")
public class AuthorDao extends AbstractGenericDao<Author> {

	public Author getByName(String name) {
		Query query = super.manager.createQuery("Select a from Author a where a.name = :name");
		query.setParameter("name", name);
		try {
			return (Author) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	
	
}
