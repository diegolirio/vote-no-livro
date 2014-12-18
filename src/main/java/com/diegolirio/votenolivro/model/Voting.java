package com.diegolirio.votenolivro.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Voting {

	@Id @GeneratedValue
	private long id;
	
	private String description;
	
	@JsonBackReference
	@OneToMany(mappedBy="voting")
	private Set<Book> books;
	
	private boolean finalized = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public boolean isFinalized() {
		return finalized;
	}

	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}
	
	
	
}
