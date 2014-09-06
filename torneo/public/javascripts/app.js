(function() {
    var app = angular.module('app', []);

    app.controller('JugadoresController', ['$http', function($http) {

        var store = this;
        
        store.jugadores = [];

        $http.get('http://localhost:9000/jugadores').success(function(data) {
            store.jugadores = data;
        });
    }]);
    
    app.controller('DetallesController', function() {

        this.activado = 1;
        this.nombre
        
        this.activar = function(nombre) {
        	this.activado = 1;
        	this.nombre = nombre
        };
        
        this.desactivar = function() {
        	this.activado = 0;
        };
        
        this.estaActivado = function() {
        	return this.activado === 1;
        };
    });
    
    app.controller('JugadorController', ['$http', function($http) {

        var store = this;
        
        store.nombre = "Juan Pablo Jacob";
        store.jugador = {};

        $http.get('http://localhost:9000/jugadores/' + store.nombre).success(function(data) {
            store.jugador = data;
        });
    }]);
})();