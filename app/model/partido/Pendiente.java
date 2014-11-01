package model.partido;

import model.inscripcion.Inscripcion;

public class Pendiente implements Estado {

	@Override
	public void agregarInscripcion(Inscripcion inscripcion, Partido partido) {
		partido.getInscripciones().add(inscripcion);
		if (!partido.hayCupos()) {
			partido.setEstado(new Completo());
		}
	}

	@Override
	public void quitarInscripcion(Inscripcion inscripcion, Partido partido) {
		partido.getInscripciones().remove(inscripcion);
	}
}