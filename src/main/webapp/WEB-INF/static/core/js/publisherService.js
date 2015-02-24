app.factory('PublisherService', ['$http', function($http) {
	
	return {
		
		getList : function() {
			return $http.get(SERVER_APP + '/editora/get/list'); 
		}
		
	};
	
}]);