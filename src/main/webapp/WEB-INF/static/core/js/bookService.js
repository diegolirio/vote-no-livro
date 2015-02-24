app.factory('BookService', ['$http', function($http) {
	
	return {
		
		getAllBooks : function() {
			return $http.get(SERVER_APP + '/livro/get/all/json');
		},
		
		getBookContainsTitle : function(titleContains) {
			return $http.get(SERVER_APP + '/livro/get/contains/title/json?titleContains='+titleContains);
		},
		
		save : function(book) {
			return $http.post(SERVER_APP + '/livro/save/json', book);
		},
		
		get : function(id) {
			return $http.get(SERVER_APP + '/livro/'+id+'/json');
		}
		
	};
	 
	
}]);