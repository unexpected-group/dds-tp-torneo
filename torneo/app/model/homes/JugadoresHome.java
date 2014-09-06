package model.homes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.jugador.Jugador;

public class JugadoresHome {
	
	private static List<Jugador> jugadores = new ArrayList<Jugador>();

	public static List<Jugador> getJugadores() {
		jugadores.add(new Jugador("Juan Pablo Jacob", 21));
		jugadores.add(new Jugador("Manuel Gambino", 22));
		jugadores.add(new Jugador("Agustin Pina", 23));
		jugadores.add(new Jugador("Esteban Zignego", 24));
		jugadores.add(new Jugador("Franco Bulgarelli", 25));
		return jugadores;
	}
	
	public static Jugador getJugador(String nombre) {
		Optional<Jugador> jugador = jugadores.stream().
				filter(j -> j.getNombre().equalsIgnoreCase(nombre)).
				findFirst();
		if (jugador.isPresent())
			return jugador.get();
		else
			return null;
	}
}