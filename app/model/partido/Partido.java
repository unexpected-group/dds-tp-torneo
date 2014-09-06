package model.partido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import model.dominio.Sistema;
import model.excepciones.CuposCompletosException;
import model.excepciones.JugadorInscriptoException;
import model.excepciones.JugadorNoInscriptoException;
import model.excepciones.NoSeCumpleCondicionException;
import model.inscripcion.Inscripcion;
import model.inscripcion.Prioridad;
import model.jugador.Jugador;
import model.jugador.Observer;

public class Partido {

	private LocalDate fecha;
	private String lugar;
	private List<Inscripcion> inscripciones;
	private Estado estado;
	private List<Observer> observadores;
	private List<Jugador> equipoA;
	private List<Jugador> equipoB;
	private OrdenadorEquipos ordenadorEquipos;
	private SeparadorEquipos separadorEquipos;

	public Partido(LocalDate fecha, String lugar) {
		super();
		this.fecha = fecha;
		this.lugar = lugar;
		this.inscripciones = new ArrayList<>();
		this.observadores = new ArrayList<>();
		this.estado = new Pendiente();
		this.equipoA = new ArrayList<>();
		this.equipoB = new ArrayList<>();
	}

	public Partido(LocalDate fecha, String lugar, Sistema administrador) {
		super();
		this.fecha = fecha;
		this.lugar = lugar;
		this.inscripciones = new ArrayList<>();
		this.observadores = new ArrayList<>();
		this.observadores.add(administrador);
		this.estado = new Pendiente();
		this.equipoA = new ArrayList<>();
		this.equipoB = new ArrayList<>();
	}

	public Partido(LocalDate fecha, String lugar, List<Inscripcion> inscripciones,
			Sistema administrador) {
		super();
		this.fecha = fecha;
		this.lugar = lugar;
		this.inscripciones = inscripciones;
		this.observadores = new ArrayList<>();
		this.observadores.add(administrador);
		this.equipoA = new ArrayList<>();
		this.equipoB = new ArrayList<>();
		if (inscripciones.size() < 10)
			this.estado = new Pendiente();
		else
			this.estado = new Confirmado();
	}

	public Partido(LocalDate fecha, String lugar, List<Inscripcion> inscripciones) {
		this(fecha, lugar, inscripciones, new Sistema(null));
	}

	public List<Jugador> obtenerJugadores() {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		inscripciones.forEach(ins -> jugadores.add(ins.getJugador()));
		return jugadores;
	}

	public void generarEquipos() {
		List<Jugador> jugadores = obtenerJugadores();
		ordenadorEquipos.ordenarJugadores(jugadores);
		separadorEquipos.generarEquipos(jugadores, this.equipoA, this.equipoB);
	}

	public void inscribir(Inscripcion inscripcion) {
		if (hayCupos()) {
			if (inscripcion.puedeInscribirse(this))
				agregarInscripcion(inscripcion);
			else
				throw new NoSeCumpleCondicionException("NO SE CUMPLE LA CONDICION DEL JUGADOR");
		} else if (inscripcion.desplazoJugador(this))
			agregarInscripcion(inscripcion);
		else
			throw new CuposCompletosException("CUPOS COMPLETOS");
	}

	public boolean desplazarJugadorCondicional() {
		return desplazarJugador(inscripcion -> inscripcion.tienePrioridad(Prioridad.CONDICIONAL));
	}

	public boolean desplazarJugadorSolidario() {
		return desplazarJugador(inscripcion -> inscripcion.tienePrioridad(Prioridad.SOLIDARIO));
	}

	private boolean desplazarJugador(Predicate<Inscripcion> condicion) {
		Optional<Inscripcion> inscripcionParaSacar;
		inscripcionParaSacar = inscripciones.stream().filter(condicion).findFirst();
		if (inscripcionParaSacar.isPresent()) {
			estado.quitarInscripcion(inscripcionParaSacar.get(), this);
			return true;
		}
		return false;
	}

	private void agregarInscripcion(Inscripcion inscripcion) {
		if (inscripciones.stream().anyMatch(
				ins -> ins.getJugador().equals(inscripcion.getJugador()))) {
			throw new JugadorInscriptoException("JUGADOR YA INSCRIPTO");
		} else {
			estado.agregarInscripcion(inscripcion, this);
			verificarCondiciones();
		}
	}

	public Inscripcion buscarInscripcionDeJugador(Jugador jugador) {
		Optional<Inscripcion> inscripcionParaSacar;
		inscripcionParaSacar = inscripciones.stream()
				.filter(inscripcion -> inscripcion.esDelJugador(jugador)).findFirst();
		if (inscripcionParaSacar.isPresent())
			return inscripcionParaSacar.get();
		else
			throw new JugadorNoInscriptoException("EL JUGADOR NO ESTABA INSCRIPTO");
	}

	public void sacarJugador(Jugador jugador) {
		estado.quitarInscripcion(buscarInscripcionDeJugador(jugador), this);
	}

	private void verificarCondiciones() {
		inscripciones.removeIf(inscripcion -> inscripcion.noVerificaLaCondicion(this));
	}

	public boolean hayCupos() {
		return cantidadInscripciones() < 10;
	}

	public int cantidadInscripciones() {
		return inscripciones.size();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Observer> getObservadores() {
		return observadores;
	}

	public void setObservadores(List<Observer> observadores) {
		this.observadores = observadores;
	}

	public List<Jugador> getEquipoA() {
		return equipoA;
	}

	public List<Jugador> getEquipoB() {
		return equipoB;
	}

	public OrdenadorEquipos getOrganizadorEquipos() {
		return ordenadorEquipos;
	}

	public void setOrganizadorEquipos(OrdenadorEquipos organizadorEquipos) {
		this.ordenadorEquipos = organizadorEquipos;
	}

	public void setGeneradorEquipos(SeparadorEquipos generadorEquipos) {
		this.separadorEquipos = generadorEquipos;
	}
}