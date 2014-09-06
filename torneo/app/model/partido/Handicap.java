package model.partido;

import model.jugador.Jugador;

public class Handicap extends OrdenadorEquipos {

	@Override
	public Double valoracion(Jugador jugador) {
		return jugador.getHandicap();
	}
}
