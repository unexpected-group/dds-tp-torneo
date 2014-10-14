package model.jugador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.excepciones.NoEsAmigoException;
import model.homes.PropuestasHome;
import model.inscripcion.Estandar;
import model.partido.Partido;

public class Jugador implements Observer {

	private final String nombre;
	private final int edad;
	private final LocalDate fechaNacimiento;
	private List<Jugador> amigos;
	private Double handicap;
	private List<Infraccion> infracciones;
	private List<Calificacion> calificaciones;

	public Jugador(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = null;
		this.amigos = new ArrayList<>();
		this.infracciones = new ArrayList<>();
		this.calificaciones = new ArrayList<>();
	}

	public void agregarAmigo(Jugador amigo) {
		amigos.add(amigo);
	}

	public void darseDeBaja(Partido partido) {
		darseDeBaja(partido, null);
	}

	public void darseDeBaja(Partido partido, Jugador jugadorReemplazante) {
		partido.sacarJugador(this);
		if (jugadorReemplazante != null)
			partido.inscribir(new Estandar(jugadorReemplazante));
		else
			infracciones.add(new Infraccion("NO SE OFRECIO REEMPLAZANTE"));
	}

	@Override
	public void notificarNuevaInscripcion(Jugador jugador) {
	}

	@Override
	public void notificarBaja() {
	}

	public void calificar(Jugador jugador, Calificacion calificacion) {
		calificacion.setCalificador(this);
		jugador.recibirCalificacion(calificacion);
	}

	public void recibirCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion);
	}

	public void proponerAmigo(PropuestasHome administrador, Jugador amigo) {
		if (amigos.contains(amigo))
			administrador.agregarPropuestaAmigo(amigo);
		else
			throw new NoEsAmigoException("NO SON AMIGOS");
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public List<Jugador> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Jugador> amigos) {
		this.amigos = amigos;
	}

	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public void setInfracciones(List<Infraccion> infracciones) {
		this.infracciones = infracciones;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Double getHandicap() {
		return handicap;
	}

	public void setHandicap(Double handicap) {
		this.handicap = handicap;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public Double promedioCalificacionesPartido(Partido partido) {
//		return calificaciones.stream()
//				.filter(calificacion -> calificacion.getPartido().equals(partido))
//				.mapToDouble(calificacion -> calificacion.getPuntaje())
//				.average().getAsDouble();
		return Math.random();
	}

	public Double promedioUltimasCalificaciones(int cantidad) {
//		return calificaciones.stream().skip(calificaciones.size() - cantidad)
//				.mapToDouble(calificacion -> calificacion.getPuntaje())
//				.average().getAsDouble();
		return Math.random();
	}
}