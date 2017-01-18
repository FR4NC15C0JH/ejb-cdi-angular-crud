angular.module('appAtendimento')
	.controller('PreferencialController', function($scope, $route, $location, preferencialService) {
		
	$scope.preferencialALL = [];
	$scope.preferencial = {};
	
	$scope.addPreferencial = function(preferencial){
		preferencialService.salvar(preferencial)
	        .then(function() {
	        	$scope.preferencial = preferencial;
	        	$scope.preferencial = {};
	        	$route.reload();
	        }, 
	        	function(erro) {
	            	console.log(erro);
	        });
	};
	

	preferencialService.recuperarTodos() 
		.then(function(preferencialALL) {
		$scope.preferencialALL = preferencialALL;
	}, function(erro) {
		console.log(erro);
	});
	
	$scope.nextPage = function(path) {
		$location.path(path);
	}
	
});
