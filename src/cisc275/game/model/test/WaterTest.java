package cisc275.game.model.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import cisc275.game.model.Game;
import cisc275.game.model.Garbage;
import cisc275.game.model.Water;

public class WaterTest {
	Water test = new Water(null, null, 0, 10, null);
	Garbage G = new Garbage(0, 15);
	Game game = new Game(0, 0, null, null, null, 0, 0, 0, 0);
	@Test
	public void testsetHealthoFRunoff() {
		int result = G.getDamage()*test.getRunoffParticles();
		assertEquals(result,test.setHealthOfRunoff(G, test));
	}
	public void testsetrunoffC(){
		Color result = Color.blue;
		if(test.getHealth()<50)
			result = Color.blue;
		if(50<test.getHealth() && test.getHealth()<100)
			result = Color.green;
		if(test.getHealth()>100)
			result = Color.black;
		assertEquals(result,test.setHealthOfRunoff(G, test));
	}
	
	public void testsetRunoffParticles(){
		int result = 0;
		if(game.getlevel() == 0)
			 result = 2;
		if(game.getlevel()== 1)
			result = 5;
		if(game.getlevel() == 2)
			result = 10;
		assertEquals(result,test.setRunoffParticles(game));
	}


}

