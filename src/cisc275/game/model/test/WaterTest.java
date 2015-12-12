package cisc275.game.model.test;
import static org.junit.Assert.*;
import java.awt.Color;
import java.awt.Point;

import org.junit.Test;
import cisc275.game.model.Game;
import cisc275.game.model.Garbage;
import cisc275.game.model.Water;

/**
 * @author Nile
 *Basic tests of water methods
 */
public class WaterTest {
	/**
	 * tests if setHealthOfRunoff returns product of 
	 * garbage damage and number of particles
	 */
	@Test
	public void testsetHealthOfRunoff() {
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		Garbage G = new Garbage(p1, 10, 1);
		int result = G.getDamage()*test.getRunoffParticles();
		assertEquals(result,test.setHealthOfRunoff(G, test));
	}
	/**
	 * tests color of runoff based on the health of the runoff
	 */
	@Test
	public void testsetrunoffC(){
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		Color result = Color.blue;
		if(test.getHealth()<50)
			result = Color.blue;
		if(50<test.getHealth() && test.getHealth()<100)
			result = Color.green;
		if(test.getHealth()>100)
			result = Color.black;
		assertEquals(result,test.setHealthOfRunoff(G, test));
	}
	/**
	 * tests how many runoff particles to be generated per tile 
	 * dependent on the level
	 */
	@Test
	public void testsetRunoffParticles(){
		Point p1 = new Point(0,0);
		Water.InitializePicturesW();
		Water test = new Water(p1, 48, 5, Color.BLUE, 1.0);
		Game game = new Game(0, 0, null, null, null, 0, 0, 0, 0);
		int result = 0;
		if(game.getlevel() == 0)
			 result = 2;
		if(game.getlevel()== 1)
			result = 5;
		if(game.getlevel() == 2)
			result = 10;
	}


}

