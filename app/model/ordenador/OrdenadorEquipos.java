package model.ordenador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import model.jugador.Jugador;
import play.db.ebean.Model;

@Entity
public abstract class OrdenadorEquipos extends Model {
	
	@Id
	private long id;

	public void ordenarJugadores(List<Jugador> jugadores) {
		Collections.sort(jugadores,
				(jugador1, jugador2) -> valoracion(jugador1).compareTo(valoracion(jugador2)));
	}

	public abstract Double valoracion(Jugador jugador);
}