(function() {

	var app = angular.module('app', [ 'ngAnimate' ]);

	app.controller('PanelController', [ '$http', function($http) {

		var current = 1;

		this.selectTab = function(index) {
			current = index;
		};

		this.isSelected = function(index) {
			return index === current;
		};
	} ]);

	app.directive('detalleJugador', function() {
		return {
			restrict : 'E',
			templateUrl : '/detalle-jugador'
		};
	});

	app.directive('generarEquipos', function(){
		return {
			restrict : 'E',
			templateUrl : '/generar-equipos',
			controller : 'GenerarEquiposController',
			controllerAs : 'equiposCtrl'
		};
	});

	app.directive('busquedaJugadores', function() {
		return {
			restrict : 'E',
			templateUrl : '/busqueda-jugadores'
		};
	});
	//	app.directive('listarJugadores', function() {
	//		return { restrict: 'E', templateUrl: '/listar-jugadores',
	//			scope:{ filtros: '@filtros' }, controller: function($http) {
	//
	//				var store = this;
	//				store.jugadores = [];
	//		
	//				$http.get('/jugadores').success(function(jugadores) {
	//					store.jugadores = jugadores;
	//				}); 
	//			}, controllerAs:'jc'
	//		}; 
	//	});
})();
