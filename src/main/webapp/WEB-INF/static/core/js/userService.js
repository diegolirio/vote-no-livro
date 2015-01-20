app.factory('UserService', ['$http', function($http) {

	var _getUserByEmailForRegistration = function(email) {
		return $http.get(SERVER_APP + '/usuario/get/por/email/'+email+'/json');
	};

	var _getUserByEmail = function(email) {
		return $http.get(SERVER_APP + '/usuario/get/por/email/'+email+'/json');
	};
	
	var _insert = function(user) {
		return $http.post(SERVER_APP + '/usuario/salvar', user);
	};
	
	return {
		
		isLoggedIn : false,
		
		getUserByEmailForRegistration : function(email) {
											return $http.get(SERVER_APP + '/usuario/get/por/email/'+email+'/json');
										},

		getUserByEmail : function(email) {
							return $http.get(SERVER_APP + '/usuario/get/por/email/'+email+'/json');
						},
						
		insert : function(user) {
					return $http.post(SERVER_APP + '/usuario/salvar', user);
				 },
				 
		login : function(user) {
					return $http.post(SERVER_APP + '/usuario/login', user);
				},
				
		session : function() {
					return $http.get(SERVER_APP + '/usuario/session').then(function(response) {
						isLoggedIn = true;
						return response;
					});
				  }
	};
	
}]);