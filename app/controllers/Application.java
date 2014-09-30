package controllers;

import static play.libs.Json.toJson;
import model.armador.ArmadorEquipos;
import model.armador.ParesImpares;
import model.armador.PosicionesDadas;
import model.homes.CriteriosArmadoHome;
import model.homes.CriteriosOrdenamientoHome;
import model.homes.JugadoresHome;
import model.homes.PartidosHome;
import model.ordenador.Handicap;
import model.ordenador.OrdenadorEquipos;
import model.ordenador.PromedioUltimasCalificaciones;
import model.ordenador.PromedioUltimoPartido;
import model.partido.Configuracion;
import model.partido.Partido;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.busqueda_jugadores;
import views.html.generar_equipos;
import views.html.index;
import views.html.jugador;
import views.html.listar_jugadores;

import com.fasterxml.jackson.databind.JsonNode;

public class Application extends Controller {

	// TODO: Eliminar el acoplamiento con los strings
	// TODO: Eliminar el state en el controller

	private static OrdenadorEquipos ordenador;
	private static ArmadorEquipos armador;
	private static Partido partidoConfirmar;

	// GET /
	public static Result index() {
		return ok(index.render("Torneo de Futbol 5"));
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
		partido.setConfiguracion(new Configuracion(ordenador, armador));
		partido.aplicarConfiguracion();
		partidoConfirmar = partido;
		return ok(toJson(partido.getJugadoresPartido()));
	}

	// GET /criterios-ordenamiento
	public static Result obtenerCriteriosOrdenamiento() {
		return ok(toJson(CriteriosOrdenamientoHome.getOpciones()));
	}

	// GET /criterios-ordenamiento/:id
	public static Result setCriterioOrdenamiento(String id) {
		switch (id) {
		case "Handicap":
			ordenador = new Handicap();
			break;
		case "Promedio del ultimo partido":
			ordenador = new PromedioUltimoPartido(null); // hardcodeado
			break;
		case "Promedio de las ultimas calificaciones":
			ordenador = new PromedioUltimasCalificaciones(0); // hardcodeado
			break;
		default:
			break;
		}
		return ok();
	}

	// GET /criterios-armado
	public static Result obtenerCriteriosArmado() {
		return ok(toJson(CriteriosArmadoHome.getOpciones()));
	}

	// GET /criterios-armado/:id
	public static Result setCriterioArmado(String id) {
		switch (id) {
		case "Posiciones pares e impares":
			armador = new ParesImpares();
			break;
		case "Posiciones preestablecidas":
			armador = new PosicionesDadas();
			break;
		default:
			break;
		}
		return ok();
	}

	// POST /confirmar-partido
	public static Result confirmarPartido() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("No se recibio ningun Json");
		} else {
			partidoConfirmar.confirmarPartido();
			return ok(json);
		}
	}

	// GET /detalle-jugador
	public static Result showJugadorView() {
		return ok(jugador.render());
	}

	// GET /listar-jugadores
	public static Result showJugadoresView() {
		return ok(listar_jugadores.render());
	}

	// GET /busqueda-jugadores
	public static Result showBusquedaJugadoresView() {
		return ok(busqueda_jugadores.render());
	}

	// POST /test
	public static Result hello() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("No se recibio ningun Json");
		} else {
			String name = json.findPath("nombre").textValue();
			if (name == null) {
				return badRequest("Parametro faltante [nombre]");
			} else {
				return redirect(routes.Application.index());
			}
		}
	}
}