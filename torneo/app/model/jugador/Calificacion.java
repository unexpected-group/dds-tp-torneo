package model.jugador;

import model.partido.Partido;

public class Calificacion {

	private double puntaje;
	private String descripcion;
	private Jugador calificador;
	private Partido partido;

	public Calificacion(double puntaje, String descripcion, Partido partido) {
		super();
		this.puntaje = puntaje;
		this.descripcion = descripcion;
		this.partido = partido;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Jugador getCalificador() {
		return calificador;
	}

	public void setCalificador(Jugador jugador) {
		this.calificador = jugador;
	}

	public Partido getPartido() {
		return partido;
	}
}