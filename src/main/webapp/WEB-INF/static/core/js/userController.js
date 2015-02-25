app.controller('UserController', ['$scope', 'UserService',
                                  function($scope, UserService) {
	
	var self = this;
	self.isLoggedIn = false; 
	
	UserService.session().then(function(resp) {
//		$scope.isLoggedIn = UserService.isLoggedIn;
		self.isLoggedIn = true;
		self.user = resp.data;
		$scope.user = resp.data;
	});
	
}])
.controller('UserCadastreController', ['$scope', '$routeParams', '$location', 'UserService', 
                                          function($scope, $routeParams, $location, UserService) {
	
	var self = this;
	
	if($routeParams.email != undefined) {
		UserService.getUserByEmail($routeParams.email).then(function(resp) {
			self.user = resp.data; 
		});
	} else self.user = {}; 	

	self.saveUser = function(user, confirmPassword) {
		if(user.password == confirmPassword) {
			UserService.insert(user).then(function(resp) {
				alert('Usuario gravado com sucesso');
				$location.path("/usuario/cadastro/"+user.email);
			});
		} else alert("Senha confirmada não confere!");
	 };		 
	
}])
.controller('UserLoginController', ['$scope', 'UserService', function($scope, UserService) {
		
	var self = this;
	
	$scope.setHideMenu(true);
	
	self.login = function(user) {
		//$scope.showLoader();
		UserService.login(user).then(function(resp) {
			//$location.path("/");
			self.messageLogin = resp.data;
			//if (!self.messageLogin) alert(self.messageLogin);
 			if(JSON.parse(resp.data) == true)  
				window.location.href = SERVER_APP;
		});			
	};
	
}]);