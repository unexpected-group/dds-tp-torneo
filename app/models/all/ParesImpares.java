package models.all;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PI")
public class ParesImpares extends ArmadorEquipos {

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