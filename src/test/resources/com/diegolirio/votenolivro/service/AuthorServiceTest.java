package com.diegolirio.votenolivro.service;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.diegolirio.votenolivro.dao.AuthorDao;
import com.diegolirio.votenolivro.helper.AuthorHelper;
import com.diegolirio.votenolivro.model.Author;


public class AuthorServiceTest {
	
	AuthorService authorService;
	private AuthorDao authorDao;
	private Author author;
	
	@Before
	public void before() {
		authorService = new AuthorService();
		authorDao = mock(AuthorDao.class);
		authorService.setAuthorDao(authorDao);
		author = AuthorHelper.getAuthorHelper();
	}
	
	@Test
	public void testDeveRetornarUsuarioPorEmail() {
		when(authorDao.getByName(author.getName())).thenReturn(author);
		Author _author = authorService.getByName(author.getName());
		assertNotNull(_author);
	}
	
	@Test
	public void testDeveSalvarAuthor() {
		author.setId(0l);
		authorService.save(author);
		verify(authorDao).save(author);
		assertTrue(true);
	} 
	

}
