package models.armador;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import models.jugador.Jugador;
import play.db.ebean.Model;

@Entity
public abstract class ArmadorEquipos extends Model{

	@Id
	private long id;
	
	public abstract void armarEquipos(List<Jugador> jugadores);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}