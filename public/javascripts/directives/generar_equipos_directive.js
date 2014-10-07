angular.module('app')
	.directive('generarEquipos', function(){
		return {
			restrict : 'E',
			templateUrl : '/generar-equipos',
			controller : 'GenerarEquiposController',
			controllerAs : 'equiposCtrl'
		};
	});