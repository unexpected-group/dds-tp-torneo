package model.partido;

import model.inscripcion.Inscripcion;

public class Pendiente implements Estado {

	@Override
	public void agregarInscripcion(Inscripcion inscripcion, Partido partido) {
		partido.getInscripciones().add(inscripcion);
		partido.getObservadores().add(inscripcion.getJugador());
		if (!partido.hayCupos()) {
			partido.setEstado(new Completo());
		}
		partido.getObservadores().forEach(observador -> inscripcion.notificar(observador));
	}

	@Override
	public void quitarInscripcion(Inscripcion inscripcion, Partido partido) {
		partido.getInscripciones().remove(inscripcion);
	}
}