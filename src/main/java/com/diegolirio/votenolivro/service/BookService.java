package com.diegolirio.votenolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.BookDao;
import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Publisher;

@Service("bookService")
public class BookService {

	@Autowired
	private BookDao bookDao;

	public void setAuthorDao(BookDao bookDao) {
		this.bookDao = bookDao;
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

	public List<Book> getList() {
		return this.bookDao.getList(Book.class);
	}

	public List<Book> getListContainsTitle(String title) {
		return this.bookDao.getListContainsTitle(title);
	}

	
}
