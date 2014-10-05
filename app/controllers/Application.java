package controllers;

import static play.libs.Json.toJson;
import model.armador.ParesImpares;
import model.armador.PosicionesDadas;
import model.homes.CriteriosArmadoHome;
import model.homes.CriteriosOrdenamientoHome;
import model.homes.JugadoresHome;
import model.homes.PartidosHome;
import model.ordenador.Handicap;
import model.ordenador.PromedioUltimasCalificaciones;
import model.ordenador.PromedioUltimoPartido;
import model.partido.Configuracion;
import model.partido.Partido;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.busqueda_jugadores;
import views.html.generar_equipos;
import views.html.index;
import views.html.detalle_jugador;
import views.html.listar_jugadores;

import com.fasterxml.jackson.databind.JsonNode;

public class Application extends Controller {

	private static Configuracion configuracion = new Configuracion(null, null);

	// GET /
	public static Result index() {
		return ok(index.render("Futbol 5"));
	}

	// GET /jugadores
	public static Result obtenerJugadores() {
		return ok(toJson(JugadoresHome.getJugadores()));
	}

	// GET /jugadores/:nombre
	public static Result detallesJugador(String nombre) {
		return ok(toJson(JugadoresHome.getJugador(nombre)));
	}

	// GET /generar-equipos
	public static Result generarEquipos() {
		return ok(generar_equipos.render());
	}

	// GET /generar-equipos-opciones
	public static Result generarEquiposOpciones() {
		Partido partido = PartidosHome.crearPartido();
		partido.setConfiguracion(configuracion);
		partido.aplicarConfiguracion();
		return ok(toJson(partido));
	}

	// GET /criterios-ordenamiento
	public static Result obtenerCriteriosOrdenamiento() {
		return ok(toJson(CriteriosOrdenamientoHome.getOpciones()));
	}
	
	// GET /criterios-armado
	public static Result obtenerCriteriosArmado() {
		return ok(toJson(CriteriosArmadoHome.getOpciones()));
	}

	// POST /criterios-ordenamiento
	public static Result setCriterioOrdenamiento() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("No se recibio ningun Json");
		} else {
			switch (json.findPath("ordenador").asText()) {
			case "Handicap":
				configuracion.setOrdenadorEquipos(new Handicap());
				break;
			case "Promedio del ultimo partido":
				configuracion.setOrdenadorEquipos(new PromedioUltimoPartido(null));
				break;
			case "Promedio de las ultimas calificaciones":
				configuracion.setOrdenadorEquipos(new PromedioUltimasCalificaciones(0));
				break;
			default:
				break;
			}
			return ok(json);
		}
	}
	
	// POST /criterios-armado
	public static Result setCriterioArmado() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("No se recibio ningun Json");
		} else {
			switch (json.findPath("armador").asText()) {
			case "Posiciones pares e impares":
				configuracion.setArmadorEquipos(new ParesImpares());
				break;
			case "Posiciones preestablecidas":
				configuracion.setArmadorEquipos(new PosicionesDadas());
				break;
			default:
				break;
			}
			return ok(json);
		}
	}
	
	// POST /configuracion
	public static Result setConfiguracion() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("No se recibio ningun Json");
		} else {
			switch (json.findPath("ordenador").asText()) {
			case "Handicap":
				configuracion.setOrdenadorEquipos(new Handicap());
				break;
			case "Promedio del ultimo partido":
				configuracion.setOrdenadorEquipos(new PromedioUltimoPartido(null));
				break;
			case "Promedio de las ultimas calificaciones":
				configuracion.setOrdenadorEquipos(new PromedioUltimasCalificaciones(0));
				break;
			default:
				break;
			}
			switch (json.findPath("armador").asText()) {
			case "Posiciones pares e impares":
				configuracion.setArmadorEquipos(new ParesImpares());
				break;
			case "Posiciones preestablecidas":
				configuracion.setArmadorEquipos(new PosicionesDadas());
				break;
			default:
				break;
			}
			return ok(json);
		}
	}
	
	// POST /confirmar-partido
	public static Result confirmarPartido() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("No se recibio ningun Json");
		} else {
//			Partido partido = fromJson(json, Partido.class);
//			partido.confirmarPartido();
			return ok(json);
		}
	}

	// GET /detalle-jugador
	public static Result showJugadorView() {
		return ok(detalle_jugador.render());
	}

	// GET /listar-jugadores
	public static Result showJugadoresView() {
		return ok(listar_jugadores.render());
	}

	// GET /busqueda-jugadores
	public static Result showBusquedaJugadoresView() {
		return ok(busqueda_jugadores.render());
	}
}