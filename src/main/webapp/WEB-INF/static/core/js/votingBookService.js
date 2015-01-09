app.factory('VotingBookService', ['$http', function($http) {
	
	return {
		getVotingBookListByVoting : function(votingId) {
										return $http.get(SERVER_APP + '/votacao_livro/get/lista/por/votacao/'+votingId+'/json');			
									},
									
		getVotingBook : function(id) {
							return $http.get(SERVER_APP + '/votacao_livro/'+id+'/json');
						}
	};
	
}]);