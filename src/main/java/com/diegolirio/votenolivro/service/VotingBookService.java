package com.diegolirio.votenolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.votenolivro.dao.VotingBookDao;
import com.diegolirio.votenolivro.model.Book;
import com.diegolirio.votenolivro.model.Voting;
import com.diegolirio.votenolivro.model.VotingBook;

@Service("votingBookService")
public class VotingBookService {

	@Autowired
	private VotingBookDao votingBookDao;

	public VotingBook get(Voting voting, Book book) {
		return this.votingBookDao.get(voting, book);
	}

	public void save(VotingBook votingBook) {
		this.votingBookDao.save(votingBook);
	}

	public List<Book> getVotingBooksByVoting(Voting voting) {
		return this.votingBookDao.getVotingBooksByVoting(voting);
	}

	public VotingBook get(long id) {
		return this.votingBookDao.get(VotingBook.class, id);
	}
	
	
}
