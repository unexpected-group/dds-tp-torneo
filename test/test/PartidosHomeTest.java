package test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import model.homes.PartidosHome;
import model.partido.Partido;

import org.junit.Test;

public class PartidosHomeTest {

	@Test
	public void seAgregaUnPartidoAlHomeLuegoDeConfirmarlo() {
		Partido partido = new Partido(LocalDate.now(), "Maschwitz");
		partido.confirmarPartido();
		assertTrue(PartidosHome.getPartidos().contains(partido));
	}
}