package models.inscripcion;

import models.partido.Partido;

public interface Condicion {

	public boolean evaluarCondicion(Partido partido);
}
