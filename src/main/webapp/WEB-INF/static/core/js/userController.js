app.controller('UserController', ['$scope', 'UserService',
                                  function($scope, UserService) {
	
	$scope.isLoggedIn = false; 
	
	UserService.session().then(function(resp) {
//		$scope.isLoggedIn = UserService.isLoggedIn;
		$scope.isLoggedIn = true;
		$scope.user = resp.data;
	});
	
}])
.controller('UserCadastreController', ['$scope', '$routeParams', '$location', 'UserService', 
                                          function($scope, $routeParams, $location, UserService) {
	
	$scope.loadUserCadastre = function() {
		if($routeParams.email != undefined) {
			UserService.getUserByEmail($routeParams.email).then(function(resp) {
				$scope.user = resp.data; 
			});
		} else $scope.user = {}; 
	};

	$scope.saveUser = function(user, confirmPassword) {
		if(user.password == confirmPassword) {
			UserService.insert(user).then(function(resp) {
				alert('Usuario gravado com sucesso');
				$location.path("/usuario/cadastro/"+user.email);
			});
		} else alert("Senha confirmada não confere!");
	 };	
	 
	
}])
.controller('UserLoginController', ['$scope', 'UserService', function($scope, UserService) {
	
	$scope.login = function(user) {
		//$scope.showLoader();
		UserService.login(user).then(function(resp) {
			//$location.path("/");
			$scope.messageLogin = resp.data;
 			if(JSON.parse(resp.data) == true)  
				window.location.href = SERVER_APP;
		});			
	};
	
}]);