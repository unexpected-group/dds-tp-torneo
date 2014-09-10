package model.ordenador;

import model.jugador.Jugador;
import model.partido.Partido;

public class PromedioUltimoPartido extends OrdenadorEquipos {

	private Partido partido;

	public PromedioUltimoPartido(Partido partido) {
		this.partido = partido;
	}

	@Override
	public Double valoracion(Jugador jugador) {
		return jugador.promedioCalificacionesPartido(partido);
	}
}
