package models.all;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Completo extends Estado {

	@Override
	public void agregarInscripcion(Inscripcion inscripcion, Partido partido) {
		// nada
	}

	@Override
	public void quitarInscripcion(Inscripcion inscripcion, Partido partido) {
		partido.getInscripciones().remove(inscripcion);
		partido.setEstado(new Pendiente());
	}
}