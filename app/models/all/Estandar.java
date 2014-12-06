package models.all;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Estandar extends Inscripcion {

	public Estandar(Jugador jugador) {
		super(jugador);
	}

	@Override
	public boolean desplazoJugador(Partido partido) {
		return (partido.desplazarJugadorCondicional() || partido.desplazarJugadorSolidario());
	}

	@Override
	public Prioridad getPrioridad() {
		return Prioridad.ESTANDAR;
	}
}