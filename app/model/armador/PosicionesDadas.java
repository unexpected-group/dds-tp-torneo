package model.armador;

import java.util.List;

import model.jugador.Jugador;

public class PosicionesDadas implements ArmadorEquipos {

	@Override
	public void armarEquipos(List<Jugador> jugadores, List<Jugador> equipoA, List<Jugador> equipoB) {

		equipoA.add(jugadores.get(0));
		equipoA.add(jugadores.get(3));
		equipoA.add(jugadores.get(4));
		equipoA.add(jugadores.get(7));
		equipoA.add(jugadores.get(8));

		equipoB.add(jugadores.get(1));
		equipoB.add(jugadores.get(2));
		equipoB.add(jugadores.get(5));
		equipoB.add(jugadores.get(6));
		equipoB.add(jugadores.get(9));
	}
}