var SERVER_APP = '/votenolivro'; 
var app = angular.module('app', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {				
		$routeProvider
			.when('/', {redirectTo: '/votacao/s'},
					{templateUrl: SERVER_APP + '/view/other', controller: 'MyOtherController'})
			.when('/votacao/s',    
					{ controller: 'VotingListController', templateUrl: SERVER_APP + '/votacao/s' })
			.when('/d', 
					{template: '<aside class="right-side"><h1>Diego</h1></aside>'});
		
	}]); 