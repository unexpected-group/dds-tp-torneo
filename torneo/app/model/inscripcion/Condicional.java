package model.inscripcion;

import model.jugador.Jugador;
import model.partido.Partido;

public class Condicional extends Inscripcion {

	private Condicion condicion;

	public Condicional(Jugador jugador, Condicion condicion) {
		super(jugador);
		this.condicion = condicion;
	}

	@Override
	public boolean desplazoJugador(Partido partido) {
		return false;
	}

	@Override
	public boolean noVerificaLaCondicion(Partido partido) {
		return !condicion.evaluarCondicion(partido);
	}

	@Override
	public boolean puedeInscribirse(Partido partido) {
		return condicion.evaluarCondicion(partido);
	}

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	@Override
	public Prioridad getPrioridad() {
		return Prioridad.CONDICIONAL;
	}
}