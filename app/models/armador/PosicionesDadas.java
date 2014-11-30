package models.armador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.jugador.Jugador;

@Entity
@DiscriminatorValue("PD")
public class PosicionesDadas extends ArmadorEquipos {

	@Override
	public void armarEquipos(List<Jugador> jugadores) {
		List<Jugador> local = new ArrayList<Jugador>();
		List<Jugador> visitante = new ArrayList<Jugador>();
		local.add(jugadores.get(0));
		local.add(jugadores.get(3));
		local.add(jugadores.get(4));
		local.add(jugadores.get(7));
		local.add(jugadores.get(8));
		visitante.add(jugadores.get(1));
		visitante.add(jugadores.get(2));
		visitante.add(jugadores.get(5));
		visitante.add(jugadores.get(6));
		visitante.add(jugadores.get(9));
		jugadores.clear();
		jugadores.addAll(local);
		jugadores.addAll(visitante);
	}
}