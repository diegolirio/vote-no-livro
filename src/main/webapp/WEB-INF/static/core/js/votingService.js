 
app.factory('VotingService', ['$http', function($http) {
	
	var _getListVoting = function() {
							return $http.get(SERVER_APP + '/votacao/get/list/json');
						 }; 
	
	return {
		getListVoting : _getListVoting 
	};
	 
}]);