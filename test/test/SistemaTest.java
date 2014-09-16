package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.homes.PropuestasHome;
import model.jugador.Jugador;
import model.propuesta.Propuesta;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

	private PropuestasHome propuestas;
	private Propuesta propuesta;
	private Jugador juan;
	private Jugador carlos;

	@Before
	public void setup() {
		propuestas = new PropuestasHome(null);
		juan = new Jugador("juan", 20);
		carlos = new Jugador("carlos", 21);
		juan.agregarAmigo(carlos);
		juan.proponerAmigo(propuestas, carlos);
	}

	@Test
	public void aceptarUnaPropuesta() {
		propuesta = propuestas.getPropuestas().get(0);

		propuestas.registrarAceptacion(propuesta);

		assertTrue(propuesta.isAceptada());
	}

	@Test
	public void rechazarUnaPropuesta() {
		propuesta = propuestas.getPropuestas().get(0);

		propuestas.registrarRechazo(propuesta, "TIENE CARA DE RATA");

		assertFalse(propuestas.getPropuestas().contains(propuesta));
	}
}