package com.diegolirio.votenolivro.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.service.VotingBookService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class VotingBookControllerTest {

	@InjectMocks
	private VotingBookController controller;

	private MockMvc mockMvc;
	
	@Mock
	private VotingBookService bookService;

	private Voting voting;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();		
		
		voting = new Voting();
		voting.setId(1l); 
	}	
	
	@Test
	public void testDeveBuscarLivrosJSONPorVotacao() throws Exception {
		mockMvc.perform(get("/votacao_livro/get/lista/por/votacao/"+voting.getId()+"/json"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}	
	

	@Test
	public void testDeveRetornarPaginaVotacaoLivroParaConfirmarComputacaoVoto() throws Exception {
		mockMvc.perform(get("/votacao_livro/confirmar"))
				.andExpect(status().isOk())
				.andExpect(view().name("voting-book/confirm"));
	}	
	
	@Test
	public void testDeveRetornarPaginaDeListaVotacaoLivros() throws Exception {
		mockMvc.perform(get("/votacao_livro/lista"))
			.andExpect(status().isOk())
			.andExpect(view().name("voting-book/list"));		
	}	
	
	@Test
	public void testDeveRetornarVotacaoLivroJSONPorID() throws Exception {
		mockMvc.perform(get("/votacao_livro/"+voting.getId()+"/json"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}	
		
	
}
