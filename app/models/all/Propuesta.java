package models.all;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity @Table(name = "propuestas")
public class Propuesta extends Model {
	
	@Id @GeneratedValue
	private long id;
	
	@OneToOne
	private Jugador jugadorPropuesto;
	@Enumerated(EnumType.STRING)
	private EstadoPropuesta estado;
	private Date fechaFormulacion;
	private Date fechaRechazo;
	private String motivoRechazo;
	
	public Propuesta(Jugador amigo) {
		this.jugadorPropuesto = amigo;
		this.estado = EstadoPropuesta.PENDIENTE;
		this.fechaFormulacion = new Date();
	}

	public void aceptarPropuesta() {
		this.estado = EstadoPropuesta.ACEPTADA;
	}

	public void rechazarPropuesta(String motivo) {
		this.fechaRechazo = new Date();
		this.motivoRechazo = motivo;
		this.estado = EstadoPropuesta.RECHAZADA;
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

	public EstadoPropuesta getEstado() {
		return estado;
	}

	public void setEstado(EstadoPropuesta estado) {
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
		return (estado == EstadoPropuesta.ACEPTADA) ? true : false;
	}

	public boolean isPendiente() {
		return (estado == EstadoPropuesta.PENDIENTE) ? true : false;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}