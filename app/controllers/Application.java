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
import model.partido.Partido;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.equipos;
import views.html.jugador;
import views.html.index;

public class Application extends Controller {

	private static OrdenadorEquipos ordenador;
	private static ArmadorEquipos armador;

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
		return ok(equipos.render());
	}

	public static Result generarEquiposOpciones() {
		Partido partido = PartidosHome.getPartido();
		partido.setOrdenadorEquipos(ordenador);
		partido.setArmadorEquipos(armador);
		partido.generarEquipos();
		return ok(toJson(partido.jugadoresPorEquipos()));
	}
	
	public static Result obtenerCriteriosOrdenamiento() {
		return ok(toJson(CriteriosOrdenamientoHome.getOpciones()));
	}

	public static Result setCriterioOrdenamiento(String id) {
		switch (id) {
		case "Handicap":
			ordenador = new Handicap();
			break;
		case "Promedio del ultimo partido":
			ordenador = new PromedioUltimoPartido(null);
			break;
		case "Promedio de las ultimas calificaciones":
			ordenador = new PromedioUltimasCalificaciones(0);
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

	public static Result showJugadorView(){
		return ok(jugador.render());
	}
}