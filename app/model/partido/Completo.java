package model.partido;

import model.inscripcion.Inscripcion;

public class Completo implements Estado {

	@Override
	public void agregarInscripcion(Inscripcion inscripcion, Partido partido) {
	}

	@Override
	public void quitarInscripcion(Inscripcion inscripcion, Partido partido) {
		partido.getInscripciones().remove(inscripcion);
		partido.setEstado(new Pendiente());
	}
}