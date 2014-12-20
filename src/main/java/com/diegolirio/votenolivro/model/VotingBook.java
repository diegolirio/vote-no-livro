package com.diegolirio.votenolivro.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class VotingBook {

	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Voting voting;
	
	@ManyToOne
	private Book book;

	private long countVotes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Voting getVoting() {
		return voting;
	}

	public void setVoting(Voting voting) {
		this.voting = voting;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public long getCountVotes() {
		return countVotes;
	}

	public void setCountVotes(long countVotes) {
		this.countVotes = countVotes;
	}
	
	
	
}
