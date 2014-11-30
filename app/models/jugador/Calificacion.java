package models.jugador;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import models.partido.Partido;
import play.db.ebean.Model;

@Entity @Table(name = "calificaciones")
public class Calificacion extends Model {
	
	@Id @GeneratedValue
	private long id;
	
	private double puntaje;
	private String descripcion;
	@OneToOne
	private Jugador calificador;
	@OneToOne
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
	
	public Partido getPartido() {
		return partido;
	}

	public void setCalificador(Jugador jugador) {
		this.calificador = jugador;
	}
	
	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public static Finder<Long, Calificacion> getFind() {
		return find;
	}

	public static void setFind(Finder<Long, Calificacion> find) {
		Calificacion.find = find;
	}

	public static Finder<Long, Calificacion> find =
			new Finder<Long, Calificacion>(Long.class, Calificacion.class);
}