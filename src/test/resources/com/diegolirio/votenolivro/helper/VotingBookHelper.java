package com.diegolirio.votenolivro.helper;

import com.diegolirio.votenolivro.model.VotingBook;

public class VotingBookHelper {
	
	public static VotingBook getVotingBookHelper() {
		VotingBook votingBook = new VotingBook();
		votingBook.setId(1l);
		votingBook.setCountVotes(2l);
		votingBook.setBook(BookHelper.getBookHelper());
		votingBook.setVoting(VotingHelper.getVotingHelper());
		return votingBook;
	}

}
