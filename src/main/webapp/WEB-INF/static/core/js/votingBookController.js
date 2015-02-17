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
controller('VotingBookVotingAddBookController', ['$routeParams', function($routeParams) {
	
	var self = this;
	alert($routeParams.votingId);
	
}]);
	
	