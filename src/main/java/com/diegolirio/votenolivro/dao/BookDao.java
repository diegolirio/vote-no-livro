package com.diegolirio.votenolivro.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Publisher;

@Repository("bookDao")
public class BookDao extends AbstractGenericDao<Book> {

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
