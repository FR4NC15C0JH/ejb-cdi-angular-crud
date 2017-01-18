angular.module('appAtendimento')
	.controller('PrincipalController', function($scope, $location) {
		
		$scope.nextPage = function(path) {
			$location.path(path);
		}
	});