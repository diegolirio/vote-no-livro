package com.diegolirio.votenolivro.model;

import java.util.Set;

public class Publisher extends Person {
	
	private Set<Book> books;

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	

}
