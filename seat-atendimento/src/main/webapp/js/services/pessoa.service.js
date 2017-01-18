'use strict';

angular.module('appAtendimento')
    .factory('pessoaService', pessoaService);

pessoaService.$inject = ['$log', '$resource'];

function pessoaService($log, $resource) {

    var resource = $resource('atendimento/rest/pessoas/:id', {id: '@id'}, {//segundo parametro é um mapeando de obj no endpoint sempre q for executado
        // todos: {
        //     method: 'GET',
        //     url: CONTEXTO + 'rest/pessoas/todos',
        //     isArray: true
        // },
        alterar: {
            method: 'PUT',
            url: 'atendimento/rest/pessoas',
            isArray: false
        }
    });

    var service = {
        recuperarTodos: recuperarTodos,
        recuperarPorID: recuperarPorID,
        alterar: alterar,
        excluir: excluir,
        salvar: salvar
    };

    return service;

    function recuperarTodos() {
        return resource.query({}, '',
            function(data) {
                return data;
            },
            function(error) {
                $log.error(error.data.mensagem);
            }
        ).$promise;
    }

    function recuperarPorID(pessoa) {
        return resource.get({pessoa}, '',
            function(data) {
                return data;
            },
            function(error) {
                $log.error(error.data.mensagem);
            }
        ).$promise;
    }

  	function alterar(data) {
        return resource.alterar([], data,
            function() {},
            function(error) {
                $log.error(error.data.mensagem);
            }
        ).$promise;
    }

    function salvar(data) {
        return resource.save([], data,
            function() {},
            function(error) {
                $log.error(error.data.mensagem);
            }
        ).$promise;
    }

    function excluir(id) {
        return resource.delete({id : id},
            function() {},
            function(error) {
                $log.error(error.data.mensagem);
            }
        ).$promise;
    }

};