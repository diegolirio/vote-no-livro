package com.diegolirio.votenolivro.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.service.BookService;

@Controller
@RequestMapping("/livro")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value="/get/lista/por/votacao/{votingId}/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> get(@PathVariable("votingId") long votingId) {
		try {
			List<Book> books = this.bookService.getBooksByVoting(new Voting(votingId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(books), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}		
	
}
