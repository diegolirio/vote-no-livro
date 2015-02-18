app.factory('BookService', ['$http', function($http) {
	
	return {
		
		getAllBooks : function() {
			return $http.get(SERVER_APP + '/livro/get/all/json');
		},
		
		getBookContainsTitle : function(titleContains) {
			return $http.get(SERVER_APP + '/livro/get/contains/title/json?titleContains='+titleContains);
		}
		
	};
	
	
}]);