package cisc275.game.model.test;
import static org.junit.Assert.*;
import org.junit.Test;
import cisc275.game.model.Crab;


public class CrabTest {

	@Test
	public void testMitten() {
		Crab test = new Crab(true);
		assertTrue(test.isMitten());
	}
	@Test
	public void testSetstop() {
		Crab test = new Crab(0);
		test.setStop(true);
		assertTrue(test.isStop());
	}
	//All other methods involve rando, not sure how to pass it specific values for tests
	@Test
	public void testRando() {
		Crab test = new Crab(0);
		int val1 = test.rando(1);
		int val2 = test.rando(2);
		int val5 = test.rando(5);
		int valelse = test.rando(6);
		boolean bool1,bool2,bool5,boolelse;
		bool1 = bool2 = bool5 = boolelse = false;
		if (val1 >= 1 && val1 <= 8) {
			bool1 = true;
		}
		if (val2 >= 1 && val2 <= 4) {
			bool2 = true;
		}
		if (val5 >= 0 && val5 <= 3) {
			bool5 = true;
		}
		if (valelse >= 358 && valelse <= 626) {
			boolelse = true;
		}
		assertTrue(bool1);
		assertTrue(bool2);
		assertTrue(bool5);
		assertTrue(boolelse);
	}
}
