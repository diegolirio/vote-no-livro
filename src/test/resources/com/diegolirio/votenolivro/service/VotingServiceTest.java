package com.diegolirio.votenolivro.service;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.diegolirio.votenolivro.dao.VotingDao;
import com.diegolirio.votenolivro.helper.VotingHelper;
import com.diegolirio.votenolivro.model.Voting;

public class VotingServiceTest {

	private VotingService votingService;
	private VotingDao votingDao;
	private Voting voting;

	@Before
	public void setUp() throws Exception {
		votingService = new VotingService();
		votingDao = mock(VotingDao.class); 
		votingService.setVotingDao(votingDao);
		voting = VotingHelper.getVotingHelper();		
	}

	@Test
	public void testGetList() {
		List<Voting> list = new ArrayList<Voting>();
		when(votingDao.getList(Voting.class)).thenReturn(list );	
		List<Voting> _list = votingService.getList();
		verify(votingDao).getList(Voting.class);
		assertNotNull(_list);
	}

	@Test
	public void testSave() {
		voting.setId(0l);
		votingService.save(voting);
		verify(votingDao).save(voting);
		assertTrue(true);	
	}

	@Test
	public void testGetByDescription() {
		when(votingDao.getByDescription(voting.getDescription())).thenReturn(voting);	
		Voting _voting = votingService.getByDescription(voting.getDescription());
		verify(votingDao).getByDescription(voting.getDescription());
		assertNotNull(_voting);
	}

	@Test
	public void testGet() {
		when(votingDao.get(Voting.class, voting.getId())).thenReturn(voting);
		Voting _voting = votingService.get(voting.getId());
		verify(votingDao).get(Voting.class, voting.getId());
		assertNotNull(_voting);		
	}

}
