package models.partido;

import javax.persistence.Entity;

import models.inscripcion.Inscripcion;

@Entity
public class Completo extends Estado {

	@Override
	public void agregarInscripcion(Inscripcion inscripcion, Partido partido) {
	}

	@Override
	public void quitarInscripcion(Inscripcion inscripcion, Partido partido) {
		partido.getInscripciones().remove(inscripcion);
		partido.setEstado(new Pendiente());
	}
}