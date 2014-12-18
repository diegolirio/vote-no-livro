package com.diegolirio.votenolivro.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.service.VotingService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private VotingService votingService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		 
		//Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		
		//model.addAttribute("serverTime", formattedDate );
		
		return "_base";
	}
	
	@RequestMapping(value = "/pre_cadastro", method = RequestMethod.GET)
	public String precadastro() {
		Voting voteNoLivro = this.votingService.getByDescription("Vote no Livro");
		if(voteNoLivro == null) {
			Voting voting = new Voting();
			voting.setDescription("Vote no Livro");
			voting.setFinalized(false);
			this.votingService.save(voting);
		}
		
		//Book book = 
		
		
		return "redirect:/";
	}
	
	
}
