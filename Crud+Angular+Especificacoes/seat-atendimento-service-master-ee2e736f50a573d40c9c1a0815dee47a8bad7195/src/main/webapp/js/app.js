angular.module('appAtendimento', ['ngAnimate', 'ngRoute','ngResource']) 
	.config(function($routeProvider, $locationProvider) {
		
		$routeProvider.when('/atendimento', {
			templateUrl: 'atendimento/partials/principal.html',
			controller: 'PrincipalController'
		})
		.when('/geral', {
			templateUrl: 'atendimento/partials/geral.html',
			controller: 'GeralController'
		})
		.when('/preferencial', {
			templateUrl: 'atendimento/partials/preferencial.html',
			controller: 'PreferencialController'
		});
		
		$routeProvider.otherwise({redirectTo: '/atendimento'});
		
		$locationProvider.html5Mode(false);
});