package cisc275.game.model;

import java.awt.Point;

public class Garbage {
	int ranking;
	Point location;
	private int damage;
	private int speed;
	int direction; //for view, set which way garbage is moving
	public int getdirection() {
		return 0;
	}
	public void setdirection(int i) {
	}
	public void setDamage(){
		
	}
	public void setlocation(Point loc){
		
	}
	public Point getlocation() {
		return null;
	}
	void onTick() {
	}
	public Garbage(int rank) { //rank determines the damage and speed
		// TODO Auto-generated constructor stub
	}

}
