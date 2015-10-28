package cisc275.game.model;

import java.awt.Point;

public class Garbage {
	int ranking;
	Point location;
	private int damage;
	private int speed;
	int direction; //unclear in UML
	int getdirection() {
		return 0;
	}
	void setdirection() {
	}
	Point getlocation() {
		return null;
	}
	void onTick() {
	}
	public Garbage(int rank) { //rank determines the damage and speed
		// TODO Auto-generated constructor stub
	}

}
