package com.diegolirio.votenolivro.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Publisher extends Person {
	
	@JsonBackReference
	@OneToMany(mappedBy="publisher")
	private Set<Book> books;

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
