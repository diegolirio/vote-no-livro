package com.diegolirio.votenolivro.builder;

import com.diegolirio.votenolivro.model.Publisher;

public class PublisherBuilder {

	public static Publisher getPublisherHelper() {
		Publisher publisher = new Publisher();
		publisher.setId(1l);
		publisher.setName("Novatec");
		return publisher;
	}
	
}
