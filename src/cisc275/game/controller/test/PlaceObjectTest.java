package cisc275.game.controller.test;
import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import cisc275.game.controller.ClickCrab;
import cisc275.game.controller.PlaceObject;
import cisc275.game.model.Crab;
import cisc275.game.model.Game;
import cisc275.game.model.Plant;

public class PlaceObjectTest {
	Point p1 = new Point(0,0);
	Point p2 = new Point(0,1);
	Crab test_mit = new Crab(true); // Mitten crab
	Plant test_plant = new Plant(p1); // Normal crab
	//TODO: Add another object to test for fails
	Game g = new Game();
	
	@Test
	public void test_PlaceObject() {
		//test plant placement w/ and w/o money
		//test collector placement w/ and w/o money
		//test on solid and unsolid location
		//test with various path splitting spots
		test_mit.setlocation(p1); // TODO: add a crab constructor that accepts a point?
		PlaceObject po1 = new PlaceObject(p1, test_plant, g);
		assertEquals(true, test_click1.equals(test_click1)); //Passes, mitten at p1
		ClickCrab test_click2 = new ClickCrab(p2);
		assertEquals(false, test_click2.equals(test_click2)); //Fails, normal at p2

	}
	
	@Test
	public void test_update() {
		//test object placed or didn't place as expected
		fail("Not yet implemented");
	}
	
	@Test
	public void test_isValid() {
		//test location permits placement, within path area(not sky/water)
		fail("Not yet implemented");
	}

}
