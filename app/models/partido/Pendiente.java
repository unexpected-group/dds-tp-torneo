package models.partido;

import javax.persistence.Entity;

import models.inscripcion.Inscripcion;

@Entity
public class Pendiente extends Estado {

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