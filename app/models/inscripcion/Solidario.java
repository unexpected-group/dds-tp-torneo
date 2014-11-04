package models.inscripcion;

import javax.persistence.Entity;

import models.jugador.Jugador;
import models.partido.Partido;

@Entity
public class Solidario extends Inscripcion {

	public Solidario(Jugador jugador) {
		super(jugador);
	}

	@Override
	public boolean desplazoJugador(Partido partido) {
		return partido.desplazarJugadorCondicional();
	}

	@Override
	public Prioridad getPrioridad() {
		return Prioridad.SOLIDARIO;
	}
}