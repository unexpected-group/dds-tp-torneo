package model.inscripcion;

import model.jugador.Jugador;
import model.jugador.Observer;
import model.partido.Partido;

public abstract class Inscripcion {
	
	private Jugador jugador;

	public Inscripcion(Jugador jugador) {
		this.jugador = jugador;
	}

	public abstract boolean desplazoJugador(Partido partido);

	public abstract Prioridad getPrioridad();

	public boolean noVerificaLaCondicion(Partido partido) {
		return false;
	}

	public boolean puedeInscribirse(Partido partido) {
		return true;
	}

	public boolean tienePrioridad(Prioridad prioridad) {
		return getPrioridad() == (prioridad);
	}

	public boolean esDelJugador(Jugador jugador) {
		return this.jugador == jugador;
	}

	public void notificar(Observer observer) {
		observer.notificarNuevaInscripcion(jugador);
	}

	public Jugador getJugador() {
		return jugador;
	}
}