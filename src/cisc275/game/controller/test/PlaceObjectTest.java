package cisc275.game.controller.test;
import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import cisc275.game.controller.PlaceObject;
import cisc275.game.model.Crab;
import cisc275.game.model.Game;
import cisc275.game.model.GarbageCollector;
import cisc275.game.model.Plant;

public class PlaceObjectTest {
	Point p1 = new Point(0,0);
	Point p2 = new Point(0,1);
	//Crab test_mit = new Crab(true, p1); // Mitten crab
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
	Game g = new Game(m, est_ph, g_crabs, g_plants, g_collect, g_speed, grows, gcols, lvl); //TODO: fix this
	
	@Test
	public void test_PlaceObject() { // Test constuctor for updates to game
		//test plant placement w/ and w/o money
		//test collector placement w/ and w/o money
		//test on solid and unsolid location
		//test with various path splitting spots
		Point pt1 = new Point(0,0);
		Plant plant1 = new Plant(pt1); // Normal crab
		PlaceObject po1 = new PlaceObject(p1, plant1, g);
		assertEquals(plant1, g.getPlants().get(0)); //TODO: Define equals for plants
	}
	
	@Test
	public void test_update() {
		//test object placed or didn't place as expected, this is tested with constructor**
		fail("Not yet implemented");
	}
	
	@Test
	public void test_isValid() { // Test placement within game bounds
		//test location permits placement, within path area(not sky/water)
		PlaceObject po1 = new PlaceObject(p1, test_plant, g);
		assertEquals(true, po1.isValid(g)); //Passes, no objects at point
		PlaceObject po2 = new PlaceObject(p2, test_plant, g);
		assertEquals(true, po2.isValid(g)); //Passes, no object at point
		//TODO: add test based on money(w/ and w/o enough)
	}

}
