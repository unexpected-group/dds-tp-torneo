package test;

import static org.junit.Assert.assertEquals;
import model.jugador.Infraccion;

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
	public void testConection() {
		Infraccion i = new Infraccion("FEO");
		i.save();
		System.out.println(Infraccion.find.byId(1L).getFecha());
		assertEquals(1, Infraccion.find.all().size());
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
