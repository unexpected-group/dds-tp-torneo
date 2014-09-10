(function() {
    var app = angular.module('app', []);

    app.controller('JugadoresController', ['$http', function($http) {

        var store = this;
        
        store.jugadores = [];

        $http.get('http://localhost:9000/jugadores').success(function(data) {
            store.jugadores = data;
        });
    }]);
    
    app.controller('GeneralController', ['$http', function($http) {

        var store = this;
        
        store.visible = 0;
        store.nombre = "";
        store.jugador = {};

		store.actualizar = function(n) {
        	store.nombre = n;
        	store.visible = 1;
        	$http.get('http://localhost:9000/jugadores/' + store.nombre).success(function(data) {
		        store.jugador = data;
		    });
        };
        
        store.ocultar = function() {
        	store.visible = 0;
        };
        
        store.estaVisible = function() {
        	return store.visible === 1;
        };
    }]);

    app.controller('EquipoController', ['$http', function($http) {

        var store = this;
        
        store.jugadores = [];

        $http.get('http://localhost:9000/generar-equipos/12').success(function(data) {
            store.jugadores = data;
        });
    }]);

    app.controller('OrdenamientoController', function() {

        var store = this;
        
        store.opciones = [
            {criterio: 'Handicap'},
            {criterio: 'Promedio del ultimo partido'},
            {criterio: 'Promedio de las ultimas calificaciones'}
        ];

        store.defecto = store.opciones[0];
    });

    app.controller('ArmadoController', function() {

        var store = this;
        
        store.opciones = [
            {criterio: 'Posiciones pares e impares'},
            {criterio: 'Posiciones hardcodeadas'},
        ];

        store.defecto = store.opciones[0];
    });
})();