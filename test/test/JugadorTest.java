package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import model.excepciones.JugadorNoInscriptoException;
import model.excepciones.NoEsAmigoException;
import model.homes.PropuestasHome;
import model.inscripcion.Estandar;
import model.jugador.Calificacion;
import model.jugador.Jugador;
import model.partido.Partido;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JugadorTest {

	private Partido partido;
	private Jugador juan;
	private Jugador carlos;

	@Before
	public void setUp() throws Exception {
		partido = new Partido(null, null);

		juan = new Jugador("Juan", 21);
		carlos = new Jugador("Carlos", 15);
	}

	@Test
	public void darDeBajaJugadorConReemplazante() {
		partido.inscribir(new Estandar(juan));
		Jugador jugadorRemplazante = new Jugador("X", 21);

		juan.darseDeBaja(partido, jugadorRemplazante);

		Assert.assertTrue(partido.getInscripciones().contains(
				partido.buscarInscripcionDeJugador(jugadorRemplazante)));
		Assert.assertFalse(partido.getInscripciones().contains(juan));
	}

	@Test
	public void darDeBajaJugadorSinReemplazante() {
		partido.inscribir(new Estandar(juan));

		juan.darseDeBaja(partido);

		Assert.assertFalse(juan.getInfracciones().isEmpty());
		Assert.assertTrue(partido.getInscripciones().isEmpty());
	}

	@Test(expected = JugadorNoInscriptoException.class)
	public void darDeBajaJugadorCuandoEsteNuncaSeInscribioPreviamente() {
		juan.darseDeBaja(partido);
	}

	@Test
	public void calificarUnJugador() {
		Calificacion calificacion = new Calificacion(5, "Calificacion", null);

		juan.calificar(carlos, calificacion);

		Assert.assertEquals(1, carlos.getCalificaciones().size());
	}

	@Test(expected = NoEsAmigoException.class)
	public void jugadorProponeUnJugadorQueNoEsSuAmigo() {
		juan.proponerAmigo(null, carlos);
	}

	@Test
	public void proponerUnJugador() {
		PropuestasHome propuestas = new PropuestasHome(null);
		juan.agregarAmigo(carlos);

		juan.proponerAmigo(propuestas, carlos);

		Assert.assertTrue(propuestas.getPropuestas().contains(propuestas.propuestaDelJugador(carlos)));
	}

	@Test
	public void calcularPromedioUltimasCalificacionesDePartido() {
		Calificacion calificacion1 = mock(Calificacion.class);
		when(calificacion1.getPartido()).thenReturn(partido);
		when(calificacion1.getPuntaje()).thenReturn(2.0);
		Calificacion calificacion2 = mock(Calificacion.class);
		when(calificacion2.getPartido()).thenReturn(partido);
		when(calificacion2.getPuntaje()).thenReturn(8.0);
		Calificacion calificacion3 = mock(Calificacion.class);
		when(calificacion3.getPartido()).thenReturn(new Partido(null, null));
		when(calificacion3.getPuntaje()).thenReturn(1.0);

		juan.calificar(carlos, calificacion1);
		juan.calificar(carlos, calificacion2);
		juan.calificar(carlos, calificacion3);

		assertEquals((Double) 5.0, carlos.promedioCalificacionesPartido(partido));
	}

	@Test
	public void calcularPromedioUltimasCalificacionesDadas() {
		Calificacion calificacion1 = mock(Calificacion.class);
		when(calificacion1.getPuntaje()).thenReturn(2.0);
		Calificacion calificacion2 = mock(Calificacion.class);
		when(calificacion2.getPuntaje()).thenReturn(8.0);
		Calificacion calificacion3 = mock(Calificacion.class);
		when(calificacion3.getPuntaje()).thenReturn(4.0);

		juan.calificar(carlos, calificacion1);
		juan.calificar(carlos, calificacion2);
		juan.calificar(carlos, calificacion3);

		assertEquals((Double) 6.0, carlos.promedioUltimasCalificaciones(2));
	}
}