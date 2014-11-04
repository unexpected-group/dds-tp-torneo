package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import models.excepciones.JugadorInscriptoException;
import models.inscripcion.Condicion;
import models.inscripcion.Condicional;
import models.inscripcion.Estandar;
import models.inscripcion.Inscripcion;
import models.inscripcion.Solidario;
import models.jugador.Jugador;
import models.partido.Completo;
import models.partido.Partido;
import models.partido.Pendiente;

import org.junit.Before;
import org.junit.Test;

public class PartidosTest {

	private Partido partido;
	private ArrayList<Inscripcion> ochoInscripcionesEstandar;
	private ArrayList<Inscripcion> nueveInscripcionesEstandar;
	private ArrayList<Inscripcion> diezInscripcionesEstandar;
	private Jugador juan;
	private Jugador carlos;
	private Condicion condicion;

	@Before
	public void setUp() throws Exception {

		partido = new Partido(null, null);

		ochoInscripcionesEstandar = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			ochoInscripcionesEstandar.add(new Estandar(new Jugador("X", 15 + i)));
		}

		nueveInscripcionesEstandar = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			nueveInscripcionesEstandar.add(new Estandar(new Jugador("X", 15 + i)));
		}

		diezInscripcionesEstandar = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			diezInscripcionesEstandar.add(new Estandar(new Jugador("X", 15 + i)));
		}

		juan = new Jugador("Juan", 21);
		carlos = new Jugador("Carlos", 23);

		condicion = mock(Condicion.class);
		when(condicion.evaluarCondicion(partido)).thenReturn(true);
	}

	@Test
	public void desplazarUnJugadorCondicionalCuandoNoHayNinguno() {
		partido.inscribir(new Estandar(carlos));
		partido.inscribir(new Solidario(juan));

		assertFalse(partido.desplazarJugadorCondicional());
	}

	@Test
	public void desplazarUnJugadorCondicionalCuandoHayMasDeUnoVerificaQueSaqueAlPrimeroQueEntra() {
		Inscripcion inscripcion1 = new Condicional(new Jugador("X", 20), condicion);
		Inscripcion inscripcion2 = new Condicional(new Jugador("Y", 20), condicion);
		Inscripcion inscripcion3 = new Estandar(carlos);
		Inscripcion inscripcion4 = new Solidario(juan);
		partido.inscribir(inscripcion3);
		partido.inscribir(inscripcion1);
		partido.inscribir(inscripcion4);
		partido.inscribir(inscripcion2);

		partido.desplazarJugadorCondicional();

		assertFalse(partido.getInscripciones().contains(inscripcion1));
		assertTrue(partido.getInscripciones().contains(inscripcion2));
	}

	@Test
	public void desplazarUnJugadorSolidarioCuandoNoHayNinguno() {
		partido.inscribir(new Estandar(carlos));
		partido.inscribir(new Condicional(juan, condicion));

		assertFalse(partido.desplazarJugadorSolidario());
	}

	@Test
	public void desplazarUnJugadorSolidarioCuandoHayMasDeUnoVerificaQueSaqueAlPrimeroQueEntra() {
		Inscripcion solidario1 = new Solidario(new Jugador("X", 20));
		Inscripcion solidario2 = new Solidario(new Jugador("Y", 20));
		partido.inscribir(new Estandar(carlos));
		partido.inscribir(solidario1);
		partido.inscribir(new Condicional(juan, condicion));
		partido.inscribir(solidario2);

		System.out.println("Before: " + partido.getInscripciones());
		partido.desplazarJugadorSolidario();
		System.out.println("After: " + partido.getInscripciones());
		
		assertFalse(partido.getInscripciones().contains(solidario1));
		assertTrue(partido.getInscripciones().contains(solidario2));
	}

	@Test(expected = JugadorInscriptoException.class)
	public void agregarUnJugadorYaInscripto() {
		partido.inscribir(new Estandar(carlos));
		partido.inscribir(new Estandar(carlos));
	}

	@Test
	public void verificarQueElPartidoEstaPendienteSiNoHay10JugadoresInscriptos() {
		partido = new Partido(null, null, ochoInscripcionesEstandar);

		assertTrue(partido.getEstado() instanceof Pendiente);
	}

	@Test
	public void verificarQueElPartidoEstaConfirmadoAlInscribirDiezJugadores() {
		partido = new Partido(null, null, diezInscripcionesEstandar);

		assertTrue(partido.getEstado() instanceof Completo);
	}

	@Test
	public void verificarQueElPartidoEstaPendienteAlSacarUnJugadorCuandoElPartidoEstaConfirmado() {
		partido = new Partido(null, null, diezInscripcionesEstandar);

		partido.sacarJugador(diezInscripcionesEstandar.get(3).getJugador());

		assertTrue(partido.getEstado() instanceof Pendiente);
	}
}