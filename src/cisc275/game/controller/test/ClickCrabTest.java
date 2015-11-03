package cisc275.game.controller.test;
import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;

import cisc275.game.controller.ClickCrab;
import cisc275.game.model.Crab;

public class ClickCrabTest {
	Crab test_mit = new Crab(true); // Mitten crab
	Crab test_nomit = new Crab(false); // Normal crab
	//TODO: Add another object to test for fails
	Game g = new Game();
	
	@Test
	public void test_ClickCrab() {
		//test on mitten crab
		//test on normal crab
		//test any other cases?
		Point p1 = new Point(0,0);
		test_mit.setlocation(p1); // TODO: add a crab constructor that accepts a point?
		Point p2 = new Point(0,1);
		test_nomit.setlocation(p2);
		ClickCrab test_click1 = new ClickCrab(p1);
		assertEquals(true, test_click1.equals(test_click1)); //Passes, mitten at p1
		ClickCrab test_click2 = new ClickCrab(p2);
		assertEquals(false, test_click2.equals(test_click2)); //Fails, normal at p2
	}
	
	@Test
	public void test_update() {
		//test removal of mitten crab
		//test what happens to normal crab
		//other tests?
		fail("Not yet implemented");
	}
	
	@Test
	public void test_equals() {
		//test for type of crab at clicked point
		fail("Not yet implemented");
	}
	
	@Test
	public void test_isValid() {
		//test click is on crab objects
		Point p1 = new Point(0,0);
		test_mit.setlocation(p1); // TODO: add a crab constructor that accepts a point?
		Point p2 = new Point(0,1);
		test_nomit.setlocation(p2);
		ClickCrab test_click1 = new ClickCrab(p1);
		assertEquals(true, test_click1.isValid(g); //Passes, mitten at p1
		ClickCrab test_click2 = new ClickCrab(p2);
		assertEquals(true, test_click2.isValid(g); //Passes, normal at p2
	}

}
