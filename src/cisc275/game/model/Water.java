package cisc275.game.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nile
 *Generates, health, path and position of water and runoff particles
 */
public class Water 
	implements java.io.Serializable{
	Point location;
	ArrayList<Node> path = new ArrayList<Node>();
	int health;
	int RunoffParticles;
	Color runoffC;
	public Water(Point loc,ArrayList<Node> p, int Health, int RP, Color RO) {
		this.location = loc;this.health=Health;this.path=p; this.RunoffParticles=RP; Color runoffC=RO;
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
	 * @return 
	 */
	public int setRunoffParticles(Game level){
		return RunoffParticles;
	}
		
	public int getRunoffParticles(){
		return RunoffParticles;
	}
	
	void update() {
	}

	/**
	 * @param damage
	 * @param RunoffParticles
	 * @return health of runoff
	 * decides what color runoff  will be
	 */
	public int setHealthOfRunoff(Garbage damage, Water RunoffParticles ){
		return health;
	}

	public void setrunoffC(Water health){
	
	}
	public Color getrunoffC(){
		return runoffC;
	}
	public String toString(){
		return "[Water: location="+location+"RunoffParticles="+RunoffParticles
				+"Path="+path+"Health="+health+"Color="+runoffC+"]";
	}

}

