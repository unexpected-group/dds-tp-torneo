package model.inscripcion;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import model.jugador.Jugador;
import model.jugador.Observer;
import model.partido.Partido;

@Entity
public abstract class Inscripcion extends Model {
	
	@Id
	private long id;

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
		return getPrioridad().equals(prioridad);
	}

	public boolean esDelJugador(Jugador jugador) {
		return this.jugador.equals(jugador);
	}

	public void notificar(Observer observer) {
		observer.notificarNuevaInscripcion(jugador);
	}

	public Jugador getJugador() {
		return jugador;
	}
}