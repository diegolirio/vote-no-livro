package com.diegolirio.votenolivro.helper;

import com.diegolirio.votenolivro.model.Author;

public class AuthorHelper {
	
	public static Author getAuthorHelper() {
		Author author = new Author();
		author.setId(1l);
		author.setName("John Green");
		return author;
	}

}
