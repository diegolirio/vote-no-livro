package com.diegolirio.votenolivro.helper;

import com.diegolirio.votenolivro.model.Vote;

public class VoteHelper {

	public static Vote getVoteHelper() {
		Vote vote = new Vote();
		vote.setId(1l);
		vote.setVotingBook(VotingBookHelper.getVotingBookHelper());
		vote.setUser(UserHelper.getUserHelper());
		return vote;
	}
	
}
