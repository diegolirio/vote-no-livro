package com.diegolirio.votenolivro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.VoteDao;
import com.diegolirio.votenolivro.model.User;
import com.diegolirio.votenolivro.model.Vote;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.model.VotingBook;

@Service("voteService")
public class VoteService {

	@Autowired
	private VoteDao voteDao;
	
	@Autowired
	private UserService userService;

	@Autowired
	private VotingBookService votingBookService;

	@Autowired
	private VotingService votingService;
	

	public void setVoteDao(VoteDao voteDao) {
		this.voteDao = voteDao;
	}	
	
	public void setVotingService(VotingService votingService) {
		this.votingService = votingService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setVotingBookService(VotingBookService votingBookService) {
		this.votingBookService = votingBookService;
	}

	public void saveVoteUser(Vote vote) {
		User user = this.userService.getUserIfExistOrSaveNotExist(vote.getUser().getEmail());
		vote.setUser(user);
		this.voteDao.save(vote); 
		// Updates count Book votes		
		VotingBook votingBook = vote.getVotingBook();
		long countVotes = this.voteDao.getCountVotesByVotingBook(vote.getVotingBook());
		votingBook.setCountVotes(countVotes);
		this.votingBookService.save(votingBook);
		// Updates count total
		Voting voting = vote.getVotingBook().getVoting();
		long countTotal = this.voteDao.getCountByVoting(voting);
		voting.setCountVotes(countTotal);
		this.votingService.save(voting);
	}
}
