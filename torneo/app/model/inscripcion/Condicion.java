package model.inscripcion;

import model.partido.Partido;

public interface Condicion {

	public boolean evaluarCondicion(Partido partido);
}
