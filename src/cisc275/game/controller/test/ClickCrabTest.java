package cisc275.game.controller.test;
import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import cisc275.game.controller.ClickCrab;
import cisc275.game.model.Crab;
import cisc275.game.model.Game;
import cisc275.game.model.GarbageCollector;
import cisc275.game.model.Plant;

public class ClickCrabTest {
	Point p1 = new Point(0,0);
	Crab test_mit = new Crab(true, p1); // Mitten crab
	Crab test_nomit = new Crab(false, p1); // Normal crab
	//TODO: Add another object to test for fails
	int m = 100;
	int est_ph = 7;
	Crab[] g_crabs;
	Plant[] g_plants;
	GarbageCollector[] g_collect;
	long g_speed = 100;
	int grows, gcols = 100;
	int lvl = 1;
	Game g = new Game(m, est_ph, g_crabs, g_plants, g_collect, g_speed, grows, gcols, lvl); //TODO: fix this
	
	@Test 
	public void test_ClickCrab() { // Test constructor for updates to game
		//test on mitten crab
		//test on normal crab
		//test any other cases?
		Point p1 = new Point(0,0);
		test_mit.setlocation(p1); // TODO: add a crab constructor that accepts a point?
		Point p2 = new Point(0,1);
		test_nomit.setlocation(p2);
		ClickCrab test_click1 = new ClickCrab(p1);
		assertEquals(test_mit.getlocation(), test_click1.getLocation()); //Passes, mitten at p1
		ClickCrab test_click2 = new ClickCrab(p2);
		assertEquals(test_nomit.getlocation(), test_click2.getLocation()); //Passes, normal crab at p2
	}
	
	@Test
	public void test_update() { // Test update for updated lists in game
		Point p1 = new Point(0,0);
		test_mit.setlocation(p1); // TODO: add a crab constructor that accepts a point?
		Point p2 = new Point(0,0);
		test_nomit.setlocation(p2); // TODO: add a crab constructor that accepts a point?
		ClickCrab test_click1 = new ClickCrab(p1);
		assertEquals(test_nomit, g.getCrabs()); // Passes, only mit crab removed from game
	}
	
	@Test
	public void test_equals() { // Test equals for valid crab type removal
		//test for for crab and type at clicked point
		Point p1 = new Point(0,0);
		test_mit.setlocation(p1); // TODO: add a crab constructor that accepts a point?
		Point p2 = new Point(0,1);
		test_nomit.setlocation(p2);
		ClickCrab ccrab1 = new ClickCrab(p1);
		ClickCrab ccrab2 = new ClickCrab(p2);
		assertEquals(true, ccrab1.equals(test_mit)); //Passes, mitten at p1
		assertEquals(false, ccrab2.equals(test_nomit)); //Fails, normal at p2
	}
	
	@Test
	public void test_isValid() { // isValid will always be turn for player clicks
		//test click is valid anywhere
		Point p1 = new Point(0,0);
		ClickCrab ccrab = new ClickCrab(p1);
		assertEquals(true, ccrab.isValid(g)); //Passes
	}

}
