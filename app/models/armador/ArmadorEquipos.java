package models.armador;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import models.jugador.Jugador;
import play.db.ebean.Model;

@Entity @Table(name = "armadores")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class ArmadorEquipos extends Model {

	@Id @GeneratedValue
	private long id;
	
	public abstract void armarEquipos(List<Jugador> jugadores);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}