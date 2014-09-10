package model.homes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.inscripcion.Estandar;
import model.inscripcion.Inscripcion;
import model.jugador.Jugador;
import model.partido.Partido;

public class PartidosHome {

	private static Partido partido;

	public static Partido getPartido() {
		partido = new Partido(LocalDate.now(), "MASCHWITZ");
		List<Jugador> jugadores = JugadoresHome.getJugadores();
		List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		jugadores.forEach(jug -> inscripciones.add(new Estandar(jug)));
		partido.setInscripciones(inscripciones);
		return partido;
	}
}