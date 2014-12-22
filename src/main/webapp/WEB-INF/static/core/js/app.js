$app = angular.module('app', []);

SERVER_URL = "/votenolivro";

$app.config(function($routeProvider, $httpProvider) {

	$routeProvider
		// home
		.when('/', { controller: votingController, templateUrl: SERVER_URL + '/votacao/s' })
		// voting 
		.when('/votacao/s',    
				{ controller: votingController, templateUrl: SERVER_URL + '/votacao/s' })
		.when('/votacao/nova', 
				{ controller: votingController, templateUrl: SERVER_URL + '/votacao/nova' })
		// votingBook 
		.when('/votacao_livro/lista-de-livro/votacao/:votingId',  
				{ controller: votingController, templateUrl: SERVER_URL + '/votacao_livro/lista' })
		.when('/votacao_livro/:id',                
				{ controller: votingController, templateUrl: SERVER_URL + '/votacao_livro/confirmar' })
		// usuario
		.when('/usuario/cadastro/:email',
				{ controller: votingController, templateUrl: SERVER_URL + '/usuario/cadastro' })
		.when('/usuario/cadastro',
				{ controller: votingController, templateUrl: SERVER_URL + '/usuario/cadastro' })
		.when('/usuario/login',
				{ controller: votingController, templateUrl: SERVER_URL + '/usuario/login' })
		.when('/usuario/esqueci_a_senha',
				{ controller: votingController, templateUrl: SERVER_URL + '/usuario/esqueci_a_senha' })	
		// not found
		.otherwise({redirectTo : '/'});
	
	$httpProvider.responseInterceptors.push(function($q,$rootScope) {
		
		return function(promise) {
			//Always disable loader
			$rootScope.hideLoader();
			return promise.then(function(response) {
				// do something on success
				return(response);
			}, function(response) {
				// do something on error
				$data = response.data;
				$error = $data.error;
				console.error($data);
				if ($error && $error.text)
					alert("ERROR ("+response.status+"): " + $error.text);
				else {	
					if (response.status=404)
						alert("Erro ao acessar servidor. Página não encontrada ("+response.status+").");
					else
						alert("ERROR ("+response.status+")!");
					}
				return $q.reject(response);
			});
		};
	});

});
 
$app.run(function($rootScope) {
	
	
	$rootScope.showLoaderFlag = false;
	
	//Força que o ícone de acesso ao servidor seja ativado
	$rootScope.showLoader = function() {
		$rootScope.showLoaderFlag=true;
	};
	//Força que o ícone de acesso ao servidor seja desativado
	$rootScope.hideLoader = function() {
		$rootScope.showLoaderFlag=false;
	};
	//Método que retorna a URL completa de acesso ao servidor.
	// Evita usar concatenação no conteroller
	$rootScope.server = function(url) {
		return SERVER_URL + url;
	};
});

// let's make a startFrom filter
$app.filter('startFrom', function() {
	return function(input, start) {
		if (input==null)
			return null;
		start = +start; //parse to int
		return input.slice(start);
	};
});
