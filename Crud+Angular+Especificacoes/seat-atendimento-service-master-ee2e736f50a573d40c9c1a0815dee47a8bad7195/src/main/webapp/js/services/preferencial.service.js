'use strict';

angular.module('appAtendimento')
    .factory('preferencialService', preferencialService);

preferencialService.$inject = ['$log', '$resource'];

function preferencialService($log, $resource) {

    var resource = $resource('atendimento/rest/preferencial/:id', {id: '@id'}, {//segundo parametro é um mapeando de obj no endpoint sempre q for executado
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

    function recuperarPorID(preferencial) {
        return resource.get({preferencial}, '',
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