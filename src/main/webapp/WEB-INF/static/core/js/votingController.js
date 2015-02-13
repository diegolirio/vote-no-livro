
app.controller('VotingListController', ['$scope', '$http', 'VotingService', 
                                        function($scope, $http, VotingService) {
	
	var self = this;
	
	VotingService.getListVoting().then(function(resp) {
		self.votings = resp.data;
	});
	
	 
}])
.controller('VotingCadastreController', ['$scope', '$http', '$location', '$routeParams', 'VotingService',
                                         function($scope, $http, $location, $routeParams, VotingService) {
	
	var self = this;
	
	if($routeParams.id > 0) {
		self.title = "Editar Votação";
		VotingService.getVoting($routeParams.id).then(function(resp) {
			self.voting = resp.data;
		});		
	} else {
		self.title = "Nova Votação";
	}
	
	self.save = function(voting) {
		// colocar ususario logado no service para busca!!!
		voting.userOwner = $scope.user;
		voting.finalized = false;
		voting.countTotal = 0;
		//alert(JSON.stringify(voting));
		
		if (voting.userOwner == null) {
			alert('Realize o login para criar uma votação!');
		} else {
			VotingService.save(voting).then(function(resp) {
				//alert(JSON.stringify(resp.data));
				var _voting = resp.data;
				$location.path('/votacao/edit/'+_voting.id);
			});
		}
		
	};
	
	
}]);