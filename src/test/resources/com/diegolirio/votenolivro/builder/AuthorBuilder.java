package com.diegolirio.votenolivro.builder;

import com.diegolirio.votenolivro.model.Author;

public class AuthorBuilder {
	
	public static Author getAuthorHelper() {
		Author author = new Author();
		author.setId(1l);
		author.setName("John Green");
		return author;
	}

}
