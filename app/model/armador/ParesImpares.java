package model.armador;

import java.util.ArrayList;
import java.util.List;

import model.jugador.Jugador;

public class ParesImpares implements ArmadorEquipos {

	@Override
	public void armarEquipos(List<Jugador> jugadores) {
		List<Jugador> local = new ArrayList<Jugador>();
		List<Jugador> visitante = new ArrayList<Jugador>();
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				local.add(jugadores.get(i));
			else
				visitante.add(jugadores.get(i));
		}
		jugadores.clear();
		jugadores.addAll(local);
		jugadores.addAll(visitante);
	}
}