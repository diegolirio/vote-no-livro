app.controller('VotingBookListByVoting', ['$scope', '$routeParams', 'VotingBookService', 'VotingService', 
                                          function($scope, $routeParams, VotingBookService, VotingService) {
	
		$scope.loadVotingBookList = function() {
			// get voting by id
			VotingService.getVoting($routeParams.votingId).then(function(resp) {
				$scope.voting = resp.data;
			});		
			// get list voting book
			VotingBookService.getVotingBookListByVoting($routeParams.votingId).then(function(resp) {
				$scope.votingBooks = resp.data;
			});
		};
		
	}])
	
	.controller('VotingBookConfirmVote', ['$scope', '$routeParams', 'VotingBookService', 'VoteService', 'UserService', 
	                                      function($scope, $routeParams, VotingBookService, VoteService, UserService) {
		
		$scope.loadConfirm = function() {
			$scope.confirmedVote = false;
			VotingBookService.getVotingBook($routeParams.id).then(function(resp) {
				$scope.votingBook = resp.data;
			});
		};
		
		$scope.computeVote = function() {
			$scope.vote.votingBook = $scope.votingBook;
			// insere voto
			VoteService.insert($scope.vote).then(function(resp) {
				$scope.confirmedVote = true;	
				// busca lista para mostrar livro e percentual de votacao...
				VotingBookService.getVotingBookListByVoting($scope.vote.votingBook.voting.id).then(function(resp) {
					$scope.votingBooks = resp.data;
				});
				// Busca Usuario por email para possivel termino de cadastro do mesmo
				UserService.getUserByEmailForRegistration($scope.vote.user.email).then(function(resp) {
					$scope.user = resp.data;
					if($scope.user.name == null) $scope.completeRegistration = true;	 				
				});
			});
		};
	}]);
	
	