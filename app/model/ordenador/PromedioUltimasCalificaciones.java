package model.ordenador;

import model.jugador.Jugador;

public class PromedioUltimasCalificaciones extends OrdenadorEquipos {

	private int cantidad;
	
	public PromedioUltimasCalificaciones(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public Double valoracion(Jugador jugador) {
		return jugador.promedioUltimasCalificaciones(cantidad);
	}
}