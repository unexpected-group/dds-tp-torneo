package model.ordenador;

import java.util.Collections;
import java.util.List;

import model.jugador.Jugador;

public abstract class OrdenadorEquipos {
	
	public void ordenarJugadores(List<Jugador> jugadores) {
		Collections.sort(jugadores,
				(jugador1, jugador2) -> valoracion(jugador1).compareTo(valoracion(jugador2)));
	}

	public abstract Double valoracion(Jugador jugador);
}