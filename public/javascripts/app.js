(function() {
	var app = angular.module('app', []);
	
	var botonGenerar = 0;

	app.controller('JugadoresController', [ '$http', function($http) {

		var store = this;

		store.jugadores = [];

		$http.get('/jugadores').success(function(jugadores) {
			store.jugadores = jugadores;
		});
	} ]);

	app.controller('GeneralController', [ '$http', function($http) {

		var store = this;

		store.visible = 0;
		store.nombre = "";
		store.jugador = {};

		store.actualizar = function(n) {
			store.nombre = n;
			store.visible = 1;
			$http.get('/jugadores/' + store.nombre).success(function(jugador) {
				store.jugador = jugador;
			});
		};

		store.ocultar = function() {
			store.visible = 0;
		};

		store.estaVisible = function() {
			return store.visible === 1;
		};
	} ]);

	app.controller('EquipoController', [ '$http', function($http) {

		var store = this;

		store.visible = 0;
		store.jugadores = [];

		store.generarEquipos = function() {
			$http.get('/generar-equipos-opciones').success(function(jugadores) {
				store.jugadores = jugadores;
				store.visible = 1;
			});
		};

		store.estaVisible = function() {
			return store.visible === 1;
		};
		
		store.mostrar = function() {
			return botonGenerar > 1;
		};

	} ]);

	app.controller('OrdenamientoController', [ '$http', function($http) {

		var store = this;

		store.ordenadores = [];

		$http.get('/criterios-ordenamiento').success(function(ordenadores) {
			store.ordenadores = ordenadores;
		});

		store.setOrdenador = function() {
			$http.get('/criterios-ordenamiento/' + store.seleccionado);
			botonGenerar += 1;
		};
	} ]);

	app.controller('ArmadoController', [ '$http', function($http) {

		var store = this;

		store.armadores = [];

		$http.get('/criterios-armado').success(function(armadores) {
			store.armadores = armadores;
		});

		store.setArmador = function() {
			$http.get('/criterios-armado/' + store.seleccionado);
			botonGenerar += 1;
		};
	} ]);

	app.directive('detalleJugador', function() {
		return {
			restrict: 'E',
			templateUrl: '/detalle-jugador'
		};
	});
	
	logGeneracionEquipos = function() {
	    var txt;
	    var r = confirm("¿Desea generar los equipos?");
	    if (r == true) {
	        alert("Los quipos se generaron exitosamente!");
	    } else {
	        alert("Operacion cancelada.");
	    }
	}
})();