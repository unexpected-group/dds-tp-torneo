package model.partido;

import java.util.List;

import model.jugador.Jugador;

public interface SeparadorEquipos {

	public void generarEquipos(List<Jugador> jugadores, List<Jugador> equipoA, List<Jugador> equipoB);
}