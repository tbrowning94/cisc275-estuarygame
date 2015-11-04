package cisc275.game.controller.test;
import static org.junit.Assert.*;
import java.awt.Point;
import java.util.List;
import org.junit.Test;
import cisc275.game.controller.ClickCrab;
import cisc275.game.model.Crab;
import cisc275.game.model.Game;
import cisc275.game.model.GarbageCollector;
import cisc275.game.model.Level;
import cisc275.game.model.Plant;

public class ClickCrabTest {
	Crab test_mit = new Crab(true); // Mitten crab
	Crab test_nomit = new Crab(false); // Normal crab
	//TODO: Add another object to test for fails
	int m = 100;
	int est_ph = 7;
	Crab[] g_crabs;
	Plant[] g_plants;
	GarbageCollector[] g_collect;
	long g_speed = 100;
	int grows, gcols = 100;
	int lvl = 1;
	List<Level> lvls;
	Game g = new Game(m, est_ph, g_crabs, g_plants, g_collect, g_speed, grows, gcols, lvl, lvls); //TODO: fix this
	
	@Test //removed constuctor, no longer needed
	public void test_ClickCrab() {
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
	public void test_update() {
		Point p1 = new Point(0,0);
		test_mit.setlocation(p1); // TODO: add a crab constructor that accepts a point?
		Point p2 = new Point(0,0);
		test_nomit.setlocation(p2); // TODO: add a crab constructor that accepts a point?
		ClickCrab test_click1 = new ClickCrab(p1);
		assertEquals(test_nomit, g.getCrabs()); // Passes, only mit crab removed from game
	}
	
	@Test
	public void test_equals() {
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
	public void test_isValid() { //TODO: change to check that click is valid not object is valid <- DONE!
		//test click is valid anywhere
		Point p1 = new Point(0,0);
		ClickCrab ccrab = new ClickCrab(p1);
		assertEquals(true, ccrab.isValid(g)); //Passes
	}

}
