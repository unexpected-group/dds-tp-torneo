package model.propuesta;

import java.time.LocalDate;

import model.jugador.Jugador;

public class Propuesta {
	
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
}