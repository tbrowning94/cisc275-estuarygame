package cisc275.game.model;

import java.awt.Point;

/**
 * @author rachelbruckel
 *Third level of Garbage Collector
 */
public class GarbageCollector2 extends GarbageCollector {
	
	Point location; //location of Garbage collector
	static final int RADIUS = 0; //radius of area collect can pick up trash in
	static final int RATE = 0; //rate at which collector can pick up trash - are we sure we still want this?
	static final int BAG_CAPACITY = 0; //amount of garbage the collector can pick up before their bag is full
	int currGarb; //the about of garbage currently in the collector's bag
	
	
	/**
	 * @param loc
	 * Starting location determined by user input. Radius, rate, and bagCapacity are constant based on level of garbage collector.
	 * currGarb always starts at 0. 
	 */
	public GarbageCollector2(Point loc) {
		super(loc);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
