package com.diegolirio.votenolivro.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.service.VotingService;

@Controller
@RequestMapping("/votacao")
public class VotingController {

	@Autowired
	private VotingService votingService;

	@RequestMapping(value="/s", method=RequestMethod.GET)
	public String pageListVoting() {
		return "_base";
<<<<<<< HEAD
=======
	}
	
	@RequestMapping(value="/get/list/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getListJSON() {
		try {
			List<Voting> list = this.votingService.getList();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
>>>>>>> i3
	}
	
}
