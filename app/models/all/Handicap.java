package models.all;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.all.Jugador;

@Entity
@DiscriminatorValue("H")
public class Handicap extends OrdenadorEquipos {

	@Override
	public Double valoracion(Jugador jugador) {
		return (double) jugador.getHandicap();
	}
}
