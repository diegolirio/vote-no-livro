package com.diegolirio.votenolivro.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.diegolirio.votenolivro.model.User;
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
	
	@Test
	public void testDeveSalvarUsuarioJSON() throws Exception {
		
		User user = new User();
		user.setName("Diego Lirio Damacena Pereira");
		user.setEmail("diegolirio.dl@gmail.com");
		user.setNickname("Diego");
		user.setPassword("123456");
		user.setId(1l);
		
		String json = new ObjectMapper().writeValueAsString(user);
		
		mockMvc.perform(post("/usuario/salvar")
			        .contentType(MediaType.APPLICATION_JSON).content(json ))
			        .andExpect(status().isCreated());		
	}	
	
	@Test
	public void testDeveRetornarPaginaDeEsqueciASenha() throws Exception {
		mockMvc.perform(get("/usuario/esqueci_a_senha"))
				.andExpect(status().isOk())
				.andExpect(view().name("user/recover-password"));
	}
	
	@Test
	public void testDeveRecuperarSenhaDoUsuarioJSON() throws Exception {
		
		User user = new User();
		user.setEmail("diegolirio.dl@gmail.com");
		
		String json = new ObjectMapper().writeValueAsString(user);
		
		mockMvc.perform(post("/usuario/recover_password")
			        .contentType(MediaType.APPLICATION_JSON).content(json ))
			        .andExpect(status().isCreated());		
	}		
	
}
