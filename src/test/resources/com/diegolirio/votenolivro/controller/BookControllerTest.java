package com.diegolirio.votenolivro.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class BookControllerTest {

	@InjectMocks
	private BookController controller;

	private MockMvc mockMvc;
	
	@Mock
	private BookService bookService;

	private Book book;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		Voting voting = new Voting();
		voting.setId(1l); 
		book = new Book();
		book.setId(1l);		
		book.setVoting(voting);
	}	
	
	@Test
	public void testDeveBuscarLivrosJSONPorVotacao() throws Exception {
		mockMvc.perform(get("/livro/get/lista/por/votacao/"+book.getVoting().getId()+"/json"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}	
	
}
