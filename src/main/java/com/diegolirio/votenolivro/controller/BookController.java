package com.diegolirio.votenolivro.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.service.BookService;

@Controller
@RequestMapping("/livro")
public class BookController {

	@Autowired
	private BookService bookService;	
	
	@RequestMapping(value="/{id}/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Book book = this.bookService.get(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(book), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}		
	
}
