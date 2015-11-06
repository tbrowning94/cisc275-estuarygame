package cisc275.game.model;

import java.awt.Point;

/**
 * @author Team6
 *Crab will be randomly generated and then randomly move around the map
 *it's location and type will determine how plants interact with it
 *when it is found by the plants checkefficiency function
 *
 *mittencount keeps track of the total number of crabs on the board
 *mitten determines whether the crab is harmful or not
 *speed determines how fast the crab moves(changes by level)
 */
public class Crab extends RandomMover implements java.io.Serializable{
	static int mittencount; 
	Point location;
	boolean mitten;
	int speed;
	int direction; //unclear in UML
	public Crab(boolean mit) {
		// TODO Auto-generated constructor stub
	}
	public Crab(boolean mit, int speed){
		
	}
	public int getdirection() {
		return 0;
	}
	public void setdirection(int location) {
	}
	public void setlocation(Point loc){
		
	}
	public Point getlocation() {
		return null;
	}
	void onTick() {
	}
	//Generates random starting point of crab, 
	//and random generates next direction
	//Sleep to determine how often changes direction
	
}
