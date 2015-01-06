package com.diegolirio.votenolivro.builder;

import com.diegolirio.votenolivro.model.Vote;

public class VoteBuilder {

	public static Vote getVoteHelper() {
		Vote vote = new Vote();
		vote.setId(1l);
		vote.setVotingBook(VotingBookBuilder.getVotingBookHelper());
		vote.setUser(UserBuilder.getUserHelper());
		return vote;
	}
	
}
