var SERVER_APP = '/votenolivro'; 
var app = angular.module('app', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {				
		$routeProvider
		
			// voting 
			.when('/', {redirectTo: '/votacao/s'},
					{templateUrl: SERVER_APP + '/view/other', controller: 'MyOtherController'})
			.when('/votacao/s',    
					{ controller: 'VotingListController', templateUrl: SERVER_APP + '/votacao/s' })
			.when('/votacao/nova', 
					{ controller: 'VotingCadastreController', templateUrl: SERVER_APP + '/votacao/system/nova' })
			.when('/votacao/editar/:id', 
					{ controller: 'VotingCadastreController', templateUrl: SERVER_APP + '/votacao/system/nova' })
					
			// votingBook
			.when('/votacao_livro/lista-de-livro/votacao/:votingId',
					{ controller: 'VotingBookListByVoting', templateUrl: SERVER_APP + '/votacao_livro/lista' })
			.when('/votacao_livro/:id',
					{ controller: 'VotingBookConfirmVote', templateUrl: SERVER_APP + '/votacao_livro/confirmar' })
			.when('/usuario/cadastro/:email',
					{ controller: 'UserCadastreController', templateUrl: SERVER_APP + '/usuario/cadastro' })
			.when('/usuario/login',
					{ controller: 'UserLoginController', templateUrl: SERVER_APP + '/usuario/login' })
			.when('/d', 
					{template: '<aside class="right-side"><h1>Diego</h1></aside>'});
		
	}]); 