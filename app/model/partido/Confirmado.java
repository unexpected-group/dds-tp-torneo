package model.partido;

import model.inscripcion.Inscripcion;

public class Confirmado implements Estado {

	@Override
	public void agregarInscripcion(Inscripcion inscripcion, Partido partido) {
	}

	@Override
	public void quitarInscripcion(Inscripcion inscripcion, Partido partido) {
		partido.getInscripciones().remove(inscripcion);
		partido.getObservadores().forEach(observador -> observador.notificarBaja());
		partido.setEstado(new Pendiente());
	}
}