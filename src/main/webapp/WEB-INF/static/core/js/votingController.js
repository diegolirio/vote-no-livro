
app.controller('VotingListController', ['$scope', '$http', 'VotingService', 
                                        function($scope, $http, VotingService) {
	
	var self = this;
	
	VotingService.getListVoting('EM_ANDAMENTO').then(function(resp) {
		self.votings = resp.data;
	});
	
	 
}])

.controller('VotingCadastreController', ['$scope', '$location', '$routeParams', 'VotingService',
                                         function($scope, $location, $routeParams, VotingService) {
	
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
		// TODO: colocar ususario logado no userService para busca!!!
		voting.userOwner = $scope.user;
		voting.status = 'PENDENTE';
		voting.countTotal = 0;
		
		if (voting.userOwner == null) {
			alert('Realize o login para criar uma votação!');
		} else {
			VotingService.save(voting).then(function(resp) {
				var _voting = resp.data;
				alert('Votação salvo com sucesso!'); 
				$location.path('/votacao/editar/'+_voting.id);
			});
		}
		
	};
	
	self.del = function(voting) {
		alert(JSON.stringify(voting));
		VotingService.del(voting).then(function(resp) {
			$location.path('/');
		}).error(function(data, status, headers, config) {
			alert(data); 
		});
	};
	
	
}])

.controller('VotingMyController', ['$scope', 'VotingService', 
                                   function($scope, VotingService) {
		
		var self = this;
		
		VotingService.getListVotingByUser($scope.user.id).then(function(resp) {
			self.votings = resp.data;
		}, function(error) {
			alert(error.data);
		});
	
}]);