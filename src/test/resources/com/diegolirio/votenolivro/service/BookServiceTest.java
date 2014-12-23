package com.diegolirio.votenolivro.service;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.diegolirio.votenolivro.dao.BookDao;
import com.diegolirio.votenolivro.helper.BookHelper;
import com.diegolirio.votenolivro.model.Book;

public class BookServiceTest {

	private BookService bookService;
	private BookDao bookDao;
	private Book book;

	@Before
	public void setUp() throws Exception {
		bookService = new BookService();
		bookDao = mock(BookDao.class); 
		bookService.setAuthorDao(bookDao);
		book = BookHelper.getBookHelper();		
	}

	@Test
	public void testSave() {
		book.setId(0l);
		bookService.save(book);
		verify(bookDao).save(book);
		assertTrue(true);
	}

	@Test
	public void testGetByTitleAndYearAndPublisherAndEdicao() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

}
