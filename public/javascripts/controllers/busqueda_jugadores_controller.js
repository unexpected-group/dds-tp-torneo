angular.module('app')
    .controller('BusquedaJugadoresController', [ '$http', function($http) {

    var ctrl = this;

    ctrl.jugadores = [];

    $http.get('/jugadores').success(function(jugadores) {
        ctrl.jugadores = jugadores;
    });

    ctrl.jugador;
    ctrl.seleccionarJugador = function(unJugador) {
        ctrl.jugador = unJugador;   
    };
}]);
