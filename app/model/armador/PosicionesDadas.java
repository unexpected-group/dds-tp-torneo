package model.armador;

import java.util.List;

import model.jugador.Jugador;

public class PosicionesDadas implements ArmadorEquipos {

	@Override
	public void armarEquipos(List<Jugador> jugadores, List<Jugador> equipoLocal, List<Jugador> equipoVisitante) {

		equipoLocal.add(jugadores.get(0));
		equipoLocal.add(jugadores.get(3));
		equipoLocal.add(jugadores.get(4));
		equipoLocal.add(jugadores.get(7));
		equipoLocal.add(jugadores.get(8));

		equipoVisitante.add(jugadores.get(1));
		equipoVisitante.add(jugadores.get(2));
		equipoVisitante.add(jugadores.get(5));
		equipoVisitante.add(jugadores.get(6));
		equipoVisitante.add(jugadores.get(9));
	}
}