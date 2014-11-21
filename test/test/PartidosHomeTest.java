package test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import models.homes.PartidosHome;
import models.partido.Partido;

import org.junit.Test;

public class PartidosHomeTest {

	@Test
	public void seAgregaUnPartidoAlHomeLuegoDeConfirmarlo() {
		Partido partido = new Partido(new Date(), "Maschwitz");
		partido.confirmarPartido();
		assertTrue(PartidosHome.getPartidos().contains(partido));
	}
}