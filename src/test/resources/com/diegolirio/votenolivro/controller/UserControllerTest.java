package com.diegolirio.votenolivro.controller;

import static org.mockito.Mockito.when;
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

import com.diegolirio.votenolivro.builder.UserBuilder;
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
	
	private User user;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		user = UserBuilder.getUserHelper();
	}

	@Test
	public void testDeveRetornarPaginaDeCadastroUsuario() throws Exception {
		mockMvc.perform(get("/usuario/cadastro"))
				.andExpect(status().isOk())
				.andExpect(view().name("user/form"));
	}

	@Test
	public void testDeveBuscarUsuarioPorEmailJSON() throws Exception {
		mockMvc.perform(get("/usuario/get/por/email/"+user.getEmail()+"/json"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void testDeveSalvarUsuarioJSON() throws Exception {
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
		String json = new ObjectMapper().writeValueAsString(user);
		when(userService.recoverPassword(user)).thenReturn(true);
		
		mockMvc.perform(post("/usuario/recover_password")
			        .contentType(MediaType.APPLICATION_JSON).content(json))
			        .andExpect(status().isOk())
			        ;//.andExpect(content().string("true"));		
	}		
	
	@Test
	public void testDeveRetornarFalsoAoRecuperarSenhaDoUsuarioJSON() throws Exception {
		
		String json = new ObjectMapper().writeValueAsString(user);
		when(userService.recoverPassword(user)).thenReturn(false);
		
		mockMvc.perform(post("/usuario/recover_password")
			        .contentType(MediaType.APPLICATION_JSON).content(json))
			        .andExpect(status().isOk())
			        .andExpect(content().string("false"));
	}		
	
	@Test
	public void testDeveRealizarLoginDoUsuarioJSON() throws Exception {
		String json = new ObjectMapper().writeValueAsString(user);
		boolean logged=true;
		when(userService.login(user)).thenReturn(logged);
		
		mockMvc.perform(post("/usuario/login")
			        .contentType(MediaType.APPLICATION_JSON).content(json))
			        .andExpect(status().isOk())
			        ;//.andExpect(content().string("true"));		
	}		
	
	@Test
	public void testDeveRealizarLoginComFalhaDoUsuarioJSON() throws Exception {
		user.setPassword("XXXX");
		String json = new ObjectMapper().writeValueAsString(user);
		boolean logged=false;
		when(userService.login(user)).thenReturn(logged);
		
		mockMvc.perform(post("/usuario/login")
			        .contentType(MediaType.APPLICATION_JSON).content(json))
			        .andExpect(status().isOk())
			        .andExpect(content().string("Usuario ou senha invalido!"));		
	}		
	
	@Test
	public void testDeveRealizarUmLogout() throws Exception {
		mockMvc.perform(get("/usuario/logout"))
				.andExpect(status().is(302));
	}	
	
	@Test
	public void testDeveVerificarUsuarioEstaLogadoOK() throws Exception {
		String json = new ObjectMapper().writeValueAsString(user);
		mockMvc.perform(get("/usuario/session")
					.sessionAttr("user", user)
			        .contentType(MediaType.APPLICATION_JSON).content(json))
			        .andExpect(status().isOk());
	}			
	
	@Test
	public void testDeveVerificarUsuarioEstaLogadoFalha() throws Exception {
		String json = new ObjectMapper().writeValueAsString(user);
		mockMvc.perform(get("/usuario/session")
					//.sessionAttr("user", user)
			        .contentType(MediaType.APPLICATION_JSON).content(json))
			        .andExpect(status().isUnauthorized())
			        .andExpect(content().string("Usuario desconectado"));		
	}				
}
