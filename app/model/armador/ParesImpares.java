package model.armador;

import java.util.List;

import model.jugador.Jugador;

public class ParesImpares implements ArmadorEquipos {

	@Override
	public void armarEquipos(List<Jugador> jugadores, List<Jugador> equipoLocal,
			List<Jugador> equipoVisitante) {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				equipoLocal.add(jugadores.get(i));
			else
				equipoVisitante.add(jugadores.get(i));
		}
	}
}