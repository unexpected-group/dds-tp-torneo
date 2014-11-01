package controllers;

import static play.libs.Json.fromJson;
import static play.libs.Json.toJson;
import model.armador.ParesImpares;
import model.armador.PosicionesDadas;
import model.homes.ArmadoresHome;
import model.homes.JugadoresHome;
import model.homes.OrdenadoresHome;
import model.homes.PartidosHome;
import model.ordenador.Handicap;
import model.ordenador.PromedioUltimasCalificaciones;
import model.ordenador.PromedioUltimoPartido;
import model.partido.Configuracion;
import model.partido.Partido;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.busqueda_jugadores;
import views.html.detalle_jugador;
import views.html.generar_equipos;
import views.html.index;
import views.html.listar_jugadores;

import com.fasterxml.jackson.databind.JsonNode;

public class Application extends Controller {

	// GET /
	public static Result showIndex() {
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
	public static Result showGenerarEquipos() {
		return ok(generar_equipos.render());
	}

	// GET /ordenadores
	public static Result obtenerOrdenadores() {
		return ok(toJson(OrdenadoresHome.getOpciones()));
	}

	// GET /armadores
	public static Result obtenerArmadores() {
		return ok(toJson(ArmadoresHome.getOpciones()));
	}

	// POST /configuracion
	public static Result configurar() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("No se recibio ningun Json");
		} else {
			Partido partido = PartidosHome.crearPartidoFicticio();
			partido.setConfiguracion(new Configuracion(null, null));

			switch (json.findPath("ordenador").asText()) {
			case "Handicap":
				partido.getConfiguracion().setOrdenadorEquipos(new Handicap());
				break;
			case "Promedio del ultimo partido":
				partido.getConfiguracion().setOrdenadorEquipos(new PromedioUltimoPartido(null));
				break;
			case "Promedio de las ultimas calificaciones":
				partido.getConfiguracion()
						.setOrdenadorEquipos(new PromedioUltimasCalificaciones(0));
				break;
			default:
				break;
			}

			switch (json.findPath("armador").asText()) {
			case "Posiciones pares e impares":
				partido.getConfiguracion().setArmadorEquipos(new ParesImpares());
				break;
			case "Posiciones preestablecidas":
				partido.getConfiguracion().setArmadorEquipos(new PosicionesDadas());
				break;
			default:
				break;
			}

			PartidosHome.setPartidoActual(partido);
			return ok(json);
		}
	}
	
	// GET /partido
	public static Result obtenerEquipos() {
		Partido partido = PartidosHome.getPartidoActual();
		partido.configurar();
		return ok(toJson(partido));
	}

	// POST /confirmar-partido
	public static Result confirmarPartido() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("No se recibio ningun Json");
		} else {
			Partido partido = fromJson(json, Partido.class);
			partido.confirmarPartido();
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