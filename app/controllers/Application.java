package controllers;

import static play.libs.Json.toJson;
import models.armador.ParesImpares;
import models.armador.PosicionesDadas;
import models.homes.ArmadoresHome;
import models.homes.JugadoresHome;
import models.homes.OrdenadoresHome;
import models.homes.PartidosHome;
import models.ordenador.Handicap;
import models.ordenador.PromedioUltimasCalificaciones;
import models.ordenador.PromedioUltimoPartido;
import models.partido.Configuracion;
import models.partido.Partido;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.busqueda_jugadores;
import views.html.detalle_jugador;
import views.html.generar_equipos;
import views.html.index;
import views.html.listar_jugadores;

import com.fasterxml.jackson.databind.JsonNode;

public class Application extends Controller {

	public static Result showIndex() {
		return ok(index.render("Futbol 5"));
	}

	public static Result obtenerJugadores() {
		return ok(toJson(JugadoresHome.getJugadores()));
	}

	public static Result detallesJugador(String nombre) {
		return ok(toJson(JugadoresHome.getJugador(nombre)));
	}

	public static Result showGenerarEquipos() {
		return ok(generar_equipos.render());
	}

	public static Result obtenerOrdenadores() {
		return ok(toJson(OrdenadoresHome.getOpciones()));
	}

	public static Result obtenerArmadores() {
		return ok(toJson(ArmadoresHome.getOpciones()));
	}

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
	
	public static Result obtenerEquipos() {
		Partido partido = PartidosHome.getPartidoActual();
		partido.configurar();
		PartidosHome.setPartidoActual(partido);
		return ok(toJson(partido));
	}

	public static Result confirmarPartido() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("No se recibio ningun Json");
		} else {
			Partido partido = PartidosHome.getPartidoActual();
			partido.confirmarPartido();
			return ok(json);
		}
	}

	public static Result showJugadorView() {
		return ok(detalle_jugador.render());
	}

	public static Result showJugadoresView() {
		return ok(listar_jugadores.render());
	}
	
	public static Result showBusquedaJugadoresView() {
		return ok(busqueda_jugadores.render());
	}
	
	public static Result getArmadores() {
		return ok(toJson(ArmadoresHome.getOpciones()));
	}
}