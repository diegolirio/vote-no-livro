app.controller('VotingBookListByVoting', ['$scope', '$routeParams', 'VotingBookService', 'VotingService', 
                                          function($scope, $routeParams, VotingBookService, VotingService) {
	
		var self = this;
		 
		// get voting by id
		VotingService.getVoting($routeParams.votingId).then(function(resp) {
			self.voting = resp.data;
		});		
		// get list voting book
		VotingBookService.getVotingBookListByVoting($routeParams.votingId).then(function(resp) {
			self.votingBooks = resp.data;
		});
		
}])
.controller('VotingBookConfirmVote', ['$scope', '$routeParams', 'VotingBookService', 'VoteService', 'UserService', 
	                                      function($scope, $routeParams, VotingBookService, VoteService, UserService) {
		
		var self = this;
	
		self.confirmedVote = false;
		//$scope.vote.user.email = $scope.user.email;
		VotingBookService.getVotingBook($routeParams.id).then(function(resp) {
			self.votingBook = resp.data;
		});
		
		
		self.computeVote = function() {
			self.vote.votingBook = self.votingBook;
			// insere voto
			VoteService.insert(self.vote).then(function(resp) {
				self.confirmedVote = true;	
				// busca lista para mostrar livro e percentual de votacao...
				VotingBookService.getVotingBookListByVoting(self.vote.votingBook.voting.id).then(function(resp) {
					self.votingBooks = resp.data;
				});
				// Busca Usuario por email para possivel termino de cadastro do mesmo
				UserService.getUserByEmailForRegistration(self.vote.user.email).then(function(resp) {
					self.user = resp.data;
					if(self.user.name == null) self.completeRegistration = true;	 				
				});
			});
		};
}]).
controller('VotingBookVotingAddBookController', ['$routeParams', '$window', 'VotingBookService', 'VotingService', 'BookService', 
                                                 function($routeParams, $window, VotingBookService, VotingService, BookService) {
	
	var self = this;
	//alert($routeParams.votingId);
	
	self.votingBook = {};	
	
	self.reload = function() {
		// get list voting book
		VotingBookService.getVotingBookListByVoting($routeParams.votingId).then(function(resp) {
			self.votingBooks = resp.data;
		});
		// get all books
		BookService.getAllBooks().then(function(resp) {
			self.books = resp.data;
		});		
	};	
	
	self.searchBook = function(word) {
		BookService.getBookContainsTitle(word).then(function(resp) {
			self.books = resp.data;
		});
	};
	
	self.addVotacaoLivro = function(voting, book) {
		self.votingBook.voting = voting;
		self.votingBook.book = book;
		VotingBookService.save(self.votingBook).then(function(resp) {
			//$window.location.reload();	
			self.reload();
		}, function(error) {
			alert('Erro: ' + error.data); 
		});
	};
	 
	self.remove = function(votingBook) {
		VotingBookService.del(votingBook).then(function(resp) {
			//$window.location.reload();
			self.reload();
		});
	};
	
	self.concluir = function(voting) {
		if(self.votingBooks.length >= 2) {
			voting.status = 'EM_ANDAMENTO';
			VotingService.save(voting).then(function(resp) {
				$window.location.reload();
			}, function(error) {
				alert('Erro: ' + error.data);
			});
		} else {
			alert('Votação deve conter no minimo 2 livros!');
		}
	};
	
	// ########## Init ##############	
	self.init = function() {
		// get voting by id
		VotingService.getVoting($routeParams.votingId).then(function(resp) {
			self.voting = resp.data;
		});		
		self.reload();		
	};
	self.init();
	// ########## End Init ##############		
	
}]);
	
	