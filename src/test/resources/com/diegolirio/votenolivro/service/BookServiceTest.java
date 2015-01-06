package com.diegolirio.votenolivro.service;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.diegolirio.votenolivro.builder.BookBuilder;
import com.diegolirio.votenolivro.dao.BookDao;
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
		book = BookBuilder.getBookHelper();		
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
		when(bookDao.getByTitleAndYearAndPublisherAndEdicao(book.getTitle(), book.getYear(), book.getPublisher(), book.getEdicao())).thenReturn(book);
		Book _book = bookService.getByTitleAndYearAndPublisherAndEdicao(book.getTitle(), book.getYear(), book.getPublisher(), book.getEdicao());
		verify(bookDao).getByTitleAndYearAndPublisherAndEdicao(book.getTitle(), book.getYear(), book.getPublisher(), book.getEdicao());
		assertNotNull(_book);
	}

	@Test
	public void testGet() {
		when(bookDao.get(Book.class, book.getId())).thenReturn(book);
		Book _book = bookService.get(book.getId());
		verify(bookDao).get(Book.class, book.getId());
		assertNotNull(_book);
	}

}
