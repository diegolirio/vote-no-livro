package com.diegolirio.votenolivro.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.model.VotingBook;

@Repository("votingBookDao")
public class VotingBookDao extends AbstractGenericDao<VotingBook> {

	public VotingBook get(Voting voting, Book book) {
		Query query = super.manager.createQuery("Select vb from VotingBook vb where vb.book.id = :bookId and vb.voting.id = :votingId");
		query.setParameter("votingId", voting.getId());
		query.setParameter("bookId", book.getId());
		try {
			return (VotingBook) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Book> getVotingBooksByVoting(Voting voting) {
		Query query = super.manager.createQuery("Select vb from VotingBook vb where vb.voting.id = :votingId");
		query.setParameter("votingId", voting.getId());
		return query.getResultList();
	}

	public double getCountVotesByVotingBook(VotingBook votingBook) {
		Query query = super.manager.createQuery("Select count(vb) from VortingBook vb where vb.id = :votingBookId");
		query.setParameter("votingBookId", votingBook.getId());
		return 0;
	}	
	
}
