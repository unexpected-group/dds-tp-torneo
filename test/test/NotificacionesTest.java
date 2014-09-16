package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import model.homes.PropuestasHome;
import model.inscripcion.Estandar;
import model.inscripcion.Inscripcion;
import model.jugador.Jugador;
import model.partido.Partido;

import org.junit.Before;
import org.junit.Test;

public class NotificacionesTest {

	private Partido partido;
	private ArrayList<Inscripcion> diezInscripcionesEstandar;
	private ArrayList<Inscripcion> nueveInscripcionesEstandar;

	@Before
	public void setup() {
		diezInscripcionesEstandar = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			diezInscripcionesEstandar.add(new Estandar(new Jugador("X", 15 + i)));
		}

		nueveInscripcionesEstandar = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			nueveInscripcionesEstandar.add(new Estandar(new Jugador("X", 15 + i)));
		}
	}

	@Test
	public void notificarAlAdministradorAlSacarUnJugadorCuandoElPartidoEstaConfirmado() {
		PropuestasHome propuestas = mock(PropuestasHome.class);
		partido = new Partido(null, null, diezInscripcionesEstandar, propuestas);

		diezInscripcionesEstandar.get(3).getJugador().darseDeBaja(partido);

		verify(propuestas).notificarBaja();
	}

	@Test
	public void notificarAlAdministradorQueElPartidoEstaConfirmado() {
		PropuestasHome propuestas = mock(PropuestasHome.class);
		partido = new Partido(null, null, nueveInscripcionesEstandar, propuestas);
		Jugador jugador = new Jugador("A", 99);
		Inscripcion estandar = new Estandar(jugador);

		partido.inscribir(estandar);

		verify(propuestas).notificarNuevaInscripcion(jugador);
	}

	@Test
	public void notificarInscripcionAAmigos() {
		partido = new Partido(null, null);
		Jugador jugador = mock(Jugador.class);
		Inscripcion estandar = new Estandar(jugador);

		partido.inscribir(estandar);

		verify(jugador).notificarNuevaInscripcion(jugador);
	}
}