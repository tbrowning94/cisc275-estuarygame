package cisc275.game.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nile
 *
 */
public class Water 
	implements java.io.Serializable{
	Point location;
	ArrayList<Node> path = new ArrayList<Node>();
	int health;
	int RunoffParticles;
	public Water(Point loc,ArrayList<Node> p, int Health, int RP) {
		this.location = loc;this.health=Health;this.path=p; this.RunoffParticles=RP;
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
	/**
	 * Dependent on the level of the game, there will be a certain amount 
	 * of "particles" of dirt per runoff tile, this method sets
	 * the number of dirt particles per tile
	 */
	public void setRunoffParticles(){
	}
		
	public int getRunoffParticles(){
		return RunoffParticles;
	}
	
	void update() {
	}

	/**
	 * @param damage
	 * @param RunoffParticles
	 * @return health (then decides what color runoff  will be and damage it will cause to estuary if 
	 * runoff reaches it
	 */
	public int setHealthOfRunoff(Garbage damage, Water RunoffParticles ){
		return health;
	}

	public String toString(){
		return "[Water: location="+location+"RunoffParticles="+RunoffParticles
				+"Path="+path+"Health="+health+"]";
	}
	private Point loc;
	private ArrayList<Node> p = new ArrayList<Node>();
	private int Health;
	private int RP;
}

