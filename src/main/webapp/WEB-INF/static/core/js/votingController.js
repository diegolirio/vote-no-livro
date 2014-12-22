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
		$scope.getVotingBookById($routeParams.id);
	};
	
	$scope.getVotingBooksByVoting = function(id) {
		$http.get($scope.server('/votacao_livro/get/lista/por/votacao/'+id+'/json')).success(function(data) {
			$scope.votingBooks = data;
		});		
	};	
	
	$scope.getVotingBookById = function(id) {
		$http.get($scope.server('/votacao_livro/'+id+'/json')).success(function(data) {
			$scope.votingBook = data;
		});		
	};
	
	// Book 
	$scope.getBookById = function(id) {
		$http.get($scope.server('/livro/'+id+'/json')).success(function(data) {
			$scope.book = data;
		});		
	};
	
	// Vote
	$scope.computeVote = function() {		
		$scope.vote.votingBook = $scope.votingBook;		
		$http.post($scope.server("/voto/salvar"), $scope.vote).success(function(data) {
			$scope.confirmedVote = true;
			$scope.getVotingBooksByVoting($scope.vote.votingBook.voting.id);
			$scope.getUserByEmailForRegistration($scope.vote.user.email);
		});		
	};
	
	// User
	$scope.loadUserCadastre = function() {
		if($routeParams.email != undefined) {
			$scope.getUserByEmail($routeParams.email); 
		} else {
			$scope.user = {}; 
		}
	};
	
	$scope.getUserByEmail = function(email) {
		$http.get($scope.server('/usuario/get/por/email/'+email+'/json')).success(function(data) {
			$scope.user = data;
		});
	};
	

	$scope.getUserByEmailForRegistration = function(email) {
		$http.get($scope.server('/usuario/get/por/email/'+email+'/json')).success(function(data) {
			$scope.user = data;
			if($scope.user.name == null) 
				$scope.completeRegistration = true;
		});
	};	
	
	$scope.saveUser = function(user, confirmPassword) {
		if(user.password == confirmPassword) {
			$http.post($scope.server("/usuario/salvar"), user).success(function(data) {
				alert('Usuario gravado com sucesso');
				//$location.path("/usuario/cadastro/"+user.email);
				window.location.href = $scope.server("/");  
			});			
			
		} else {
			alert("Senha confirmada não confere!");
		}
	};
	
	$scope.login = function(user) {
		$http.post($scope.server("/usuario/login"), user).success(function(data) {
			//$location.path("/");
			window.location.href = $scope.server("/");  
		});			
	};
	
	$scope.recoverPassword = function(user) {
		$http.post($scope.server("/usuario/recover_password"), user).success(function(data, statusText, response) {
			if(JSON.parse(data) == true)     
				alert('Email enviado com a senha...');  
			else   
				alert('Email não cadastrado na base de dados ou cadastro encontra-se incompleto!!!\nNa pagina de login clique em Criar nova conta');
		});		
	};

};