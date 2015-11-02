package cisc275.game.model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import cisc275.game.model.Crab;

public class CrabTest {
	Crab tester = new Crab(true);
	@Test
	public void getdirection() {
		tester.setdirection(1);
		assertEquals(1, tester.getdirection());
	}
	public void getlocation(){
		Point j = new Point();
		tester.setlocation(j);
		assertEquals(j, tester.getlocation());
	}
}
