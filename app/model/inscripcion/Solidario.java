package model.inscripcion;

import model.jugador.Jugador;
import model.partido.Partido;

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