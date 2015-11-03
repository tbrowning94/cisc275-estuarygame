package cisc275.game.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Flap Jack
 *
 */
public class Water 
	implements java.io.Serializable{
	Point location;
	ArrayList<Node> path = new ArrayList<Node>();
	int health;
	int RunoffParticles;
	public Water(Point loc,ArrayList<Node> p, int heal, int RP) {
		this.location = loc;this.health=heal;this.path=p; this.RunoffParticles=RP;
	}

	public int getHealth(){
		return health;
	}
	/**
	 * @return
	 */
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

	public int setHealthOfRunoff(Garbage damage, Water RunoffParticles ){
		return health;
		
	}
	public String toString(){
		return "[Water: location="+location+"RunoffParticles="+RunoffParticles
				+"Path="+path+"Health="+health+"]";
	}
	private Point loc;
	private ArrayList<Node> p = new ArrayList<Node>();
	private int heal;
	private int RP;
}

