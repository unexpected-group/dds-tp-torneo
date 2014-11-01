package model.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.excepciones.NoEsAmigoException;
import model.homes.PropuestasHome;
import model.inscripcion.Estandar;
import model.partido.Partido;
import play.db.ebean.Model;

public class Jugador extends Model {
	
	private final String nombre;
	private final int edad;
	private Date fechaNacimiento;
	private int handicap;
	private List<Jugador> amigos;
	private List<Infraccion> infracciones;
	private List<Calificacion> calificaciones;

	public Jugador(String nombre, int edad) {
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

	public void calificar(Jugador jugador, Calificacion calificacion) {
		calificacion.setCalificador(this);
		jugador.recibirCalificacion(calificacion);
	}

	public void recibirCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion);
	}

	public void proponerAmigo(PropuestasHome propuestas, Jugador amigo) {
		if (amigos.contains(amigo))
			propuestas.agregarPropuestaAmigo(amigo);
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

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Double promedioCalificacionesPartido(Partido partido) {
		return calificaciones.stream()
				.filter(calificacion -> calificacion.getPartido() == partido)
				.mapToDouble(calificacion -> calificacion.getPuntaje())
				.average().getAsDouble();
	}

	public Double promedioUltimasCalificaciones(int cantidad) {
		return calificaciones.stream().skip(calificaciones.size() - cantidad)
				.mapToDouble(calificacion -> calificacion.getPuntaje())
				.average().getAsDouble();
	}
}