app.controller('BookFormController', ['$routeParams', 'BookService', 'PublisherService',
                                  function($routeParams, BookService, PublisherService) {
	
	var self = this;
	
	PublisherService.getList().then(function(resp) {
		self.publishers = resp.data;
	}, function(error) {
		alert(error.data);
	});
	
	BookService.get($routeParams.id).then(function(resp) {
		self.book = resp.data; 
	});
	
	self.save = function(book) {
		alert(JSON.stringify(book));
		BookService.save(book).then(function(resp) {
			self.book = resp.data;
		}, function(error) {
			alert(error.data);
		});
	};
	
	
}]);