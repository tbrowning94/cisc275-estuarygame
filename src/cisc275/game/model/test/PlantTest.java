package cisc275.game.model.test;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import cisc275.game.model.Plant1;
import cisc275.game.model.Plant2;
import cisc275.game.model.Plant;

public class PlantTest {
	
	Point loc = new Point(0,0);
	Plant plant = new Plant(loc);
	Plant1 plant1 = new Plant1(loc);
	Plant2 plant2 = new Plant2(loc);

	@Test
	public void plantLevelsTest() {
		assertTrue(plant.efficiency < plant1.efficiency);
		assertTrue(plant1.efficiency < plant2.efficiency);
		assertTrue(plant.radius < plant1.radius);
		assertTrue(plant1.radius < plant2.radius);
	}
	
	/**
	 * Test to determine if decreaseEfficiency will cause the plant's efficiency to decrease by half. 
	 */
	@Test 
	public void effiencyDecreaseTest() {
		plant.efficiency = 10; //I believe we'll be adding getters and setters which will then be used here instead
		assertEquals(10, plant.efficiency);
		plant.decreaseEfficiency();
		assertEquals(5, plant.efficiency);
	}

}
