package models.homes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import models.jugador.Jugador;
import models.propuesta.Propuesta;

public class PropuestasHome {

	private List<Propuesta> propuestas;

	public PropuestasHome() {
		this.propuestas = new ArrayList<>();
	}

	public void agregarPropuestaAmigo(Jugador amigo) {
		propuestas.add(new Propuesta(amigo));
	}

	public Propuesta propuestaDelJugador(Jugador jugador) {
		return propuestas.stream()
				.filter(p -> p.getJugadorPropuesto() == jugador)
				.findFirst().get();
	}

	public void registrarRechazo(Propuesta propuesta, String motivo) {
		propuesta.rechazarPropuesta(motivo);
		this.propuestas.remove(propuesta);
	}

	public void registrarAceptacion(Propuesta propuesta) {
		propuesta.aceptarPropuesta();
	}

	public long cantidadPropuestasAceptadas() {
		return aceptadas().count();
	}

	private Stream<Propuesta> aceptadas() {
		return propuestas.stream().filter(p -> p.isAceptada());
	}

	public long cantidadPropuestasPendientes() {
		return pendientes().count();
	}

	public Stream<Propuesta> pendientes() {
		return propuestas.stream().filter(p -> p.isPendiente());
	}

	public List<Propuesta> getPropuestas() {
		return propuestas;
	}
}