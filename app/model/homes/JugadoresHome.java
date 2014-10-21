package model.homes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.jugador.Calificacion;
import model.jugador.Infraccion;
import model.jugador.Jugador;

public class JugadoresHome {

	private static List<Jugador> jugadores;

	public static List<Jugador> getJugadores() {
		jugadores = new ArrayList<Jugador>();
		inicializar();
		return jugadores;
	}

	private static void inicializar() {
		Jugador juan = new Jugador("Juan Pablo Jacob", 21);
		Jugador manuel = new Jugador("Manuel Gambino", 22);
		Jugador agustin = new Jugador("Agustin Pina", 23);
		Jugador esteban = new Jugador("Esteban Zignego", 24);
		Jugador franco = new Jugador("Franco Bulgarelli", 25);
		Jugador ernesto = new Jugador("Ernesto Bossi", 29);
		Jugador demian = new Jugador("Demian Alonso", 30);
		Jugador lucas = new Jugador("Lucas Spigariol", 40);
		Jugador nico = new Jugador("Nico Scarscela", 27);
		Jugador gustavo = new Jugador("Gustavo Pina", 50);
		
		ernesto.setHandicap(5);
		demian.setHandicap(8);
		lucas.setHandicap(3);
		nico.setHandicap(4);
		gustavo.setHandicap(9);

		ArrayList<Infraccion> infracciones = new ArrayList<>();

		/*--------------------------------------------------------------------------------*/

		juan.agregarAmigo(esteban);
		juan.agregarAmigo(agustin);
		juan.recibirCalificacion(new Calificacion(6.8));
		juan.recibirCalificacion(new Calificacion(9.2));
		infracciones.add(new Infraccion("Llega tarde al partido"));
		juan.setInfracciones(infracciones);
		juan.setHandicap(7);

		/*--------------------------------------------------------------------------------*/

		franco.agregarAmigo(juan);
		franco.agregarAmigo(esteban);
		franco.agregarAmigo(manuel);
		franco.agregarAmigo(agustin);
		franco.recibirCalificacion(new Calificacion(8.8));
		franco.recibirCalificacion(new Calificacion(9.3));
		infracciones = new ArrayList<>();
		infracciones.add(new Infraccion("Hace parciales dificiles"));
		franco.setInfracciones(infracciones);
		franco.setHandicap(9);

		/*--------------------------------------------------------------------------------*/

		agustin.agregarAmigo(esteban);
		agustin.recibirCalificacion(new Calificacion(5.8));
		agustin.recibirCalificacion(new Calificacion(3.3));
		infracciones = new ArrayList<>();
		infracciones.add(new Infraccion("Hace TADP solo"));
		infracciones.add(new Infraccion("Nos traiciona en el cine"));
		agustin.setInfracciones(infracciones);
		agustin.setHandicap(5);

		/*--------------------------------------------------------------------------------*/

		manuel.agregarAmigo(agustin);
		manuel.agregarAmigo(juan);
		manuel.recibirCalificacion(new Calificacion(6.6));
		manuel.recibirCalificacion(new Calificacion(2.4));
		manuel.recibirCalificacion(new Calificacion(5.3));
		infracciones = new ArrayList<>();
		infracciones.add(new Infraccion("Es alto"));
		manuel.setInfracciones(infracciones);
		manuel.setHandicap(6);

		/*--------------------------------------------------------------------------------*/

		esteban.recibirCalificacion(new Calificacion(6.9));
		infracciones = new ArrayList<>();
		infracciones.add(new Infraccion("Esta gordo"));
		esteban.setInfracciones(infracciones);
		esteban.setHandicap(4);
		
		/*--------------------------------------------------------------------------------*/
		
		jugadores.add(juan);
		jugadores.add(manuel);
		jugadores.add(agustin);
		jugadores.add(esteban);
		jugadores.add(franco);		
		jugadores.add(ernesto);
		jugadores.add(demian);
		jugadores.add(lucas);
		jugadores.add(nico);
		jugadores.add(gustavo);
	}

	public static Jugador getJugador(String nombre) {
		Optional<Jugador> jugador = jugadores.stream()
				.filter(j -> j.getNombre().equalsIgnoreCase(nombre)).findFirst();
		if (jugador.isPresent())
			return jugador.get();
		else
			return null;
	}
}