package com.diegolirio.votenolivro.builder;

import com.diegolirio.votenolivro.model.User;

public class UserBuilder {
	
	public static User getUserHelper() {
		User user = new User();
		user.setId(1l);
		user.setEmail("diegolirio.dl@gmail.com");
		user.setName("Diego Lirio Damacena Pereira");
		user.setNickname("Diego");
		user.setPassword("123456");
		return user;
	}

}
