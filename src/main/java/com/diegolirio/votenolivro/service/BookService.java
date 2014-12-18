package com.diegolirio.votenolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.BookDao;
import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Voting;

@Service("bookService")
public class BookService {

	@Autowired
	private BookDao bookDao;

	public List<Book> getBooksByVoting(Voting voting) {
		return this.bookDao.getBooksByVoting(voting);
	}

	
}
