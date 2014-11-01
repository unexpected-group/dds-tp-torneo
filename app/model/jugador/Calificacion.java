package model.jugador;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.partido.Partido;
import play.db.ebean.Model;

@Entity
@Table(name="Calificaciones")
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
	
	public static Finder<Long, Calificacion> find =
			new Finder<Long, Calificacion>(Long.class, Calificacion.class);
}