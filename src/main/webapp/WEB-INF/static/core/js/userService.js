app.factory('UserService', ['$http', function($http) {
	
	return {
		getUserByEmailForRegistration : function(email) {
											return $http.get(SERVER_APP + '/usuario/get/por/email/'+email+'/json');
										}
	};
	
}]);