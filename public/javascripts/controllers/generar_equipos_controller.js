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
		$http.get('/partido').success(function(partido) {
			ctrl.partido = partido;
		});
	};

	ctrl.generarVisible = function() {
		return ctrl.partidoConfigurado;
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
		if(ctrl.ordenador && ctrl.armador) {
			$http.post('/configuracion', {
				"ordenador": ctrl.ordenador,
				"armador": ctrl.armador
			}).success(function(response) {
				console.log("Post OK");
				ctrl.partidoConfigurado = true;
			}).error(function(response) {
				throw "Error en el POST";
			});
		}
	};

	ctrl.jugador;
	ctrl.seleccionarJugador = function(unJugador) {
		ctrl.jugador = unJugador;	
	};
}]);