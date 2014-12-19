package com.diegolirio.votenolivro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private VotingBook votingBook;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VotingBook getVotingBook() {
		return votingBook;
	}

	public void setVotingBook(VotingBook votingBook) {
		this.votingBook = votingBook;
	}	

}
