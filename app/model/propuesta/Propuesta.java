package model.propuesta;

import java.util.Date;

import model.jugador.Jugador;

public class Propuesta {
	
	private Jugador jugadorPropuesto;
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
}