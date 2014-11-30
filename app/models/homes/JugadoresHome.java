package models.homes;

import java.util.List;
import java.util.Optional;

import models.jugador.Jugador;

public class JugadoresHome {

	public static List<Jugador> getJugadores() {
		return Jugador.finder.all();
	}

	public static Jugador getJugador(String nombre) {
		Optional<Jugador> jugador = getJugadores()
				.stream()
				.filter(j -> mismoNombre(j.getNombre(), nombre))
				.findFirst();
		
		if (jugador.isPresent())
			return jugador.get();
		else
			return null;
	}
	
	private static boolean mismoNombre(String a, String b) {
		return a.equalsIgnoreCase(b);
	}
}