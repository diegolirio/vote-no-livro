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
import com.diegolirio.votenolivro.model.User;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.model.Voting.Status;
import com.diegolirio.votenolivro.model.VotingBook;
import com.diegolirio.votenolivro.service.AuthorService;
import com.diegolirio.votenolivro.service.BookService;
import com.diegolirio.votenolivro.service.PublisherService;
import com.diegolirio.votenolivro.service.UserService;
import com.diegolirio.votenolivro.service.VotingBookService;
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

	@Autowired
	private VotingBookService votingBookService;

	@Autowired
	private UserService userService;
	
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
		
		User userOwner = this.userService.getUserByEmail("diegolirio.dl@gmail.com");
		if(userOwner == null) {
			userOwner = new User();
			userOwner.setEmail("diegolirio.dl@gmail.com"); 
			this.userService.save(userOwner);
		}
		
		Voting voteNoLivro = this.votingService.getByDescription("Vote no Livro");
		if(voteNoLivro == null) {
			voteNoLivro = new Voting();
			voteNoLivro.setDescription("Vote no Livro");
			voteNoLivro.setStatus(Status.EM_ANDAMENTO);
			voteNoLivro.setUserOwner(userOwner);
			this.votingService.save(voteNoLivro);
		}
		
		this.createCulpaDasEstrelas(voteNoLivro);
		this.createOLadoBomDaVida(voteNoLivro);
		this.createSeEuFicar(voteNoLivro); 
		this.createQueridoJohn(voteNoLivro);
		this.createDeixeANeveCair(voteNoLivro);	
		
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
			intrinseca.setName("Intrinseca");
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
			aCulpaDasEstrelas.setImgUrl("/votenolivro/static/imagesUp/culpa_das_estrelas.jpg");
			this.bookService.save(aCulpaDasEstrelas);
		}
		
		VotingBook voteNoLivroaCulpaDasEstrelas = this.votingBookService.get(voteNoLivro, aCulpaDasEstrelas);
		if(voteNoLivroaCulpaDasEstrelas == null) {
			voteNoLivroaCulpaDasEstrelas = new VotingBook();
			voteNoLivroaCulpaDasEstrelas.setBook(aCulpaDasEstrelas);
			voteNoLivroaCulpaDasEstrelas.setVoting(voteNoLivro);
			this.votingBookService.save(voteNoLivroaCulpaDasEstrelas);
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
			intrinseca.setName("Intrinseca");
			this.publisherService.save(intrinseca);
		}
		
		// verifica se ja existe...
		Book oLadoBomDaVida = this.bookService.getByTitleAndYearAndPublisherAndEdicao("O Lado Bom Da Vida", 2012, intrinseca, 1);
		if(oLadoBomDaVida == null) {
			oLadoBomDaVida = new Book();
			oLadoBomDaVida.setTitle("O Lado Bom Da Vida");
			oLadoBomDaVida.setYear(2013);
			oLadoBomDaVida.setPublisher(intrinseca);
			oLadoBomDaVida.setEdicao(1);
			oLadoBomDaVida.setImgUrl("/votenolivro/static/imagesUp/o_lado_bom_da_vida.jpg");
			oLadoBomDaVida.setAuthors(authors);
			this.bookService.save(oLadoBomDaVida);
		}
		
		VotingBook voteNoLivrooLadoBomDaVida = this.votingBookService.get(voteNoLivro, oLadoBomDaVida);
		if(voteNoLivrooLadoBomDaVida == null) {
			voteNoLivrooLadoBomDaVida = new VotingBook();
			voteNoLivrooLadoBomDaVida.setBook(oLadoBomDaVida);
			voteNoLivrooLadoBomDaVida.setVoting(voteNoLivro);
			this.votingBookService.save(voteNoLivrooLadoBomDaVida);
		}		
	}	
	
	private void createSeEuFicar(Voting voteNoLivro) {
		Set<Author> authors = new HashSet<Author>();
		
		// verifica se ja existe...
		Author gayleForman = this.authorService.getByName("Gayle Forman");
		if(gayleForman == null) {
			gayleForman = new Author();
			gayleForman.setName("Gayle Forman");
			this.authorService.save(gayleForman);
			authors.add(gayleForman);
		}
		
		// verifica se ja existe...
		Publisher novoConceito = this.publisherService.getByName("Novo Conceito");
		if(novoConceito == null) {
			novoConceito = new Publisher();
			novoConceito.setName("Novo Conceito");
			this.publisherService.save(novoConceito);
		}
		
		// verifica se ja existe...
		Book seEuFicar = this.bookService.getByTitleAndYearAndPublisherAndEdicao("Se Eu Ficar", 2014, novoConceito, 1);
		if(seEuFicar == null) {
			seEuFicar = new Book();
			seEuFicar.setTitle("Se Eu Ficar");
			seEuFicar.setYear(2013);
			seEuFicar.setPublisher(novoConceito);
			seEuFicar.setEdicao(1); 
			seEuFicar.setImgUrl("/votenolivro/static/imagesUp/se_eu_ficar.jpg");
			seEuFicar.setAuthors(authors);
			this.bookService.save(seEuFicar);
		}
		
		VotingBook voteNoLivroSeEuFicar = this.votingBookService.get(voteNoLivro, seEuFicar);
		if(voteNoLivroSeEuFicar == null) {
			voteNoLivroSeEuFicar = new VotingBook();
			voteNoLivroSeEuFicar.setBook(seEuFicar);
			voteNoLivroSeEuFicar.setVoting(voteNoLivro);
			this.votingBookService.save(voteNoLivroSeEuFicar);
		}		
	}	
		
	private void createQueridoJohn(Voting voteNoLivro) {
		Set<Author> authors = new HashSet<Author>();
		
		// verifica se ja existe...
		Author nicholasSparks = this.authorService.getByName("Nicholas Sparks");
		if(nicholasSparks == null) {
			nicholasSparks = new Author();
			nicholasSparks.setName("Nicholas Sparks");
			this.authorService.save(nicholasSparks);
			authors.add(nicholasSparks);
		}
		
		// verifica se ja existe...
		Publisher novoConceito = this.publisherService.getByName("Novo Conceito");
		if(novoConceito == null) {
			novoConceito = new Publisher();
			novoConceito.setName("Novo Conceito");
			this.publisherService.save(novoConceito);
		}
		
		// verifica se ja existe...
		Book queridoJohn = this.bookService.getByTitleAndYearAndPublisherAndEdicao("Querido John", 2010, novoConceito, 1);
		if(queridoJohn == null) {
			queridoJohn = new Book();
			queridoJohn.setTitle("Querido John");
			queridoJohn.setYear(2010);
			queridoJohn.setPublisher(novoConceito);
			queridoJohn.setEdicao(1); 
			queridoJohn.setImgUrl("/votenolivro/static/imagesUp/querido_john.jpg");
			queridoJohn.setAuthors(authors);
			this.bookService.save(queridoJohn);
		}
		
		VotingBook voteNoLivroQueridoJohn = this.votingBookService.get(voteNoLivro, queridoJohn);
		if(voteNoLivroQueridoJohn == null) {
			voteNoLivroQueridoJohn = new VotingBook();
			voteNoLivroQueridoJohn.setBook(queridoJohn);
			voteNoLivroQueridoJohn.setVoting(voteNoLivro);
			this.votingBookService.save(voteNoLivroQueridoJohn);
		}		
	}		

	private void createDeixeANeveCair(Voting voteNoLivro) {
		Set<Author> authors = new HashSet<Author>(); 
		
		// verifica se ja existe...
		Author johnGreen = this.authorService.getByName("John Green");
		if(johnGreen == null) {
			johnGreen = new Author();
			johnGreen.setName("John Green");
			this.authorService.save(johnGreen);
			authors.add(johnGreen);
		}
		
		Author laurenMyracle = this.authorService.getByName("Lauren Myracle");
		if(laurenMyracle == null) {
			laurenMyracle = new Author();
			laurenMyracle.setName("Lauren Myracle");
			this.authorService.save(laurenMyracle);
			authors.add(laurenMyracle);
		}
		
		Author maureenJohnson = this.authorService.getByName("Maureen Johnson");
		if(maureenJohnson == null) {
			maureenJohnson = new Author();
			maureenJohnson.setName("Maureen Johnson");
			this.authorService.save(maureenJohnson);
			authors.add(maureenJohnson);
		}
		
		// verifica se ja existe...
		Publisher rocco = this.publisherService.getByName("Rocco");
		if(rocco == null) {
			rocco = new Publisher();
			rocco.setName("Rocco");
			this.publisherService.save(rocco);
		}
		
		// verifica se ja existe...
		Book deixeANeveCair = this.bookService.getByTitleAndYearAndPublisherAndEdicao("Deixe A Neve Cair", 2013, rocco, 1);
		if(deixeANeveCair == null) {
			deixeANeveCair = new Book();
			deixeANeveCair.setTitle("Deixe A Neve Cair");
			deixeANeveCair.setYear(2013);
			deixeANeveCair.setPublisher(rocco);
			deixeANeveCair.setEdicao(1); 
			deixeANeveCair.setImgUrl("/votenolivro/static/imagesUp/deixe_a_neve_cair.png");
			deixeANeveCair.setAuthors(authors);
			this.bookService.save(deixeANeveCair);
		}
		
		VotingBook voteNoLivroDeixeANeveCair = this.votingBookService.get(voteNoLivro, deixeANeveCair);
		if(voteNoLivroDeixeANeveCair == null) {
			voteNoLivroDeixeANeveCair = new VotingBook();
			voteNoLivroDeixeANeveCair.setBook(deixeANeveCair);
			voteNoLivroDeixeANeveCair.setVoting(voteNoLivro);
			this.votingBookService.save(voteNoLivroDeixeANeveCair);
		}		
	}		

}
