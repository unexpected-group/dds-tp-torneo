package models.all;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
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