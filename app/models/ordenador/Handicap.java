package models.ordenador;

import javax.persistence.Entity;

import models.jugador.Jugador;

@Entity
public class Handicap extends OrdenadorEquipos {

	@Override
	public Double valoracion(Jugador jugador) {
		//return (double) jugador.getHandicap();
		return 5D;
	}
}
