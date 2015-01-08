app.controller('VotingBookListByVoting', ['$scope', '$routeParams', 'VotingBookService', function($scope, $routeParams, VotingBookService) {
	
	$scope.loadVotingBookList = function() {
		VotingBookService.getVotingBookListByVoting($routeParams.votingId).then(function(resp) {
			$scope.votingBooks = resp.data;
		});
	};
	
}]);