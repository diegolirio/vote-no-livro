package com.diegolirio.votenolivro.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.votenolivro.model.User;
import com.diegolirio.votenolivro.service.UserService;

@Controller
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UserService userSerive;

	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
	public String pageCadastre() {
		return "user/form";
	}
	
	@RequestMapping(value="/get/por/email/{email}/json", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getUserByEmailJSON(@PathVariable("email") String email) {
		try {
			User user = this.userSerive.getUserByEmail(email);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(user), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@RequestMapping(value="/salvar", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> save(@RequestBody User user) {
		System.out.println(user);
		try {
			this.userSerive.save(user);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
