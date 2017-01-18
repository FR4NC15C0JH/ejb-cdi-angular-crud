angular.module('appAtendimento')
	.controller('GeralController', function($scope, $route, $location, geralService) {
		
	$scope.geralALL = [];
	$scope.geral = {};
	
	$scope.addGeral = function(geral){
		geralService.salvar(geral)
	        .then(function() {
	        	$scope.geral = geral;
	        	$scope.geral = {};
	        	$route.reload();
	        }, 
	        	function(erro) {
	            	console.log(erro);
	        });
	};
	

	geralService.recuperarTodos() 
		.then(function(geralALL) {
		$scope.geralALL = geralALL;
	}, function(erro) {
		console.log(erro);
	});
	
	$scope.nextPage = function(path) {
		$location.path(path);
	}
	
});
