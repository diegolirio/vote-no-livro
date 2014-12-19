//$app.controller('marcaController', function($scope, $location, $window, $routeParams, $http) {

function votingController($scope, $location, $window, $routeParams, $http) {

	// Voting
	$scope.loadVotings = function() {
		$http.get($scope.server('/votacao/get/list/json')).success(function(data) {
			$scope.votings = data;
		});
	};
 
	$scope.getVoting = function() {
		$http.get($scope.server('/votacao/get/'+$routeParams.id+'/json')).success(function(data) {
			$scope.voting = data;  
		});		
	};
	
	// VotingBook
	$scope.getVotingBooksByVoting = function() {
		//$scope.getVoting(); 
		$http.get($scope.server('/votacao_livro/get/lista/por/votacao/'+$routeParams.votingId+'/json')).success(function(data) {
			$scope.votingBooks = data;
		});		
	};	
	
	$scope.getVotingBookById = function() {
		$http.get($scope.server('/votacao_livro/'+$routeParams.id+'/json')).success(function(data) {
			$scope.votingBook = data;
		});		
	};	
	
	// Book
	$scope.getBookById = function() {
		$http.get($scope.server('/livro/'+$routeParams.id+'/json')).success(function(data) {
			$scope.book = data;
		});		
	};
	
};