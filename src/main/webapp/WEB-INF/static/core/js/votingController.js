//$app.controller('marcaController', function($scope, $location, $window, $routeParams, $http) {

function votingController($scope, $location, $window, $routeParams, $http) {

	$scope.voting = {"id":1,"description":"Vote no Livro","finalized":false};
	
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
	
	$scope.loadBooks = function() {
		//$scope.getVoting(); 
		$http.get($scope.server('/livro/get/lista/por/votacao/'+$routeParams.id+'/json')).success(function(data) {
			$scope.books = data;
		});		
	};	
	
};