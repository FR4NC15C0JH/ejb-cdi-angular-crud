angular.module('appAtendimento', ['ngAnimate', 'ngRoute','ngResource']) 
	.config(function($routeProvider, $locationProvider) {
		$locationProvider.html5Mode(true);
		
		$routeProvider.when('/atendimento', {
			templateUrl: 'atendimento/partials/principal.html',
			controller: 'PessoaController'
		});
		
		$routeProvider.otherwise({redirectTo: '/atendimento'});
});