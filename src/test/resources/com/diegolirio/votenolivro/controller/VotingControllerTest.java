package com.diegolirio.votenolivro.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class VotingControllerTest {

	@InjectMocks
	private VotingController controller;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testDeveRetornarPaginaDeVotacoes() throws Exception {
		mockMvc.perform(get("/votacao/s")).andExpect(status().isOk())
				.andExpect(view().name("voting/list"));
		// .andExpect(MockMvcResultMatchers.model().attributeExists("content_import"))
		// .andExpect(MockMvcResultMatchers.model().attribute("content_import",
		// "edicao-list"));
	}

	@Test
	public void testDeveBuscarVotacoesJSON() throws Exception {
		mockMvc.perform(get("/votacao/get/list/")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

}
