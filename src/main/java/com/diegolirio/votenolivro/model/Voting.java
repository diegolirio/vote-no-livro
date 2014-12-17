package com.diegolirio.votenolivro.model;

import java.util.Set;

public class Voting {

	private long id;
	
	private String description;
	
	private Set<Vote> votes;

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

	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}
	
	
	
}
