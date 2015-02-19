app.factory('VotingBookService', ['$http', function($http) {
	
	return {
		getVotingBookListByVoting : function(votingId) {
			return $http.get(SERVER_APP + '/votacao_livro/get/lista/por/votacao/'+votingId+'/json');			
									},
									
		getVotingBook : function(id) {
			return $http.get(SERVER_APP + '/votacao_livro/'+id+'/json');
						},
						
		save : function(votingBook) {
			return $http.post(SERVER_APP + '/votacao_livro/save/json', votingBook);
		},
		
		del : function(votingBook) {
			return $http.post(SERVER_APP + '/votacao_livro/delete/json', votingBook);
		}
		
	};
	
}]);