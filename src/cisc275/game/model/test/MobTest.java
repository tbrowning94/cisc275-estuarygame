package cisc275.game.model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import cisc275.game.model.Crab;
import cisc275.game.model.Plant;

public class MobTest {

	@Test
	public void test() {
		Point point1 = new Point(1,1);
		Point point2 = new Point(0,0);
		Plant p = new Plant(point1);
		Crab c = new Crab(true);
		c.setlocation(point2);
		p.ch
	}

}
