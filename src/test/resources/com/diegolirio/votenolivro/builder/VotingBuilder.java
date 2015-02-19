package com.diegolirio.votenolivro.builder;

import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.model.Voting.Status;

public class VotingBuilder {
	
	public static Voting getVotingHelper() {
		Voting voting = new Voting();
		voting.setId(1l);
		voting.setCountTotal(2l);
		voting.setCountVotes(2l);
		voting.setDescription("Vote no Livro");
		voting.setStatus(Status.EM_ANDAMENTO);
		return voting;
	}

}
