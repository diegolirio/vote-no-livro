package com.diegolirio.votenolivro.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Author extends Person {

	@JsonBackReference
	@ManyToMany(mappedBy="authors")
	private Set<Book> books;

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	
}
