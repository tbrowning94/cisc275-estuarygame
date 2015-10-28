package cisc275.game.controller.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cisc275.game.controller.Action;
import cisc275.game.model.Level;

public class ActionTest {

	@Test
	public void test() {
		Level testlev = new Level();
		assertEquals(false, Action.isValid(testlev));
		
	}
}
