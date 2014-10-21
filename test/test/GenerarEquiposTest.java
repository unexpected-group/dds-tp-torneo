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
	private List<Jugador> jugadoresOrdenados = new ArrayList<>();
	private OrdenadorEquipos ordenador;
	private ArmadorEquipos armador;

	@Before
	public void setUp() throws Exception {
		for (int i = 0; i < 10; i++) {
			jugadores.add(mock(Jugador.class));
		}
	}

	@Test
	public void ordenarPorHandicap() {
		when(jugadores.get(0).getHandicap()).thenReturn(1);
		when(jugadores.get(1).getHandicap()).thenReturn(3);
		when(jugadores.get(2).getHandicap()).thenReturn(9);
		when(jugadores.get(3).getHandicap()).thenReturn(4);
		when(jugadores.get(4).getHandicap()).thenReturn(10);
		when(jugadores.get(5).getHandicap()).thenReturn(2);
		when(jugadores.get(6).getHandicap()).thenReturn(7);
		when(jugadores.get(7).getHandicap()).thenReturn(8);
		when(jugadores.get(8).getHandicap()).thenReturn(6);
		when(jugadores.get(9).getHandicap()).thenReturn(5);

		jugadoresOrdenados.add(jugadores.get(0));
		jugadoresOrdenados.add(jugadores.get(5));
		jugadoresOrdenados.add(jugadores.get(1));
		jugadoresOrdenados.add(jugadores.get(3));
		jugadoresOrdenados.add(jugadores.get(9));
		jugadoresOrdenados.add(jugadores.get(8));
		jugadoresOrdenados.add(jugadores.get(6));
		jugadoresOrdenados.add(jugadores.get(7));
		jugadoresOrdenados.add(jugadores.get(2));
		jugadoresOrdenados.add(jugadores.get(4));

		ordenador = new Handicap();
		ordenador.ordenarJugadores(jugadores);

		assertEquals(jugadores, jugadoresOrdenados);
	}

	// con solo testear una forma de ordenar pensamos que es suficiente ya que
	// las demas formas de ordenar son similares

	@Test
	public void armarEquiposPorParesImpares() {
		List<Jugador> lista = new ArrayList<>();
		
		lista.add(jugadores.get(0));
		lista.add(jugadores.get(2));
		lista.add(jugadores.get(4));
		lista.add(jugadores.get(6));
		lista.add(jugadores.get(8));
		lista.add(jugadores.get(1));
		lista.add(jugadores.get(3));
		lista.add(jugadores.get(5));
		lista.add(jugadores.get(7));
		lista.add(jugadores.get(9));
		
		armador = new ParesImpares();
		armador.armarEquipos(jugadores);
		
		assertEquals(lista, jugadores);
	}

	// el separar equipos segun posiciones dadas es muy trivial para testear ya
	// que son posiciones hardcodeadas
}