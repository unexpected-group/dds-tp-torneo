package models.jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import models.excepciones.NoEsAmigoException;
import models.homes.PropuestasHome;
import models.inscripcion.Estandar;
import models.partido.Partido;
import play.db.ebean.Model;

@Entity
@Table(name="Jugadores")
public class Jugador extends Model {

	@Id
	private long id;
	
	private String nombre;
	private int edad;
	private Date fechaNacimiento;
	private int handicap;
	@OneToMany
	private List<Jugador> amigos;
	@OneToMany
	private List<Infraccion> infracciones;
	@OneToMany
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public static Finder<Long, Jugador> getFind() {
		return find;
	}

	public static void setFind(Finder<Long, Jugador> find) {
		Jugador.find = find;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public static Finder<Long, Jugador> find =
			new Finder<Long, Jugador>(Long.class, Jugador.class);
}