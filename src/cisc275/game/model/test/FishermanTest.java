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
		PhProbe R = new PhProbe();
		R.setReading() = 5;
		Fisherman fishm = new  Fisherman();
		Water h = new Water();
		h.setHealth(R.Reading) = 10;
		int result = fishm.Fishing(h);
		assertEquals("50" , result);
		
	}
}


