package cisc275.game.model;

import java.awt.Point;
import java.util.ArrayList;

public class Water {
	Point location;
	ArrayList<Node> path = new ArrayList<Node>();
	int damage;
	int health;
	int Runoff;
	public Water() {
		// TODO Auto-generated constructor stub
	}
	public void setRunoff(){
		
	}
	void update() {
	}
	//takes in the PhProbe reading and sets health
	public int setHealth(PhProbe Reading){
		return health;
		
	}
	public void int checkHealth(){
		
	}
}
