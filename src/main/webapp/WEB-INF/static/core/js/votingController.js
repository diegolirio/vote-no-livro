//$app.controller('marcaController', function($scope, $location, $window, $routeParams, $http) {

function votingController($scope, $location, $window, $routeParams, $http) {

	// Voting
	$scope.loadVotings = function() {
		$http.get($scope.server('/votacao/get/list/json')).success(function(data) {
			$scope.votings = data;
		});
	};
 
	$scope.getVoting = function(id) {
		$http.get($scope.server('/votacao/get/'+id+'/json')).success(function(data) {
			$scope.voting = data;  
		});		
	};
	
	// VotingBook	
	$scope.loadVotingBookList = function() {
		$scope.getVotingBooksByVoting($routeParams.votingId);
		$scope.getVoting($routeParams.votingId);
	};
	
	$scope.loadConfirm = function() {
		$scope.confirmedVote = false;
		$scope.getVotingBookById($routeParams.votingId);
	};
	
	$scope.getVotingBooksByVoting = function(id) {
		$http.get($scope.server('/votacao_livro/get/lista/por/votacao/'+id+'/json')).success(function(data) {
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
	
	// Vote
	$scope.computeVote = function() {		
		$scope.vote.votingBook = $scope.votingBook;		
		$http.post($scope.server("/voto/salvar"), $scope.vote).success(function(data) {
			$scope.confirmedVote = true;
			$scope.getVotingBooksByVoting($scope.vote.votingBook.voting.id);
		});		
	};
	
	// User
	$scope.loadUserCadastre = function() {
		$scope.getUserByEmail($routeParams.email);
	};
	
	$scope.getUserByEmail = function(email) {
		$http.get($scope.server('/usuario/get/por/email/'+email+'/json')).success(function(data) {
			$scope.user = data;
		});
	};
	
	$scope.saveUser = function(user, confirmPassword) {
		alert(JSON.stringify(user));
		if(user.password == confirmPassword) {
			http.post($scope.server('/usuario/salvar', user)).succsess(function(data) {
				alert('Usuario gravado com sucesso');
				$location.path("/usuario/cadastro/"+user.email);
			});
		} else {
			alert("Senha confirmada não confere!");
		}
	};
};