package com.diegolirio.votenolivro.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.votenolivro.model.Publisher;
import com.diegolirio.votenolivro.service.PublisherService;

@Controller
@RequestMapping("/editora")
public class PublisherController {

	@Autowired
	public PublisherService publisherService;
	
	@RequestMapping(value="/get/list", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getList() {
		try {
			List<Publisher> list = this.publisherService.getList();
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
