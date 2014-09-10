package model.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import model.jugador.Jugador;
import model.jugador.Observer;
import model.ordenador.OrdenadorEquipos;
import model.propuesta.Propuesta;

public class Sistema implements Observer {

	private List<Propuesta> propuestas;

	public Sistema(OrdenadorEquipos organizadorEquipos) {
		this.propuestas = new ArrayList<>();
	}

	@Override
	public void notificarNuevaInscripcion(Jugador jugador) {
	}

	@Override
	public void notificarBaja() {
	}

	public void agregarPropuestaAmigo(Jugador amigo) {
		propuestas.add(new Propuesta(amigo));
	}

	public Propuesta propuestaDelJugador(Jugador jugador) {
		return propuestas.stream()
				.filter(p -> p.getJugadorPropuesto().equals(jugador))
				.findFirst().get();
	}

	public void registrarRechazo(Propuesta propuesta, String motivo) {
		propuesta.rechazarPropuesta(motivo);
		this.propuestas.remove(propuesta);
		// la propuesta misma registra el rechazo
	}

	public void registrarAceptacion(Propuesta propuesta) {
		propuesta.aceptarPropuesta();
		// dar de alta en nadie sabe donde
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