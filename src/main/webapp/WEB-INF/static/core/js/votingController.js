
app.controller('VotingListController', ['$scope', '$http', 'VotingService', function($scope, $http, VotingService) {
	
	$scope.loadVotings = function() {		
		VotingService.getListVoting().then(function(resp) {
			$scope.votings = resp.data;
		});
	};
	 
}]);