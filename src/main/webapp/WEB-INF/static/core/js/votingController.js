
app.controller('VotingListController', ['$scope', '$http', 'VotingService', 
                                        function($scope, $http, VotingService) {
	
	var self = this;
	
	VotingService.getListVoting().then(function(resp) {
		self.votings = resp.data;
	});
	
	 
}]);