package com.diegolirio.votenolivro.builder;

import com.diegolirio.votenolivro.model.VotingBook;

public class VotingBookBuilder {
	
	public static VotingBook getVotingBookHelper() {
		VotingBook votingBook = new VotingBook();
		votingBook.setId(1l);
		votingBook.setCountVotes(2l);
		votingBook.setBook(BookBuilder.getBookHelper());
		votingBook.setVoting(VotingBuilder.getVotingHelper());
		return votingBook;
	}

}
