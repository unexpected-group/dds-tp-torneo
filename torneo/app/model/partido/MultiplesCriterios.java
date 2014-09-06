package model.partido;

import java.util.List;

import model.jugador.Jugador;

public class MultiplesCriterios extends OrdenadorEquipos {

	private List<OrdenadorEquipos> criterios;

	@Override
	public Double valoracion(Jugador jugador) {
		return criterios.stream()
				.mapToDouble(criterio -> criterio.valoracion(jugador))
				.average().getAsDouble();
	}
}