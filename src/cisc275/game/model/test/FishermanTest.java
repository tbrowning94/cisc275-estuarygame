package cisc275.game.model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import cisc275.game.model.Fisherman;
import cisc275.game.model.Game;
import cisc275.game.model.Garbage;
import cisc275.game.model.Water;

public class FishermanTest {
	Fisherman test = new Fisherman(null, null, 0, 0);
	Game game = new Game(0, 6, null, null, null, 0, 0, 0, 0);
	Garbage G = new Garbage(0, 0);
	
	@Test
	public void testFishing(){
		Water h = new Water(null, null, 10, 0, null);
		int MultOfHealth = 2;
		int result = h.getHealth() * MultOfHealth;
		assertEquals(result , test.Fishing(h));
	}
	public void testManNum(){
		game.getHealthOfEstuary();
		int fishmult = 2;
		int result = 6 * fishmult;
		assertEquals(result, test.ManNum(game));
	}
	
}


