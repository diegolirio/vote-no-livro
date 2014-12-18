package com.diegolirio.votenolivro.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Publisher;
import com.diegolirio.votenolivro.model.Voting;

@Repository("bookDao")
public class BookDao extends AbstractGenericDao<Book> {

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByVoting(Voting voting) {
		Query query = super.manager.createQuery("Select b from Book b where b.voting.id = :votingId");
		query.setParameter("votingId", voting.getId());
		return query.getResultList();
	}

	public Book getByTitleAndYearAndPublisherAndEdicao(String title, int year, Publisher publisher, int edicao) {
		String sql = "Select b from Book b "
					 + "where b.title = :title "
					 + "  and b.year = :year"
					 + "  and b.publisher.id = :publisherId"
					 + "  and b.edicao = :edicao";
		Query query = super.manager.createQuery(sql);
		query.setParameter("title", title);
		query.setParameter("year", year);
		query.setParameter("publisherId", publisher.getId());
		query.setParameter("edicao", edicao);
		try {
			return (Book) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

}
