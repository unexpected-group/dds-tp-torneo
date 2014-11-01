package test;

import static org.junit.Assert.assertEquals;
import model.auto.Auto;

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
		Auto a1 = new Auto();
		a1.setMarca("Ford");
		a1.save();
		Auto a2 = new Auto();
		a2.setMarca("Fiat");
		a2.save();
		assertEquals(2, Auto.find.all().size());
	}
	
	@Test
	public void testUpdate() {
		Auto a = new Auto();
		a.setMarca("Ford");
		a.save();
		a.setMarca("Renault");
		a.update();
		assertEquals("Renault", Auto.find.byId(1L).getMarca());
	}
	
	@After
    public void tearDown() throws Exception {
        Helpers.stop(db);
    }
}
