package cisc275.game.model.test;
import static org.junit.Assert.*;
import java.awt.Color;
import java.awt.Point;

import org.junit.Test;
import cisc275.game.model.Game;
import cisc275.game.model.Garbage;
import cisc275.game.model.Water;
import cisc275.game.view.GameView;
import cisc275.game.view.PlantView;
import cisc275.game.view.ViewTemplate;

/**
 * @author Nile
 *Basic tests of water methods
 */
public class WaterTest {
	@Test
	public void testSetrm() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		test.setRemoved(true);
		assertTrue(test.getRemoved());
	}
	@Test
	public void testSetstop() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		test.setStopping(true);
		assertTrue(test.isStopping());
	}
	@Test
	public void testSetro() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		test.setRunoffParticles(6);
		assertEquals(6, test.getRunoffParticles());
	}
	@Test
	public void testSethealth() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		test.setHealthOfRunoff(96);
		assertEquals(96, test.getHealth());
	}
	@Test
	public void testSetrunoffC() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 100, 5, Color.BLUE, 1.0);
		test.setrunoffC();
		assertEquals(Color.green, test.getrunoffC());
		test.setHealthOfRunoff(50);
		test.setrunoffC();
		assertEquals(Color.yellow, test.getrunoffC());
		test.setHealthOfRunoff(25);
		test.setrunoffC();
		assertEquals(Color.cyan, test.getrunoffC());
	}
	@Test
	public void testpiantwater() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		Point p2 = new Point(0, 1);
		test.setLocation(p2); //only sets water location, not label
		test.paintWater(); //updates label image and location
		assertEquals(p2, test.getWbutton().getLocation());
	}
	@Test
	public void testDechealth() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		test.decreaseHealth(5);
		assertEquals(43, test.getHealth());
		Water test2 = new Water(p1, 5, 5, Color.BLUE, 1.0);
		test2.decreaseHealth(5);
		assertTrue(test2.getRemoved());
	}
	@Test
	public void testmove() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		Point p2 = new Point(0,2);
		test.move();
		assertEquals(p2, test.getLocation());
		Point p3 = new Point(0,ViewTemplate.WORLD_HEIGHT-100);
		Water test2 = new Water(p3, 48, 5, Color.BLUE, 1.0);
		test2.move();
		assertTrue(test2.getRemoved());
	}
	@Test
	public void testshrink() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		PlantView.InitializePictures();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		PlantView pv = new PlantView(1, p1);
		test.shrink(pv);
		assertEquals(36, test.getHealth());
//		Point p2 = new Point(50,50);
//		Water test2 = new Water(p2, 5, 5, Color.BLUE, 1.0);
//		test2.shrink(pv);
//		test2.affected.remove(0);
//		test2.shrink(pv);
//		assertTrue(test2.isStopping());
	}
	@Test
	public void testnormal() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		PlantView.InitializePictures();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		PlantView pv = new PlantView(1, p1);
		test.shrink(pv);
		test.normal(pv);
		assertEquals(36, test.getHealth());
//		Point p2 = new Point(50,50);
//		Water test2 = new Water(p2, 5, 5, Color.BLUE, 1.0);
//		test2.shrink(pv);
//		test2.affected.remove(0);
//		test2.shrink(pv);
//		assertTrue(test2.isStopping());
	}
	@Test
	public void testtostring() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		assertEquals("[Water: location="+p1.toString()+"RunoffParticles=5Health=48Color=java.awt.Color[r=0,g=0,b=255]]", test.toString());
	}

}

