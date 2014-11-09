package models.propuesta;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.db.ebean.Model;
import models.jugador.Jugador;

@Entity @Table(name = "propuestas")
public class Propuesta extends Model {
	
	@Id @GeneratedValue
	private long id;
	
	@OneToOne
	private Jugador jugadorPropuesto;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	private Date fechaFormulacion;
	private Date fechaRechazo;
	private String motivoRechazo;
	
	public Propuesta(Jugador amigo) {
		this.jugadorPropuesto = amigo;
		this.estado = Estado.PENDIENTE;
		this.fechaFormulacion = new Date();
	}

	public void aceptarPropuesta() {
		this.estado = Estado.ACEPTADA;
	}

	public void rechazarPropuesta(String motivo) {
		this.fechaRechazo = new Date();
		this.motivoRechazo = motivo;
		this.estado = Estado.RECHAZADA;
	}

	public Jugador getJugadorPropuesto() {
		return jugadorPropuesto;
	}

	public Date getFecha() {
		return fechaFormulacion;
	}

	public Date getFechaRechazo() {
		return fechaRechazo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getFechaFormulacion() {
		return fechaFormulacion;
	}
	
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setFechaFormulacion(Date fechaFormulacion) {
		this.fechaFormulacion = fechaFormulacion;
	}

	public void setJugadorPropuesto(Jugador jugadorPropuesto) {
		this.jugadorPropuesto = jugadorPropuesto;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public boolean isAceptada() {
		return (estado == Estado.ACEPTADA) ? true : false;
	}

	public boolean isPendiente() {
		return (estado == Estado.PENDIENTE) ? true : false;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}