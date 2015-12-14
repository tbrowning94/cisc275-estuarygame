package cisc275.game.model.test;
import static org.junit.Assert.*;
import org.junit.Test;
import cisc275.game.model.Crab;


public class CrabTest {

	@Test
	public void testSetstop() {
		Crab test = new Crab(0);
		test.setStop(true);
		assertTrue(test.isStop());
	}
	//All other methods involve rando, not sure how to pass it specific values for tests

}
