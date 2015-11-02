package cisc275.game.model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import cisc275.game.model.Crab;
import cisc275.game.model.Garbage;

public class GarbageTest {
	Garbage tester = new Garbage(1);
	@Test
	public void getdirection() {
		tester.setdirection(1);
		assertEquals(1, tester.getdirection());
	}
	@Test
	public void getlocation(){
		Point j = new Point();
		tester.setlocation(j);
		assertEquals(j, tester.getlocation());
	}

}
