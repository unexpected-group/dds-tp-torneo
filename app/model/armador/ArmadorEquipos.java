package model.armador;

import java.util.List;

import model.jugador.Jugador;

public interface ArmadorEquipos {

	public void armarEquipos(List<Jugador> jugadores, List<Jugador> equipoLocal, List<Jugador> equipoVisitante);
}