package cisc275.game.model;

import java.awt.Point;

public class Crab extends RandomMover{
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
