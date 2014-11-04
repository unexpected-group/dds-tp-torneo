package test;

import static org.junit.Assert.assertEquals;
import models.jugador.Calificacion;
import models.jugador.Infraccion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import play.test.FakeApplication;
import play.test.Helpers;

public class ConnectionTest {

	private FakeApplication db;

	@Before
	public void setUp() {
		db = Helpers.fakeApplication(Helpers.inMemoryDatabase());
		Helpers.start(db);
	}
	
	@Test
	public void testGenerico() {
		Infraccion i = new Infraccion("MALO");
		
		i.save();
		Calificacion c = new Calificacion(3.0);
		c.save();
		
		System.out.println(Infraccion.find.byId(1L).getFecha());
		System.out.println(Calificacion.find.byId(1L).getPuntaje());
		
		assertEquals(1, Infraccion.find.all().size());
		assertEquals(1, Calificacion.find.all().size());
	}
	
	@Test
	public void testUpdate() {
		Infraccion i = new Infraccion("FEO");
		i.save();
		i.setMotivo("OTRO");
		i.update();
		assertEquals("OTRO", i.getMotivo());
	}
	
	@After
    public void tearDown() throws Exception {
        Helpers.stop(db);
    }
}
