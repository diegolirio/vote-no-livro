package com.diegolirio.votenolivro.model;

import java.util.Set;

public class Author extends Person {

	private Set<Book> books;

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	
}
