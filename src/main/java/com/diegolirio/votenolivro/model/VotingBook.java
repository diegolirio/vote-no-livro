package com.diegolirio.votenolivro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"voting_id", "book_id"})})
public class VotingBook {

	@Id @GeneratedValue
	private long id;
	 
	@ManyToOne 
	@JoinColumn(name="voting_id", nullable=false)
	private Voting voting;
	
	@ManyToOne
	@JoinColumn(name="book_id", nullable=false)
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

	@Override
	public String toString() {
		return "VotingBook [id=" + id + ", voting=" + voting + ", book=" + book
				+ ", countVotes=" + countVotes + "]";
	}
	
	
	
}
