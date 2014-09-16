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

	public static Partido crearPartido() {
		Partido partido = new Partido(LocalDate.now(), "MASCHWITZ");
		List<Jugador> jugadores = JugadoresHome.getJugadores();
		List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		jugadores.forEach(jug -> inscripciones.add(new Estandar(jug)));
		partido.setInscripciones(inscripciones);
		return partido;
	}

	public static void agregarPartido(Partido partido) {
		partidos.add(partido);
	}
	
	public static List<Partido> getPartidos() {
		return partidos;
	}
}