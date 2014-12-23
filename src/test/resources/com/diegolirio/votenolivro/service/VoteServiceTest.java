package com.diegolirio.votenolivro.service;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.diegolirio.votenolivro.dao.VoteDao;
import com.diegolirio.votenolivro.helper.VoteHelper;
import com.diegolirio.votenolivro.model.Vote;

public class VoteServiceTest {

	private VoteService voteService;
	private VoteDao voteDao;
	private Vote vote;
	private VotingService votingService;
	private UserService userService;
	private VotingBookService votingBookService;

	@Before
	public void setUp() throws Exception {
		voteService = new VoteService();
		voteDao = mock(VoteDao.class); 
		voteService.setVoteDao(voteDao);
		votingService = mock(VotingService.class);
		voteService.setVotingService(votingService);
		userService = mock(UserService.class);
		voteService.setUserService(userService);
		votingBookService = mock(VotingBookService.class);
		voteService.setVotingBookService(votingBookService);
		vote = VoteHelper.getVoteHelper();			
	}

	@Test
	public void testSaveVoteUser() {
		vote.setId(1l);
		when(userService.getUserIfExistOrSaveNotExist(vote.getUser().getEmail())).thenReturn(vote.getUser());
		voteService.saveVoteUser(vote);
		
		verify(userService).getUserIfExistOrSaveNotExist(vote.getUser().getEmail());
		verify(voteDao).save(vote);
		verify(voteDao).getCountVotesByVotingBook(vote.getVotingBook());
		verify(votingBookService).save(vote.getVotingBook());
		verify(voteDao).getCountByVoting(vote.getVotingBook().getVoting());
		verify(votingService).save(vote.getVotingBook().getVoting());		
		
		assertTrue(true);		
	}

}
