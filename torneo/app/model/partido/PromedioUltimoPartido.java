package model.partido;

import model.jugador.Jugador;

public class PromedioUltimoPartido extends OrdenadorEquipos {

	private Partido partido;

	@Override
	public Double valoracion(Jugador jugador) {
		return jugador.promedioCalificacionesPartido(partido);
	}
}
