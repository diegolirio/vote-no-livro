var SERVER_APP = '/votenolivro'; 
var app = angular.module('app', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {				
		$routeProvider
		
		// voting 
		.when('/',                   { redirectTo: '/votacao/s'})
		.when('/votacao/s',          { templateUrl: SERVER_APP + '/votacao/s' })
		.when('/votacao/nova',       { templateUrl: SERVER_APP + '/votacao/system/nova' })
		.when('/votacao/editar/:id', { templateUrl: SERVER_APP + '/votacao/system/nova' })
		.when('/votacao/my',         { templateUrl: SERVER_APP + '/votacao/my' })		
		
		// votingBook
		.when('/votacao_livro/lista-de-livro/votacao/:votingId', { templateUrl: SERVER_APP + '/votacao_livro/lista' })
		.when('/votacao_livro/:id',                              { templateUrl: SERVER_APP + '/votacao_livro/confirmar' })
		.when('/votacao_livro/votacao/:votingId/add/livro',      { templateUrl: SERVER_APP + '/votacao_livro/add/livro' })
		
		// Book
		.when('/livro/form/:id',     { templateUrl: SERVER_APP + '/livro/form' })
		.when('/livro/:id/upImagem', { templateUrl: SERVER_APP + '/livro/up_imagem' })
		
		// usuario
		.when('/usuario/cadastro/:email', { templateUrl: SERVER_APP + '/usuario/cadastro' })
		.when('/usuario/login',           { templateUrl: SERVER_APP + '/usuario/login' })
		.when('/d',                       { template: '<aside class="right-side"><h1>Diego</h1></aside>'});		
		
}]); 

app.run(['$rootScope', function($rootScope) {
	
	$rootScope.hideMenu = false; 
	
	$rootScope.setHideMenu = function(isHide) {
		$rootScope.hideMenu = isHide;
	};	
	
}]);
