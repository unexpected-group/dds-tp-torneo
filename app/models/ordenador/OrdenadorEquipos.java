package models.ordenador;

import java.util.Collections;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import play.db.ebean.Model;
import models.jugador.Jugador;

@Entity @Table(name = "ordenadores")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class OrdenadorEquipos extends Model {
	
	@Id @GeneratedValue
	private long id;
	
	public abstract Double valoracion(Jugador jugador);
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void ordenarJugadores(List<Jugador> jugadores) {
		Collections.sort(jugadores,
				(jugador1, jugador2) -> valoracion(jugador1).compareTo(valoracion(jugador2)));
	}
}