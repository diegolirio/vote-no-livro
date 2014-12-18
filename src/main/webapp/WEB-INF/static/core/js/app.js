$app = angular.module('app', []);

SERVER_URL = "/votenolivro";

$app.config(function($routeProvider, $httpProvider) {

	$routeProvider
		.when('/', { controller: votingController, templateUrl: SERVER_URL + '/votacao/s' })
		// voting 
		.when('/votacao/s',    { controller: votingController, templateUrl: SERVER_URL + '/votacao/s' })
		.when('/votacao/:id',  { controller: votingController, templateUrl: SERVER_URL + '/votacao/livros' })
		.when('/votacao/:id/livro/:bookId', { controller: votingController, templateUrl: SERVER_URL + '/votacao/livro/voto' })
		.when('/votacao/nova', { controller: votingController, templateUrl: SERVER_URL + '/votacao/nova' })
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
					alert("ERROR: " + $error.text);
				else {	
					if (response.status=404)
						alert("Erro ao acessar servidor. Página não encontrada. Veja o log de erros para maiores detalhes");
					else
						alert("ERROR! See log console");
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
