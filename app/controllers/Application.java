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

	// TODO: Eliminar el state en el controller
	private static OrdenadorEquipos ordenador;
	private static ArmadorEquipos armador;
	private static Partido partidoConfirmar;

	public static Result index() {
		return ok(index.render("Torneo de Futbol 5"));
	}

	public static Result obtenerJugadores() {
		return ok(toJson(JugadoresHome.getJugadores()));
	}

	public static Result detallesJugador(String nombre) {
		return ok(toJson(JugadoresHome.getJugador(nombre)));
	}

	public static Result generarEquipos() {
		return ok(generar_equipos.render());
	}

	public static Result generarEquiposOpciones() {
		Partido partido = PartidosHome.crearPartido();
		partido.setConfiguracion(new Configuracion(ordenador, armador));
		partido.generarEquipos();
		partidoConfirmar = partido;
		return ok(toJson(partido.jugadoresOrdenadosPorEquipos()));
	}

	public static Result obtenerCriteriosOrdenamiento() {
		return ok(toJson(CriteriosOrdenamientoHome.getOpciones()));
	}

	// TODO: Eliminar el acoplamiento con los strings
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

	public static Result obtenerCriteriosArmado() {
		return ok(toJson(CriteriosArmadoHome.getOpciones()));
	}

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

	public static Result confirmarPartido() {
		partidoConfirmar.confirmarPartido();
		return ok();
	}

	public static Result showJugadorView() {
		return ok(jugador.render());
	}

	public static Result showJugadoresView() {
		return ok(listar_jugadores.render());
	}

	public static Result showBusquedaJugadoresView() {
		return ok(busqueda_jugadores.render());
	}

	// POST /test
	public static Result hello() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("Expecting Json data");
		} else {
			String name = json.findPath("name").textValue();
			if (name == null) {
				return badRequest("Missing parameter [name]");
			} else {
				return ok("Hello " + name);
			}
		}
	}

}