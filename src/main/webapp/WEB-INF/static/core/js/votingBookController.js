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
	
	.controller('VotingBookConfirmVote', ['$scope', '$routeParams', 'VotingBookService', 'VoteService', 
	                                      function($scope, $routeParams, VotingBookService, VoteService) {
		
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
				// TODO: busca lista para mostrar livro e percentual de votacao...
			});
		};
	}]);
	
	