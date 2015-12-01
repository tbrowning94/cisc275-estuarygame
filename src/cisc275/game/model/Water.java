package cisc275.game.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Nile
 *Generates, health, path and position of water and runoff particles
 */
public class Water 
	implements java.io.Serializable{
	Point location;
	//ArrayList<Node> path = new ArrayList<Node>();
	int health;
	int RunoffParticles;
	Color runoffC;
	private JButton wbutton;
	private ImageIcon wimg = new ImageIcon("images/Placeholder/placeholder.png");
	
	public Water(Point loc, int Health, int RP, Color RO) {
		this.location = loc;
		this.health = Health;
		this.RunoffParticles = RP; 
		Color runoffC=RO;
		this.wbutton = new JButton(wimg);
		this.wbutton.putClientProperty("position", loc);
	}
	public int getHealth(){
		return this.health;
	}
	public Point getLocation(){
		return this.location;
	}
	public JButton getWaterButton() {
		return this.wbutton;
	}
	/**
	 * Dependent on the level of the game, there will be a certain amount 
	 * of "particles" of dirt per runoff tile, this method sets
	 * the number of dirt particles per tile
	 * @return RunoffParticles
	 */
	public int setRunoffParticles(Game level){
		return this.RunoffParticles;
	}	
	public int getRunoffParticles(){
		return this.RunoffParticles;
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
		return this.health;
	}

	public void setrunoffC(Water health){
	
	}
	public Color getrunoffC(){
		return this.runoffC;
	}
	public String toString(){
		return "[Water: location="+location+"RunoffParticles="+RunoffParticles
				+"Health="+health+"Color="+runoffC+"]";
	}

}

