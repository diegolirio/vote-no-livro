app.factory('VoteService', ['$http', function($http) {
	
	return {
		insert : function(vote) {
					return $http.post(SERVER_APP + '/voto/salvar', vote);
				}
	}
	
}]);