package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import models.homes.PropuestasHome;
import models.jugador.Jugador;
import models.propuesta.Propuesta;

import org.junit.Before;
import org.junit.Test;

public class PropuestasTest {

	private PropuestasHome propuestas;
	private Propuesta propuesta;
	private Jugador juan;
	private Jugador carlos;

	@Before
	public void setUp() {
		propuestas = new PropuestasHome();
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