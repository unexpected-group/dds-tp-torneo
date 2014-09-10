package controllers;

import static play.libs.Json.toJson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.armador.ParesImpares;
import model.armador.PosicionesDadas;
import model.homes.JugadoresHome;
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

	public static Result generarEquiposOpciones(String cod) {
		List<Jugador> jugadores = JugadoresHome.getJugadores();
		List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		for (Jugador jug : jugadores) {
			inscripciones.add(new Estandar(jug));
		}
		Partido partido = new Partido(LocalDate.now(), "Maschwitz");
		partido.setInscripciones(inscripciones);
		switch (cod) {
		case "11":
			partido.setOrdenadorEquipos(new Handicap());
			partido.setArmadorEquipos(new ParesImpares());
			break;
		case "12":
			partido.setOrdenadorEquipos(new Handicap());
			partido.setArmadorEquipos(new PosicionesDadas());
			break;
		case "21":
			partido.setOrdenadorEquipos(new PromedioUltimoPartido(null));
			partido.setArmadorEquipos(new ParesImpares());
			break;
		case "22":
			partido.setOrdenadorEquipos(new PromedioUltimoPartido(null));
			partido.setArmadorEquipos(new PosicionesDadas());
			break;
		case "31":
			partido.setOrdenadorEquipos(new PromedioUltimasCalificaciones(0));
			partido.setArmadorEquipos(new ParesImpares());
			break;
		case "32":
			partido.setOrdenadorEquipos(new PromedioUltimasCalificaciones(0));
			partido.setArmadorEquipos(new PosicionesDadas());
			break;
		}
		partido.generarEquipos();
		return ok(toJson(partido.jugadoresPorEquipos()));
	}
}