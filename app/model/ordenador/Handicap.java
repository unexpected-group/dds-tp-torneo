package model.ordenador;

import model.jugador.Jugador;

public class Handicap extends OrdenadorEquipos {

	@Override
	public Double valoracion(Jugador jugador) {
		return (double) jugador.getHandicap();
	}
}
