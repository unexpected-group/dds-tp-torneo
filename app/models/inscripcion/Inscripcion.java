package models.inscripcion;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
import models.jugador.Jugador;
import models.partido.Partido;

@Entity
public abstract class Inscripcion extends Model {
	
	@Id
	private long id;
	
	@OneToOne
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

	public Jugador getJugador() {
		return jugador;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}