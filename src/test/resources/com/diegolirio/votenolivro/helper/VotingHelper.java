package com.diegolirio.votenolivro.helper;

import com.diegolirio.votenolivro.model.Voting;

public class VotingHelper {
	
	public static Voting getVotingHelper() {
		Voting voting = new Voting();
		voting.setId(1l);
		voting.setCountTotal(2l);
		voting.setCountVotes(2l);
		voting.setDescription("Vote no Livro");
		voting.setFinalized(false);
		return voting;
	}

}
