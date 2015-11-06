package cisc275.game.model;

import java.awt.Point;
import java.io.Serializable;

/**
 * @author rachelbruckel
 *First level of Garbage Collectors. Players can add collectors to the game which then collect trash strewn about the field. Garbage Collectors move randomly
 *and pick up garbage when it is within their radius. 
 */
public class GarbageCollector extends RandomMover implements Serializable {
	Point location; //location of Garbage collector
	static final int RADIUS = 0; //radius of area collect can pick up trash in
	static final int RATE = 0; //rate at which collector can pick up trash - are we sure we still want this?
	public static final int BAG_CAPACITY = 0; //amount of garbage the collector can pick up before their bag is full
	int currGarb; //the about of garbage currently in the collector's bag
	
	
	/**
	 * @param loc
	 * Starting location determined by user input. Radius, rate, and bagCapacity are constant based on level of garbage collector.
	 * currGarb always starts at 0. 
	 */
	public GarbageCollector(Point loc) { //ranking determines radius, efficiency, rate
		// TODO Auto-generated constructor stub
	}
	
	//generic getters and setters
	public void setLocation(Point location) {
		
	}
	
	public Point getLocation() {
		return null;
		
	}

	public void setCurrGarb(int currGarb) {
	
	}
	
	public int getCurrGarb() {
		return 0;
	}
	
	/**
	 * @return
	 * compares currGarb to BAG_CAPACITY to determine if the bag is full. If it is the Garbage Collector will cease moving and can no longer pick up trash.
	 */
	public boolean checkfull() {
		return false;
	}
	
	public String toString() {
		return null;
	}
	
}
