package com.diegolirio.votenolivro.controller;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.votenolivro.model.Author;
import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Publisher;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.service.AuthorService;
import com.diegolirio.votenolivro.service.BookService;
import com.diegolirio.votenolivro.service.PublisherService;
import com.diegolirio.votenolivro.service.VotingService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private VotingService votingService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private BookService bookService;
	
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
			voteNoLivro = new Voting();
			voteNoLivro.setDescription("Vote no Livro");
			voteNoLivro.setFinalized(false);
			this.votingService.save(voteNoLivro);
		}
		
		this.createCulpaDasEstrelas(voteNoLivro);
		this.createOLadoBomDaVida(voteNoLivro);
			
		return "redirect:/";
	}

	private void createCulpaDasEstrelas(Voting voteNoLivro) {
		Set<Author> authors = new HashSet<Author>();
		
		// verifica se ja existe...
		Author jonhGreen = this.authorService.getByName("Jonh Green");
		if(jonhGreen == null) {
			jonhGreen = new Author();
			jonhGreen.setName("Jonh Green");
			this.authorService.save(jonhGreen);
			authors.add(jonhGreen);
		}
		
		// verifica se ja existe...
		Publisher intrinseca = this.publisherService.getByName("Intrínseca");
		if(intrinseca == null) {
			intrinseca = new Publisher();
			intrinseca.setName("Intrínseca");
			this.publisherService.save(intrinseca);
		}
		
		// verifica se ja existe...
		Book aCulpaDasEstrelas = this.bookService.getByTitleAndYearAndPublisherAndEdicao("A Culpa É Das Estrelas", 2012, intrinseca, 1);
		if(aCulpaDasEstrelas  == null) {
			aCulpaDasEstrelas = new Book();
			aCulpaDasEstrelas.setTitle("A Culpa É Das Estrelas");
			aCulpaDasEstrelas.setYear(2012);
			aCulpaDasEstrelas.setAuthors(authors);
			aCulpaDasEstrelas.setPublisher(intrinseca);
			aCulpaDasEstrelas.setEdicao(1);
			aCulpaDasEstrelas.setVoting(voteNoLivro);
			aCulpaDasEstrelas.setImgUrl("/votenolivro/static/culpa_das_estrelas.jpg");
			this.bookService.save(aCulpaDasEstrelas);
		}
	}
	
	private void createOLadoBomDaVida(Voting voteNoLivro) {
		Set<Author> authors = new HashSet<Author>();
		
		// verifica se ja existe...
		Author matthewQuick = this.authorService.getByName("Matthew Quick");
		if(matthewQuick == null) {
			matthewQuick = new Author();
			matthewQuick.setName("Matthew Quick");
			this.authorService.save(matthewQuick);
			authors.add(matthewQuick);
		}
		
		// verifica se ja existe...
		Publisher intrinseca = this.publisherService.getByName("Intrínseca");
		if(intrinseca == null) {
			intrinseca = new Publisher();
			intrinseca.setName("Intrínseca");
			this.publisherService.save(intrinseca);
		}
		
		// verifica se ja existe...
		Book oLadoBomDaVida = this.bookService.getByTitleAndYearAndPublisherAndEdicao("O Lado Bom Da Vida", 2012, intrinseca, 1);
		if(oLadoBomDaVida == null) {
			oLadoBomDaVida = new Book();
			oLadoBomDaVida.setTitle("O Lado Bom Da Vida");
			oLadoBomDaVida.setYear(2013);
			oLadoBomDaVida.setAuthors(authors);
			oLadoBomDaVida.setPublisher(intrinseca);
			oLadoBomDaVida.setEdicao(1);
			oLadoBomDaVida.setVoting(voteNoLivro);
			oLadoBomDaVida.setImgUrl("/votenolivro/static/o_lado_bom_da_vida.jpg");
			this.bookService.save(oLadoBomDaVida);
		}
	}	
	
	
	
}
