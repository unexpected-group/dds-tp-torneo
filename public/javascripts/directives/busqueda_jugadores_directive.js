angular.module('app')
	.directive('busquedaJugadores', function() {
		return {
			restrict : 'E',
			templateUrl : '/busqueda-jugadores',
			controller : 'BusquedaJugadoresController',
			controllerAs : 'busquedaCtrl'
		};
	});