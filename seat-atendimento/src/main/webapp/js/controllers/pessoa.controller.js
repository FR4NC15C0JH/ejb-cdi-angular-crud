angular.module('appAtendimento')
	.controller('PessoaController', function($scope, pessoaService) {
		
	$scope.pessoas = [];
	$scope.pessoa = {};
	
	
//	$scope.submeter = function() {
//		console.log($scope.pessoa);
//	};
	
	$scope.adicionar = function(pessoa){
		pessoaService.salvar(pessoa)
	        .then(function() {
	        	$scope.pessoa = pessoa;
	        	
	        }, function(erro) {
	            console.log(erro);
	        });
		
	};

	pessoaService.recuperarTodos() 
		.then(function(pessoas) {
		$scope.pessoas = pessoas;
	}, function(erro) {
		console.log(erro);
	});
	
	$scope.editar = function(pessoa){
		pessoaService.alterar(pessoa)
	        .then(function() {
	        	$scope.pessoa = pessoa;
	        }, function(erro) {
	            console.log(erro);
	        });
	};
	
	$scope.remover = function(pessoa){
		pessoaService.excluir(pessoa.id)
			.then(function() {
				var indiceDaPessoa = $scope.pessoas.indexOf(pessoa);
				$scope.pessoas.splice(indiceDaPessoa, 1);
		},
		function(erro){
			console.log(erro);
		});
	};
});
