angular.module('app')
	.controller('GenerarEquiposController',['$http',function($http) {

	var ctrl = this;

	ctrl.partido;
	ctrl.ordenadores = [];
	ctrl.armadores = [];

	ctrl.configuracion = {
		"ordenador": "Handicap",
		"armador": "Posiciones pares e impares"
	};

	$http.get('/ordenadores').success(function(ordenadores) {
		ctrl.ordenadores = ordenadores;
	});

	$http.get('/armadores').success(function(armadores) {
		ctrl.armadores = armadores;
	});

	ctrl.generarEquipos = function() {
		ctrl.configurarPartido();
		$http.get('/generar-equipos-opciones').success(function(partido) {
			ctrl.partido = partido;
		});
		
//			$http.post('/configuracion', ctrl.configuracion).success(function(response) {
//				console.log("Post OK");
//			}).error(function(response) {
//				console.log("Error en el POST");
//			});
		
	};

	ctrl.generarVisible = function() {
		return ctrl.ordenador && ctrl.armador;
	};

	ctrl.equiposVisible = function() {
		return ctrl.partido;
	};

	ctrl.confirmarPartido = function() {
		$http.post('/confirmar-partido', ctrl.partido).success(function(response) {
			console.log("Post OK");
			alert("El partido se genero exitosamente");
		}).error(function(response) {
			throw "Error en el POST";
		});
	};

	ctrl.configurarPartido = function() {
		$http.post('/configuracion', {
			"ordenador": ctrl.ordenador,
			"armador": ctrl.armador
		}).success(function(response) {
			console.log("Post OK");
		}).error(function(response) {
			throw "Error en el POST";
		});
	};
}]);