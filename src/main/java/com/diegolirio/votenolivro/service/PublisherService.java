package com.diegolirio.votenolivro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.PublisherDao;
import com.diegolirio.votenolivro.model.Publisher;

@Service("publisherService")
public class PublisherService {

	@Autowired
	private PublisherDao publisherDao;

	public void save(Publisher intrinseca) {
		this.publisherDao.save(intrinseca);
	}

	public Publisher getByName(String name) {
		return this.publisherDao.getByName(name);
	}

	
	
}
