package com.diegolirio.votenolivro.service;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.diegolirio.votenolivro.builder.UserBuilder;
import com.diegolirio.votenolivro.dao.UserDao;
import com.diegolirio.votenolivro.model.User;


public class UserServiceTest {
	
	UserService userService;
	private UserDao userDao;
	private User user;
	
	@Before
	public void before() {
		userService = new UserService();
		userDao = mock(UserDao.class);
		userService.setUserDao(userDao);
		user = UserBuilder.getUserHelper();
	}
	
	@Test
	public void testDeveRetornarUsuarioPorEmail() {
		when(userDao.getUserByEmail("diegolirio.dl@gmail.com")).thenReturn(user);
		User userByEmail = userService.getUserByEmail("diegolirio.dl@gmail.com");
		assertNotNull(userByEmail);
	}

	@Test
	public void testDeveRetornarUsuarioPorEmailOuSeNaoExisteSalvaUsuarioERetornalo_SALVANDO() {
		when(userDao.getUserByEmail("diegolirio.dl@gmail.com")).thenReturn(null);
		User _user = userService.getUserIfExistOrSaveNotExist("diegolirio.dl@gmail.com");
		assertNotNull(_user);
	}
	
	@Test
	public void testDeveRetornarUsuarioPorEmailOuSeNaoExisteSalvaUsuarioERetornalo_PorEmail() {
		when(userDao.getUserByEmail("diegolirio.dl@gmail.com")).thenReturn(user);
		User _user = userService.getUserIfExistOrSaveNotExist("diegolirio.dl@gmail.com");
		assertNotNull(_user);
	}
	
	@Test
	public void testDeveSalvarUsuario() {
		user.setId(0l);
		userService.save(user);
		verify(userDao).save(user);
		assertTrue(true);
	} 
	
	@Test
	public void testDeveSalvarUsuarioComCadastroIncompleto() {
		user.setId(0l);
		when(userDao.getUserByEmail(user.getEmail())).thenReturn(user);
		userService.save(user);
		verify(userDao).update(user);
		assertTrue(true);
	} 
	
	@Test
	public void testDeveSalvarUsuarioAlterado() {
		user.setName("Diego Lirio D. Pereira");
		userService.save(user);
		verify(userDao).update(user);
		assertTrue(true);
	} 	
		
	@Test
	public void testDeveRealizarLogin() {
		when(userDao.login(user)).thenReturn(true);
		boolean logged = userService.login(user);
		verify(userDao).login(user);
		Assert.assertTrue(logged);
	} 		
	
	@Test
	public void testDeveRecuperarSenhaDoUsuario() {
		when(userDao.getUserByEmail(user.getEmail())).thenReturn(user);
		boolean recoverPassword = userService.recoverPassword(user);
		verify(userDao).getUserByEmail(user.getEmail());
		assertTrue(recoverPassword);
	} 		
	
	@Test
	public void testDeveTentarRecuperarSenhaDoUsuarioQueNaoExisteNoBD() {
		when(userDao.getUserByEmail(user.getEmail())).thenReturn(null);
		boolean recoverPassword = userService.recoverPassword(user);
		verify(userDao).getUserByEmail(user.getEmail());
		assertFalse(recoverPassword);
	} 	
	
	@Test
	public void testDeveTentarRecuperarSenhaDoUsuarioComCadastroIncompletoOndeASenhaNaoFoiCadastrado() {
		user.setPassword(null);
		when(userDao.getUserByEmail(user.getEmail())).thenReturn(user);
		boolean recoverPassword = userService.recoverPassword(user);
		verify(userDao).getUserByEmail(user.getEmail());
		assertFalse(recoverPassword);
	} 		
}
