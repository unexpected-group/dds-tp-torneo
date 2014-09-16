package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.armador.ArmadorEquipos;
import model.armador.ParesImpares;
import model.jugador.Jugador;
import model.ordenador.Handicap;
import model.ordenador.OrdenadorEquipos;

import org.junit.Before;
import org.junit.Test;

public class GenerarEquiposTest {

	private List<Jugador> jugadores = new ArrayList<>();
	private List<Jugador> jugadoresCompararOrdenados = new ArrayList<>();
	private OrdenadorEquipos ordenador;
	private ArmadorEquipos separador;

	@Before
	public void setUp() throws Exception {

		for (int i = 0; i < 10; i++) {
			jugadores.add(mock(Jugador.class));
		}
	}

	@Test
	public void ordenarPorHandicap() {
		when(jugadores.get(0).getHandicap()).thenReturn(1.0);
		when(jugadores.get(1).getHandicap()).thenReturn(3.0);
		when(jugadores.get(2).getHandicap()).thenReturn(9.0);
		when(jugadores.get(3).getHandicap()).thenReturn(4.0);
		when(jugadores.get(4).getHandicap()).thenReturn(10.0);
		when(jugadores.get(5).getHandicap()).thenReturn(2.0);
		when(jugadores.get(6).getHandicap()).thenReturn(7.0);
		when(jugadores.get(7).getHandicap()).thenReturn(8.0);
		when(jugadores.get(8).getHandicap()).thenReturn(6.0);
		when(jugadores.get(9).getHandicap()).thenReturn(5.0);

		jugadoresCompararOrdenados.add(jugadores.get(0));
		jugadoresCompararOrdenados.add(jugadores.get(5));
		jugadoresCompararOrdenados.add(jugadores.get(1));
		jugadoresCompararOrdenados.add(jugadores.get(3));
		jugadoresCompararOrdenados.add(jugadores.get(9));
		jugadoresCompararOrdenados.add(jugadores.get(8));
		jugadoresCompararOrdenados.add(jugadores.get(6));
		jugadoresCompararOrdenados.add(jugadores.get(7));
		jugadoresCompararOrdenados.add(jugadores.get(2));
		jugadoresCompararOrdenados.add(jugadores.get(4));

		ordenador = new Handicap();
		ordenador.ordenarJugadores(jugadores);

		assertEquals(jugadores, jugadoresCompararOrdenados);
	}

	// con solo testear una forma de ordenar pensamos que es suficiente ya que
	// las demas formas de ordenar son similares

	@Test
	public void separarEquiposPorParesImpares() {
		List<Jugador> equipoA = new ArrayList<>();
		List<Jugador> equipoB = new ArrayList<>();
		List<Jugador> equipoImpares = new ArrayList<>();
		List<Jugador> equipoPares = new ArrayList<>();

		equipoImpares.add(jugadores.get(0));
		equipoImpares.add(jugadores.get(2));
		equipoImpares.add(jugadores.get(4));
		equipoImpares.add(jugadores.get(6));
		equipoImpares.add(jugadores.get(8));

		equipoPares.add(jugadores.get(1));
		equipoPares.add(jugadores.get(3));
		equipoPares.add(jugadores.get(5));
		equipoPares.add(jugadores.get(7));
		equipoPares.add(jugadores.get(9));

		separador = new ParesImpares();
		separador.armarEquipos(jugadores, equipoA, equipoB);

		assertEquals(equipoA, equipoImpares);
		assertEquals(equipoB, equipoPares);
	}

	// el separar equipos segun posiciones dadas es muy trivial para testear ya
	// que son posiciones hardcodeadas
}