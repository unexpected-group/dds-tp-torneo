package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import models.excepciones.CuposCompletosException;
import models.excepciones.NoSeCumpleCondicionException;
import models.inscripcion.Condicion;
import models.inscripcion.Condicional;
import models.inscripcion.Estandar;
import models.inscripcion.Inscripcion;
import models.inscripcion.Solidario;
import models.jugador.Jugador;
import models.partido.Partido;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InscripcionesTest {

	private Partido partido;
	private ArrayList<Inscripcion> ochoInscripcionesEstandar;
	private ArrayList<Inscripcion> nueveInscripcionesEstandar;
	private ArrayList<Inscripcion> diezInscripcionesEstandar;
	private Jugador juan;
	private Jugador carlos;

	@Before
	public void setUp() throws Exception {
		
		ochoInscripcionesEstandar = new ArrayList<>();
		for (int i = 0; i < 8; i++){
			ochoInscripcionesEstandar.add(new Estandar(new Jugador("X", 15 + i)));
		}
		
		nueveInscripcionesEstandar = new ArrayList<>();
		for (int i = 0; i < 9; i++){
			nueveInscripcionesEstandar.add(new Estandar(new Jugador("X", 15 + i)));
		}
		
		diezInscripcionesEstandar = new ArrayList<>();
		for (int i = 0; i < 10; i++){
			diezInscripcionesEstandar.add(new Estandar(new Jugador("X", 15 + i)));
		}
		
		juan = new Jugador("Juan", 21);
		carlos = new Jugador("Carlos", 23);
	}

	@Test
	public void inscribirJugadorHabiendoCupos() {
		partido = new Partido(null, null, nueveInscripcionesEstandar);

		partido.inscribir(new Solidario(juan));

		assertEquals(10, partido.cantidadInscripciones());
	}

	@Test(expected = CuposCompletosException.class)
	public void inscribirJugadorHabiendoCuposCompletos() {
		partido = new Partido(null, null, diezInscripcionesEstandar);

		partido.inscribir(new Estandar(juan));
	}

	@Test
	public void inscribirJugadorEstandarDesplazandoJugadorCondicional() {
		partido = new Partido(null, null, nueveInscripcionesEstandar);
		Condicion condicion = mock(Condicion.class);
		when(condicion.evaluarCondicion(partido)).thenReturn(true);
		Inscripcion condicional = new Condicional(juan, condicion);
		partido.inscribir(condicional);
		Inscripcion estandar = new Estandar(carlos);

		partido.inscribir(estandar);

		Assert.assertFalse(partido.getInscripciones().contains(condicional));
		Assert.assertTrue(partido.getInscripciones().contains(estandar));
	}

	@Test
	public void inscribirJugadorEstandarDesplazandoJugadorSolidario() {
		partido = new Partido(null, null, nueveInscripcionesEstandar);
		Inscripcion solidario = new Solidario(juan);
		partido.inscribir(solidario);
		Inscripcion estandar = new Estandar(carlos);

		partido.inscribir(estandar);

		Assert.assertFalse(partido.getInscripciones().contains(solidario));
		Assert.assertTrue(partido.getInscripciones().contains(estandar));
	}

	@Test
	public void inscribirJugadorSolidarioDesplazandoJugadorCondicional() {
		partido = new Partido(null, null, nueveInscripcionesEstandar);
		Condicion condicion = mock(Condicion.class);
		when(condicion.evaluarCondicion(partido)).thenReturn(true);
		Inscripcion condicional = new Condicional(juan, condicion);
		partido.inscribir(condicional);
		Inscripcion solidario = new Solidario(carlos);

		partido.inscribir(solidario);

		Assert.assertFalse(partido.getInscripciones().contains(condicional));
		Assert.assertTrue(partido.getInscripciones().contains(solidario));
	}

	@Test(expected = NoSeCumpleCondicionException.class)
	public void inscribirJugadorCondicionalConCondicionDesaprobada() {
		partido = new Partido(null, null);
		Condicion condicion = mock(Condicion.class);
		when(condicion.evaluarCondicion(partido)).thenReturn(false);
		Inscripcion condicional = new Condicional(juan, condicion);
		
		partido.inscribir(condicional);
	}

	@Test
	public void desplazarJugadorCondicionalInscriptoPorNoCumplirCondicionLuegoDeInscribirOtroJugador() {
		partido = new Partido(null, null, ochoInscripcionesEstandar);
		Condicion condicion = mock(Condicion.class);
		when(condicion.evaluarCondicion(partido)).thenReturn(true, true, false);
		// al inscribirse, evaluarCondicion se llama 2 veces, por eso los 2 true y despues se
		// llama false para probar el test
		Inscripcion condicional = new Condicional(juan, condicion);
		Inscripcion estandar = new Estandar(carlos);
		partido.inscribir(condicional);
		
		partido.inscribir(estandar);

		Assert.assertFalse(partido.getInscripciones().contains(condicional));
		assertEquals(9, partido.cantidadInscripciones());
	}
}