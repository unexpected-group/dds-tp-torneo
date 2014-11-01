package model.propuesta;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import model.jugador.Jugador;

@Entity
public class Propuesta extends Model {
	
	@Id
	private long id;

	private Jugador jugadorPropuesto;
	private Estado estado;
	private LocalDate fechaFormulacion;
	private LocalDate fechaRechazo;
	private String motivoRechazo;

	public Propuesta(Jugador amigo) {
		this.jugadorPropuesto = amigo;
		this.estado = Estado.PENDIENTE;
		this.fechaFormulacion = LocalDate.now();
	}

	public void aceptarPropuesta() {
		this.estado = Estado.ACEPTADA;
	}

	public void rechazarPropuesta(String motivo) {
		this.fechaRechazo = LocalDate.now();
		this.motivoRechazo = motivo;
		this.estado = Estado.RECHAZADA;
	}

	public Jugador getJugadorPropuesto() {
		return jugadorPropuesto;
	}

	public LocalDate getFecha() {
		return fechaFormulacion;
	}

	public LocalDate getFechaRechazo() {
		return fechaRechazo;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public boolean isAceptada() {
		return (estado.equals(Estado.ACEPTADA)) ? true : false;
	}

	public boolean isPendiente() {
		return (estado.equals(Estado.PENDIENTE)) ? true : false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}