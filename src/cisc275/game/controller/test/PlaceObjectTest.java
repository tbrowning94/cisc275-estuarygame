package cisc275.game.controller.test;
import static org.junit.Assert.*;
import java.awt.Point;
import java.util.List;

import org.junit.Test;
import cisc275.game.controller.ClickCrab;
import cisc275.game.controller.PlaceObject;
import cisc275.game.model.Crab;
import cisc275.game.model.Game;
import cisc275.game.model.GarbageCollector;
import cisc275.game.model.Level;
import cisc275.game.model.Plant;

public class PlaceObjectTest {
	Point p1 = new Point(0,0);
	Point p2 = new Point(0,1);
	Crab test_mit = new Crab(true); // Mitten crab
	Plant test_plant = new Plant(p1); // Normal crab
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
	
	@Test
	public void test_PlaceObject() {
		//test plant placement w/ and w/o money
		//test collector placement w/ and w/o money
		//test on solid and unsolid location
		//test with various path splitting spots

	}
	
	@Test
	public void test_update() {
		//test object placed or didn't place as expected
		fail("Not yet implemented");
	}
	
	@Test
	public void test_isValid() {
		//test location permits placement, within path area(not sky/water)
		PlaceObject po1 = new PlaceObject(p1, test_plant, g);
		assertEquals(true, po1.isValid(g)); //Passes, mitten at p1
		PlaceObject po2 = new PlaceObject(p2, test_plant, g);
		assertEquals(false, po2.isValid(g)); //Fails, normal at p2
		//TODO: add test based on money(w/ and w/o enough)
	}

}
