package com.diegolirio.votenolivro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.votenolivro.model.Vote;
import com.diegolirio.votenolivro.service.VoteService;

@Controller
@RequestMapping("/voto")
public class VoteController {

	@Autowired
	private VoteService voteService;

	@RequestMapping(value="/salvar", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> save(@RequestBody Vote vote) {
		try {
			this.voteService.saveVoteUser(vote);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
