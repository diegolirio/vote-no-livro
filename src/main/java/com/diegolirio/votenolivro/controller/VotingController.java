package com.diegolirio.votenolivro.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diegolirio.votenolivro.model.User;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.model.Voting.Status;
import com.diegolirio.votenolivro.service.VotingService;

@Controller
@RequestMapping("/votacao")
public class VotingController {

	@Autowired
	private VotingService votingService;

	@RequestMapping(value="/s", method=RequestMethod.GET)
	public ModelAndView pageListVoting() {
		return new ModelAndView("voting/list");
	}

	@RequestMapping(value="/my", method=RequestMethod.GET)
	public ModelAndView pageMyListVoting() {
		return new ModelAndView("voting/my");
	}	
	
	@RequestMapping(value="/get/list/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getListJSON() {
		try {
			List<Voting> list = this.votingService.getList();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="/get/list/by/status/{status}/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getListbyStatus(@PathVariable("status") Status status) {
		try {
			List<Voting> list = this.votingService.getListByStatus(status);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	@RequestMapping(value="/get/list/by/user/{userId}/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getListByUser(@PathVariable("userId") long userId) {
		try {
			User user = new User();
			user.setId(userId);
			List<Voting> list = this.votingService.getListByUser(user);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list ), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/get/{id}/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Voting voting = this.votingService.get(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(voting), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}	

	@RequestMapping(value="/system/nova", method=RequestMethod.GET)
	public ModelAndView pageNova() {
		return new ModelAndView("voting/form");
	}
	
	@RequestMapping(value="/save/json", method=RequestMethod.POST, consumes="application/json", produces="application/json" )
	public ResponseEntity<String> save(@RequestBody Voting voting) {
		try {
			this.votingService.save(voting);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(voting), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/delete/json", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
	public ResponseEntity<String> delete(@RequestBody Voting voting) {
		try {
			this.votingService.delete(voting);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
