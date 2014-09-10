package model.ordenador;

import model.jugador.Jugador;

public class PromedioUltimasCalificaciones extends OrdenadorEquipos {

	private int cantidad;

	@Override
	public Double valoracion(Jugador jugador) {
		return jugador.promedioUltimasCalificaciones(cantidad);
	}
}