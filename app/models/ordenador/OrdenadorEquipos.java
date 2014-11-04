package models.ordenador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import models.jugador.Jugador;

@Entity
public abstract class OrdenadorEquipos extends Model{
	
	@Id
	private long id;
	
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

	public abstract Double valoracion(Jugador jugador);
}