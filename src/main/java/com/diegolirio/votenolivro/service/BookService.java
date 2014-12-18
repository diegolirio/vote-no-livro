package com.diegolirio.votenolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.BookDao;
import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Publisher;
import com.diegolirio.votenolivro.model.Voting;

@Service("bookService")
public class BookService {

	@Autowired
	private BookDao bookDao;

	public List<Book> getBooksByVoting(Voting voting) {
		return this.bookDao.getBooksByVoting(voting);
	}

	public void save(Book book) {
		if(book.getId() == 0) 
			this.bookDao.save(book);
		else
			this.bookDao.update(book);
	}

	public Book getByTitleAndYearAndPublisherAndEdicao(String title, int year, Publisher publisher, int edicao) {
		return this.bookDao.getByTitleAndYearAndPublisherAndEdicao(title, year, publisher, edicao);
	}

	public Book get(long id) {
		return this.bookDao.get(Book.class, id);
	}

	
}
