package model.jugador;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import model.partido.Partido;

@Entity
public class Calificacion extends Model {

	@Id
	private long id;
	
	private double puntaje;
	private String descripcion;
	private Jugador calificador;
	private Partido partido;

	public Calificacion(double puntaje, String descripcion, Partido partido) {
		this.puntaje = puntaje;
		this.descripcion = descripcion;
		this.partido = partido;
	}
	
	public Calificacion(double puntaje) {
		this(puntaje, null, null);
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