package com.diegolirio.votenolivro.service;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.diegolirio.votenolivro.dao.UserDao;
import com.diegolirio.votenolivro.helper.UserHelper;
import com.diegolirio.votenolivro.model.User;


public class UserServiceTest {
	
	UserService userService;
	private UserDao userDao;
	private User user;
	
	@Before
	public void before() {
		userService = new UserService();
		userDao = Mockito.mock(UserDao.class);
		userService.setUserDao(userDao);
		user = UserHelper.getUserHelper();
	}
	
	@Test
	public void testDeveRetornarUsuarioPorEmail() {
		Mockito.when(userDao.getUserByEmail("diegolirio.dl@gmail.com")).thenReturn(user);
		User userByEmail = userService.getUserByEmail("diegolirio.dl@gmail.com");
		Assert.assertNotNull(userByEmail);
	}

	@Test
	public void testDeveRetornarUsuarioPorEmailOuSeNaoExisteSalvaUsuarioERetornalo_SALVANDO() {
		Mockito.when(userDao.getUserByEmail("diegolirio.dl@gmail.com")).thenReturn(null);
		User _user = userService.getUserIfExistOrSaveNotExist("diegolirio.dl@gmail.com");
		Assert.assertNotNull(_user);
	}
	
	@Test
	public void testDeveRetornarUsuarioPorEmailOuSeNaoExisteSalvaUsuarioERetornalo_PorEmail() {
		Mockito.when(userDao.getUserByEmail("diegolirio.dl@gmail.com")).thenReturn(user);
		User _user = userService.getUserIfExistOrSaveNotExist("diegolirio.dl@gmail.com");
		Assert.assertNotNull(_user);
	}
	
	
}
