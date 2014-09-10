package model.homes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.jugador.Calificacion;
import model.jugador.Infraccion;
import model.jugador.Jugador;

public class JugadoresHome {

	private static List<Jugador> jugadores = new ArrayList<Jugador>();

	public static List<Jugador> getJugadores() {
		Jugador juan = new Jugador("Juan Pablo Jacob", 21);
		Jugador manuel = new Jugador("Manuel Gambino", 22);
		Jugador agustin = new Jugador("Agustin Pina", 23);
		Jugador esteban = new Jugador("Esteban Zignego", 24);
		Jugador franco = new Jugador("Franco Bulgarelli", 25);
		
		Jugador ernesto = new Jugador("Ernesto Bossi", 29);
		ernesto.setHandicap(5.9);
		Jugador demian = new Jugador("Demian Alonso", 30);
		demian.setHandicap(8.9);
		Jugador lucas = new Jugador("Lucas Spigariol", 40);
		lucas.setHandicap(3.9);
		Jugador nico = new Jugador("Nico Scarsela", 27);
		nico.setHandicap(4.9);
		Jugador gustavo = new Jugador("Gustavo Pina", 50);
		gustavo.setHandicap(9.9);

		/*--------------------------------------------------------------------------------*/

		juan.agregarAmigo(esteban);
		juan.agregarAmigo(agustin);

		juan.recibirCalificacion(new Calificacion(6.8));
		juan.recibirCalificacion(new Calificacion(9.2));

		ArrayList<Infraccion> infracciones = new ArrayList<>();
		infracciones.add(new Infraccion("Llego tarde al partido"));
		infracciones.add(new Infraccion("Tarjeta roja"));
		juan.setInfracciones(infracciones);

		juan.setHandicap(7.7);

		/*--------------------------------------------------------------------------------*/

		franco.agregarAmigo(juan);
		franco.agregarAmigo(esteban);
		franco.agregarAmigo(manuel);
		franco.agregarAmigo(agustin);

		franco.recibirCalificacion(new Calificacion(8.8));
		franco.recibirCalificacion(new Calificacion(9.3));

		infracciones = new ArrayList<>();
		infracciones.add(new Infraccion("Sabe mucho de diseño"));
		infracciones.add(new Infraccion("Su poder radica en su pelo"));
		franco.setInfracciones(infracciones);

		franco.setHandicap(9.8);

		/*--------------------------------------------------------------------------------*/

		agustin.agregarAmigo(esteban);

		agustin.recibirCalificacion(new Calificacion(5.8));
		agustin.recibirCalificacion(new Calificacion(3.3));

		infracciones = new ArrayList<>();
		infracciones.add(new Infraccion("Hace TADP solo"));
		infracciones.add(new Infraccion("Nos traiciono en el cine"));
		infracciones.add(new Infraccion("Es puto y cagon"));
		agustin.setInfracciones(infracciones);

		agustin.setHandicap(5.6);

		/*--------------------------------------------------------------------------------*/

		manuel.agregarAmigo(agustin);
		manuel.agregarAmigo(juan);

		manuel.recibirCalificacion(new Calificacion(6.6));
		manuel.recibirCalificacion(new Calificacion(2.4));
		manuel.recibirCalificacion(new Calificacion(5.3));

		infracciones = new ArrayList<>();
		infracciones.add(new Infraccion("Juega al basket"));
		manuel.setInfracciones(infracciones);

		manuel.setHandicap(6.1);

		/*--------------------------------------------------------------------------------*/

		esteban.recibirCalificacion(new Calificacion(6.9));

		infracciones = new ArrayList<>();
		infracciones.add(new Infraccion("Esta gordo"));
		esteban.setInfracciones(infracciones);

		esteban.setHandicap(4.8);
		
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
		
		return jugadores;
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