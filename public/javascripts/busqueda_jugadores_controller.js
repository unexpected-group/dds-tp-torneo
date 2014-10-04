app.conntroller('JugadoresController', [ '$http', function($http) {

    var store = this;

    store.jugadores = [];

    $http.get('/jugadores').success(function(jugadores) {
        store.jugadores = jugadores;
    });

    store.jugador = {
        nombre : ""
    };

    store.noEstaVisible = function() {
        return store.jugador.nombre === "";
    };

    store.actualizar = function(unJugador) {
        console.log(unJugador);
        store.jugador = unJugador;
    };
}])
