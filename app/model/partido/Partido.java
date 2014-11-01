package model.partido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import model.excepciones.CuposCompletosException;
import model.excepciones.JugadorInscriptoException;
import model.excepciones.JugadorNoInscriptoException;
import model.excepciones.NoSeCumpleCondicionException;
import model.homes.PartidosHome;
import model.inscripcion.Inscripcion;
import model.inscripcion.Prioridad;
import model.jugador.Jugador;

public class Partido {

	private LocalDate fecha;
	private String lugar;
	private Estado estado;
	private Configuracion configuracion;
	private List<Inscripcion> inscripciones;
	private List<Jugador> jugadoresPartido;

	public Partido(LocalDate fecha, String lugar) {
		this(fecha, lugar, new ArrayList<>());
	}
	
	public Partido(LocalDate fecha,	String lugar, List<Inscripcion> inscripciones) {
		if (inscripciones == null)
			throw new RuntimeException("PARTIDO SIN LISTA DE INSCRIPCIONES");
		this.fecha = fecha;
		this.lugar = lugar;
		this.inscripciones = inscripciones;
		if (inscripciones.size() < 10)
			this.estado = new Pendiente();
		else
			this.estado = new Completo();
	}

	private void cargarJugadores() {
		jugadoresPartido = new ArrayList<Jugador>();
		inscripciones.forEach(ins -> jugadoresPartido.add(ins.getJugador()));
	}

	public void configurar() {
		cargarJugadores();
		configuracion.getOrdenadorEquipos().ordenarJugadores(jugadoresPartido);
		configuracion.getArmadorEquipos().armarEquipos(jugadoresPartido);
	}

	public void confirmarPartido() {
		PartidosHome.agregarPartido(this);
	}

	public void inscribir(Inscripcion inscripcion) {
		if (hayCupos()) {
			if (inscripcion.puedeInscribirse(this))
				agregarInscripcion(inscripcion);
			else
				throw new NoSeCumpleCondicionException("NO SE CUMPLE LA CONDICION");
		} else if (inscripcion.desplazoJugador(this))
			agregarInscripcion(inscripcion);
		else
			throw new CuposCompletosException("CUPOS COMPLETOS");
	}

	public boolean desplazarJugadorCondicional() {
		return desplazarJugador(inscripcion
				-> inscripcion.tienePrioridad(Prioridad.CONDICIONAL));
	}

	public boolean desplazarJugadorSolidario() {
		return desplazarJugador(inscripcion
				-> inscripcion.tienePrioridad(Prioridad.SOLIDARIO));
	}

	private boolean desplazarJugador(Predicate<Inscripcion> condicion) {
		Optional<Inscripcion> inscripcionParaSacar;
		inscripcionParaSacar = inscripciones.stream()
				.filter(condicion)
				.findFirst();
		if (inscripcionParaSacar.isPresent()) {
			estado.quitarInscripcion(inscripcionParaSacar.get(), this);
			return true;
		}
		return false;
	}

	private void agregarInscripcion(Inscripcion inscripcion) {
		if (inscripciones.stream().anyMatch(
				ins -> ins.getJugador() == inscripcion.getJugador())) {
			throw new JugadorInscriptoException("JUGADOR YA INSCRIPTO");
		} else {
			estado.agregarInscripcion(inscripcion, this);
			verificarCondiciones();
		}
	}

	public Inscripcion buscarInscripcionDeJugador(Jugador jugador) {
		Optional<Inscripcion> inscripcionParaSacar;
		inscripcionParaSacar = inscripciones.stream()
				.filter(inscripcion -> inscripcion.esDelJugador(jugador))
				.findFirst();
		if (inscripcionParaSacar.isPresent())
			return inscripcionParaSacar.get();
		else
			throw new JugadorNoInscriptoException("EL JUGADOR NO ESTABA INSCRIPTO");
	}

	public void sacarJugador(Jugador jugador) {
		estado.quitarInscripcion(buscarInscripcionDeJugador(jugador), this);
	}

	private void verificarCondiciones() {
		inscripciones.removeIf(inscripcion
				-> inscripcion.noVerificaLaCondicion(this));
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

	public Configuracion getConfiguracion() {
		return configuracion;
	}

	public void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	public List<Jugador> getJugadoresPartido() {
		return jugadoresPartido;
	}

	public void setJugadoresPartido(List<Jugador> jugadoresPartido) {
		this.jugadoresPartido = jugadoresPartido;
	}
}