package model.homes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.inscripcion.Estandar;
import model.inscripcion.Inscripcion;
import model.jugador.Jugador;
import model.partido.Partido;

public class PartidosHome {

	private static List<Partido> partidos = new ArrayList<>();
	private static Partido partidoActual;

	public static Partido crearPartidoFicticio() {
		Partido partido = new Partido(LocalDate.now(), "Maschwitz");
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