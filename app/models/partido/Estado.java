package models.partido;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import models.inscripcion.Inscripcion;

@Entity
public abstract class Estado extends Model{
	
	@Id
	private long id;
	
	public abstract void agregarInscripcion(Inscripcion inscripcion, Partido partido);

	public abstract void quitarInscripcion(Inscripcion inscripcion, Partido partido);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}