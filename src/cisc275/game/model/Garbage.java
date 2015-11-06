package cisc275.game.model;

import java.awt.Point;

/**
 * @author Team6
 * Garbage will randomly spawn and will need to be collected by Garbage collectors
 * Garbage does not move but can be more difficult to pick up depending on ranking
 */
/**
 * @author Ryan
 *
 */
/**
 * @author Ryan
 *
 */
/**
 * @author Ryan
 *
 */
public class Garbage extends Mob implements java.io.Serializable{
	int ranking;
	Point location;
	private int damage;
	int direction; //for view, set which way garbage is moving
	public int getdirection() {
		return 0;
	}
	public void setdirection(int i) {
	}
	public void setDamage(){
		
	}
	public int getDamage(){
		return 0;
	}
	public void setlocation(Point loc){
		
	}
	public Point getlocation() {
		return null;
	}
	void onTick() {
	}
	
	/**Will create garbage at a random location
	 * @param rank determines damage and pickup difficulty
	 */
	public Garbage(int rank) { 
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Uses the checkproximity method with GarbageCollector Matrix as input to check if there are any 
	 * garbage collectors nearby and if so, trash will despawn
	 * and garbagecollector's currgrab will go up
	 */
	public void checkcollector(){
	}

}
