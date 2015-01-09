var SERVER_APP = '/votenolivro'; 
var app = angular.module('app', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {				
		$routeProvider
			// voting 
			.when('/', {redirectTo: '/votacao/s'},
					{templateUrl: SERVER_APP + '/view/other', controller: 'MyOtherController'})
			.when('/votacao/s',    
					{ controller: 'VotingListController', templateUrl: SERVER_APP + '/votacao/s' })
			// votingBook
			.when('/votacao_livro/lista-de-livro/votacao/:votingId',
					{ controller: 'VotingBookListByVoting', templateUrl: SERVER_APP + '/votacao_livro/lista' })
			.when('/votacao_livro/:id',
					{ controller: 'VotingBookConfirmVote', templateUrl: SERVER_APP + '/votacao_livro/confirmar' })
			.when('/d', 
					{template: '<aside class="right-side"><h1>Diego</h1></aside>'});
		
	}]); 