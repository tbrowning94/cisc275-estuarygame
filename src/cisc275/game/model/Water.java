package cisc275.game.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Water 
	implements java.io.Serializable{
	Point location;
	ArrayList<Node> path = new ArrayList<Node>();
	int health;
	int RunoffParticles;
	public Water(Point location,ArrayList<Node> p, int health, int RunoffParticles) {
		this.location = location;this.health=health;this.path=path; this.RunoffParticles=RunoffParticles;
	}
	public int getHealth(){
		return health;
	}
	public Point getLocation(){
		return location;
	}
	public List getPath(){
		return path;
	}
	public void setRunoffParticles(){
		Game.getLevel();
	}
		
	public int getRunoffParticles(){
		return RunoffParticles;
	}
	
	void update() {
	}

	public int setHealth(Game pH, Garbage damage, Water RunoffParticles ){
		return health;
		
	}
	public String toString(){
		return "[Water: location="+location+"RunoffParticles="+RunoffParticles
				+"Path="+path+"Health="+health+"]";
	}
	private Point location1;
	private ArrayList<Node> path1 = new ArrayList<Node>();
	private int health1;
	private int RunoffParticles1;
}

