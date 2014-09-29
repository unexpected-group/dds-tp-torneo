(function() {
	
	var app = angular.module('app', [ 'ngAnimate', ]);

	var ordenadorSeleccionado = false;
	var armadorSeleccionado = false;

	app.controller('JugadoresController', [ '$http', function($http) {

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
	} ]);

	app.controller('EquipoController',[ '$http', function($http) {

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
			return ordenadorSeleccionado && armadorSeleccionado;
		};

		store.confirmarPartido = function() {
			$http.post('/confirmar-partido', store.jugadores).success(function(response) {
				console.log("Post OK");
				alert("El partido se genero exitosamente");
			}).error(function(response) {
				console.log("Error");
			});
//			var texto = confirm("¿Desea generar el partido con estos equipos?");
//			if (texto == true) {
//				alert("El partido se genero exitosamente");
//			} else {
//				alert("La operacion fue cancelada");
//			}
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
			ordenadorSeleccionado = true;
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
			armadorSeleccionado = true;
		};
	} ]);

	app.controller('PanelController', [ '$http', function($http) {

		var current = 1;

		this.selectTab = function(index) {
			current = index;
		};

		this.isSelected = function(index) {
			return index === current;
		};

		this.test = function() {
			$http.post('/test', {
				"nombre" : "Juan",
				"edad" : 21
			}).success(function(response) {
				console.log("Post OK");
			}).error(function(response) {
				console.log("Post WRONG");
			});
		};
	} ]);

	app.directive('detalleJugador', function() {
		return {
			restrict : 'E',
			templateUrl : '/detalle-jugador'
		};
	});

	app.directive('generarEquipos', function() {
		return {
			restrict : 'E',
			templateUrl : '/generar-equipos'
		};
	});

	app.directive('busquedaJugadores', function() {
		return {
			restrict : 'E',
			templateUrl : '/busqueda-jugadores'
		};
	});
//	app.directive('listarJugadores', function() { return { restrict: 'E',
//	templateUrl: '/listar-jugadores', scope:{ filtros: '@filtros' },
//	controller: function($http){ var store = this;
//	
//	store.jugadores = [];
//	
//	$http.get('/jugadores').success(function(jugadores) { store.jugadores =
//	jugadores; }); }, controllerAs:'jc' }; });
})();