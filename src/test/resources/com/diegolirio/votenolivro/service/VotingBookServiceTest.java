package com.diegolirio.votenolivro.service;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.diegolirio.votenolivro.dao.VotingBookDao;
import com.diegolirio.votenolivro.helper.VotingBookHelper;
import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.VotingBook;

public class VotingBookServiceTest {

	private VotingBookService votingBookService;
	private VotingBookDao votingBookDao;
	private VotingBook votingBook;

	@Before
	public void setUp() throws Exception {
		votingBookService = new VotingBookService();
		votingBookDao = mock(VotingBookDao.class); 
		votingBookService.setVotingBookDao(votingBookDao);
		votingBook = VotingBookHelper.getVotingBookHelper();		
	}

	@Test
	public void testGetVotingBookByVotingAndBook() {
		when(votingBookDao.get(votingBook.getVoting(), votingBook.getBook())).thenReturn(votingBook);
		VotingBook _votingBook = votingBookService.get(votingBook.getVoting(), votingBook.getBook());
		verify(votingBookDao).get(votingBook.getVoting(), votingBook.getBook());
		assertNotNull(_votingBook);		
	}

	@Test
	public void testSave() {
		votingBook.setId(0l);
		votingBookService.save(votingBook);
		verify(votingBookDao).save(votingBook);
		assertTrue(true);		
	}

	@Test
	public void testGetVotingBooksByVoting() {
		List<Book> books = votingBookService.getVotingBooksByVoting(votingBook.getVoting());
		//verify(votingBookDao).get
		assertNotNull(books); 
	}

	@Test
	public void testGetByID() {
		when(votingBookDao.get(VotingBook.class, votingBook.getId())).thenReturn(votingBook);
		VotingBook _votingBook = votingBookService.get(votingBook.getId());
		assertNotNull(_votingBook);
	}

}
