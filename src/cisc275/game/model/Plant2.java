package cisc275.game.model;

import java.awt.Point;

/**
 * @author rachelbruckel
 *Third level of plant. The starting efficiency and radius of this plant will be higher than the second level of Plant. 
 *Efficiency will also be decreased the less by crabs.
 */
public class Plant2 extends Plant {


	//plant constants
	private static final int RADIUS = 0; //radius of the are the plant can filter/block water
	static final int START_EFFICIENCY = 0; //efficiency before being attacked by crab
		
	public Plant2(Point loc) {
		super(loc);
		// TODO Auto-generated constructor stub
	}

}
