 
app.factory('VotingService', ['$http', function($http) {
	
	var _getListVoting = function() {
							return $http.get(SERVER_APP + '/votacao/get/list/json');
						 }; 
	
	return {
		getListVoting : _getListVoting,
		
		getVoting 	  : function(id) {
							return $http.get(SERVER_APP + '/votacao/get/'+id+'/json');
		},
						
		save : function(voting) {
					return $http.post(SERVER_APP + '/votacao/save/json', voting);
		},
			   
		del : function(voting) {
			return $http.put(SERVER_APP + '/votacao/delete/json', voting);
		}
	};
	 
}]);