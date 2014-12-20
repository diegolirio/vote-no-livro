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

import com.diegolirio.votenolivro.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class UserControllerTest {

	@InjectMocks
	private UserController controller;

	private MockMvc mockMvc;
	
	@Mock
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testDeveRetornarPaginaDeCadastroUsuario() throws Exception {
		mockMvc.perform(get("/usuario/cadastro"))
				.andExpect(status().isOk())
				.andExpect(view().name("user/form"));
	}

	@Test
	public void testDeveBuscarUsuarioPorEmailJSON() throws Exception {
		String email = "diegolirio.dl@gmail.com";
		mockMvc.perform(get("/usuario/get/por/email/"+email +"/json"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}
	
}
