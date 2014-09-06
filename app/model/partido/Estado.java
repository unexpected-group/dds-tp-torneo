package model.partido;

import model.inscripcion.Inscripcion;

public interface Estado {

	public void agregarInscripcion(Inscripcion inscripcion, Partido partido);

	public void quitarInscripcion(Inscripcion inscripcion, Partido partido);
}