package models.homes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.inscripcion.Estandar;
import models.inscripcion.Inscripcion;
import models.jugador.Jugador;
import models.partido.Partido;

public class PartidosHome {

	private static List<Partido> partidos = new ArrayList<>();
	private static Partido partidoActual;

	public static Partido crearPartidoFicticio() {
		Partido partido = new Partido(new Date(), "Maschwitz");
		List<Jugador> jugadores = JugadoresHome.getJugadores();
		List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		jugadores.forEach(j -> inscripciones.add(new Estandar(j)));
		partido.setInscripciones(inscripciones);
		return partido;
	}

	public static void agregarPartido(Partido partido) {
		partidos.add(partido);
	}
	
	public static List<Partido> getPartidos() {
		return partidos;
	}
	
	public static Partido getPartidoActual() {
		return partidoActual;
	}
	
	public static void setPartidoActual(Partido partidoActual) {
		PartidosHome.partidoActual = partidoActual;
	}
}