package com.diegolirio.votenolivro.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.diegolirio.votenolivro.model.User;
import com.diegolirio.votenolivro.model.Vote;
import com.diegolirio.votenolivro.model.VotingBook;
import com.diegolirio.votenolivro.service.VoteService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class VoteControllerTest {

	@InjectMocks
	private VoteController controller;

	private MockMvc mockMvc;
	
	@Mock
	private VoteService votingService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testDeveSalvarVoto() throws Exception {
		
		User user = new User();
		user.setEmail("diegolirio.dl@gmail.com");
		
		VotingBook votingBook = new VotingBook();
		votingBook.setId(1l);
		
		Vote vote = new Vote();
		vote.setUser(user);
		vote.setVotingBook(votingBook);
		
		String json = new ObjectMapper().writeValueAsString(vote);
		
		mockMvc.perform(post("/voto/salvar")
			        .contentType(MediaType.APPLICATION_JSON).content(json ))
			        .andExpect(status().isCreated());		
	}	
	
	
}
