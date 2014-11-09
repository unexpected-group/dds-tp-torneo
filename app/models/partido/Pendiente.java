package models.partido;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.inscripcion.Inscripcion;

@Entity
@DiscriminatorValue("P")
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