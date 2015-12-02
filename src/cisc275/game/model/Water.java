package cisc275.game.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import cisc275.game.view.GameView;

/**
 * @author Nile
 *Generates, health, path and position of water and runoff particles
 */
public class Water 
	implements java.io.Serializable{
	Point location;
	//ArrayList<Node> path = new ArrayList<Node>();
	int health;
	private double speed = 1.0;
	private boolean removed;
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
		this.removed = false;
	}
	public Water(Point loc, int Health, int RP, Color RO, double speed) {
		this.location = loc;
		this.health = Health;
		this.speed = speed;
		this.RunoffParticles = RP; 
		Color runoffC=RO;
		this.wbutton = new JButton(wimg);
		this.wbutton.putClientProperty("position", loc);
		this.removed = false;
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
	public void decreaseHealth(int plantEff) {
		this.health -= plantEff; // Health will be proportional to width, this
								 // will be triggered by check proximity of the
								 // plants radius
		if (this.health <= 0) {
			this.removed = true; // On the next update in game, removed all water tiles with removed set to true
		}
	}
	public Color getrunoffC(){
		return this.runoffC;
	}
	public void move() {
		int x, y;
		x = (int) this.location.getX();
		y = (int) this.location.getY();
		if (y < GameView.getWorldHeight() - 2*this.speed) {
			y += 2*this.speed;
		}
		// else in water, update health, remove water
		//TODO: come up with x algorithm, define water height of estuary
		this.location.setLocation(x, y);
	}
	public String toString(){
		return "[Water: location="+location+"RunoffParticles="+RunoffParticles
				+"Health="+health+"Color="+runoffC+"]";
	}

}

