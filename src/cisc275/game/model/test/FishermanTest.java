package cisc275.game.model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import cisc275.game.model.Fisherman;
import cisc275.game.model.Water;

public class FishermanTest {
	Fisherman test = new Fisherman(null, null, 0, 0);
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testFishing(){
		Water h = new Water(null, null, 10, 0);
		int MultOfHealth = 2;
		int result = 10 * MultOfHealth;
		assertEquals(result , test.Fishing(h));
	}
	
}


