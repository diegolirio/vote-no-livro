package com.diegolirio.votenolivro.helper;

import com.diegolirio.votenolivro.model.Publisher;

public class PublisherHelper {

	public static Publisher getPublisherHelper() {
		Publisher publisher = new Publisher();
		publisher.setId(1l);
		publisher.setName("Novatec");
		return publisher;
	}
	
}
