angular.module('app')
    .controller('BusquedaJugadoresController', [ '$http', function($http) {

    var store = this;

    store.jugadores = [];

    $http.get('/jugadores').success(function(jugadores) {
        store.jugadores = jugadores;
    });

    //Cosas que agrego para usar la directive de detalle-jugador
    store.jugador;
    store.seleccionarJugador = function(unJugador) {
        store.jugador = unJugador;   
    };
}]);
