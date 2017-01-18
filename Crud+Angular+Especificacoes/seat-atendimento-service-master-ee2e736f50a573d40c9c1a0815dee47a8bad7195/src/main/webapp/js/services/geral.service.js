'use strict';

angular.module('appAtendimento')
    .factory('geralService', geralService);

geralService.$inject = ['$log', '$resource'];

function geralService($log, $resource) {

    var resource = $resource('atendimento/rest/geral/:id', {id: '@id'}, {//segundo parametro é um mapeando de obj no endpoint sempre q for executado
    });

    var service = {
        recuperarTodos: recuperarTodos,
        recuperarPorID: recuperarPorID,
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

    function recuperarPorID(geral) {
        return resource.get({geral}, '',
            function(data) {
                return data;
            },
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
};