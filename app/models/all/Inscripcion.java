package models.all;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity @Table(name = "inscripciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Inscripcion extends Model {
	
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
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
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}