package cisc275.game.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cisc275.game.model.Fisherman;
import cisc275.game.model.PhProbe;
import cisc275.game.model.Water;

public class FishermanTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testFishing(){
		PhProbe Reading = new PhProbe();
		Fisherman fishm = new  Fisherman();
		Water health = new Water();
		
		health == Water.setHealth(Reading));
		
		int result = fishm.Fishing(10);
		
		assertEquals("50" , result);
		
	}
}


