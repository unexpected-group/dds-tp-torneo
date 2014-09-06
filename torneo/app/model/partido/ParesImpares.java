package model.partido;

import java.util.List;

import model.jugador.Jugador;

public class ParesImpares implements SeparadorEquipos {

	@Override
	public void generarEquipos(List<Jugador> jugadores, List<Jugador> equipoImpares,
			List<Jugador> equipoPares) {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				equipoImpares.add(jugadores.get(i));
			else
				equipoPares.add(jugadores.get(i));
		}
	}
}