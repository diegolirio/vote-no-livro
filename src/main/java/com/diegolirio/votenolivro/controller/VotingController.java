package com.diegolirio.votenolivro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/votacao")
public class VotingController {

	@RequestMapping(value="/s", method=RequestMethod.GET)
	public String pageListVoting() {
		return "_base";
	}
	
}
