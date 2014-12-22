package com.diegolirio.votenolivro.controller;

import javax.servlet.http.HttpSession;

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
	public ResponseEntity<String> save(@RequestBody User user, HttpSession session) {
		try {
			this.userSerive.save(user);
			session.setAttribute("user", user);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String pageLogin() {
		return "user/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> login(@RequestBody User user, HttpSession session) {
		try {
			if(this.userSerive.login(user)) {
				User userlogged = this.userSerive.getUserByEmail(user.getEmail());
				session.setAttribute("user", userlogged);
			}
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}	
	
	
}