package com.diegolirio.votenolivro.builder;

import java.util.HashSet;
import java.util.Set;

import com.diegolirio.votenolivro.model.Author;
import com.diegolirio.votenolivro.model.Book;

public class BookBuilder {
	
	public static Book getBookHelper() {
		Book book = new Book();
		book.setId(1l);
		book.setEdicao(1);
		book.setImgUrl("imagem.jpg");
		book.setPublisher(PublisherBuilder.getPublisherHelper());
		book.setTitle("Desenvolvendo com AngularJS");
		book.setYear(2014);

		Set<Author> authors = new HashSet<Author>();
		authors.add(AuthorBuilder.getAuthorHelper());
		book.setAuthors(authors);
		return book;
	}

}
