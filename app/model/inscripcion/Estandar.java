package model.inscripcion;

import model.jugador.Jugador;
import model.partido.Partido;

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