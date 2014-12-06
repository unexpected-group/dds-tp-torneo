package models.all;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity @Table(name = "estados")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Estado extends Model {
	
	@Id @GeneratedValue
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