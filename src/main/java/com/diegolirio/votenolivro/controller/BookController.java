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
	
	@RequestMapping(value="/get/all/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getAll() {
		try {
			List<Book> list = this.bookService.getList();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/get/contains/title/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getContainsTitle(String titleContains) {
		try {
			List<Book> list = this.bookService.getListContainsTitle(titleContains);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String pageForm() {
		return "book/form";
	}
	
	@RequestMapping(value="/save/json", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> save(@RequestBody Book book) {
		try {
			this.bookService.save(book);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(book), HttpStatus.CREATED); 
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
 