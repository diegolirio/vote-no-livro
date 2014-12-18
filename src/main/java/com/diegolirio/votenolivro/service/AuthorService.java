package com.diegolirio.votenolivro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.AuthorDao;
import com.diegolirio.votenolivro.model.Author;

@Service("authorService")
public class AuthorService {

	@Autowired
	private AuthorDao authorDao;

	public void save(Author author) {
		this.authorDao.save(author);
	}

	public Author getByName(String name) {
		return this.authorDao.getByName(name);
	}

	
}
