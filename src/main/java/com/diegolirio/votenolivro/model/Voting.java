package com.diegolirio.votenolivro.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Voting {
	
	public enum Status {
		PENDENTE, EM_ANDAMENTO, FINALIZADO
	}	

	@Id @GeneratedValue
	private long id;
	
	private String description;
	
	@JsonBackReference
	@OneToMany(mappedBy="voting")
	private Set<VotingBook> votingBooks;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "varchar(20) default 'PENDENTE'")	
	private Status status;

	private long countTotal;
	
	@ManyToOne
	private User userOwner;

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(long countTotal) {
		this.countTotal = countTotal;
	}

	public void setCountVotes(long countTotal) {
		this.countTotal = countTotal;
	}

	public User getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}

	@Override
	public String toString() {
		return "Voting [id=" + id + ", description=" + description
				+ ", status=" + status + ", countTotal=" + countTotal
				+ ", userOwner=" + userOwner + "]";
	}

	
	
	
	
}
