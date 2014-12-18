package com.diegolirio.votenolivro.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Voting;

@Repository("bookDao")
public class BookDao extends AbstractGenericDao<Book> {

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByVoting(Voting voting) {
		Query query = super.manager.createQuery("Select b from Book b where b.voting.id = :votingId");
		query.setParameter("votingId", voting.getId());
		return query.getResultList();
	}

}
