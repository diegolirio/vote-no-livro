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
	private Set<VotingBook> votingBooks;
	
	private boolean finalized = false;

	public Voting() {}
	
	public Voting(long id) {
		this.id = id;
	}

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

	public Set<VotingBook> getVotingBooks() {
		return votingBooks;
	}

	public void setVotingBooks(Set<VotingBook> votingBooks) {
		this.votingBooks = votingBooks;
	}

	public boolean isFinalized() {
		return finalized;
	}

	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}
	
	
	
}
