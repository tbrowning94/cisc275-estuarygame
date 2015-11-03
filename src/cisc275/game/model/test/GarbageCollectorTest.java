package cisc275.game.model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import cisc275.game.model.GarbageCollector;

public class GarbageCollectorTest {
	Point j = new Point();
	GarbageCollector test = new GarbageCollector(j);
	@Test
	public void test() {
		assertEquals(true, test.checkfull());
	}
	
}
