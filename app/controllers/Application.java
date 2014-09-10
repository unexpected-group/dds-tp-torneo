package controllers;

import static play.libs.Json.toJson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.armador.ParesImpares;
import model.armador.PosicionesDadas;
import model.homes.CriteriosArmadoHome;
import model.homes.CriteriosOrdenamientoHome;
import model.homes.JugadoresHome;
import model.homes.PartidosHome;
import model.inscripcion.Estandar;
import model.inscripcion.Inscripcion;
import model.jugador.Jugador;
import model.ordenador.Handicap;
import model.ordenador.PromedioUltimasCalificaciones;
import model.ordenador.PromedioUltimoPartido;
import model.partido.Partido;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.equipos;

public class Application extends Controller {

	private Partido partido = PartidosHome.getPartido();

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
		partido.generarEquipos();
		return ok(toJson(partido.jugadoresPorEquipos()));
	}
	
	public static Result obtenerCriteriosOrdenamiento() {
		return ok(toJson(CriteriosOrdenamientoHome.getOpciones()));
	}

	public static Result setCriterioOrdenamiento(String id) {
		switch (id) {
		case "Handicap":
			partido.setOrdenadorEquipos(new Handicap());
			break;
		case "Promedio del ultimo partido":
			partido.setOrdenadorEquipos(new PromedioUltimoPartido(null));
			break;
		case "Promedio de las ultimas calificaciones":
			partido.setOrdenadorEquipos(new PromedioUltimasCalificaciones(0));
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
			partido.setArmadorEquipos(new ParesImpares());
			break;
		case "Posiciones preestablecidas":
			partido.setArmadorEquipos(new PosicionesDadas());
			break;
		}
		return ok();
	}
}