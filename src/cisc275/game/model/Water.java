package cisc275.game.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import cisc275.game.view.GameView;
import cisc275.game.view.SplashScreen;

/**
 *Generates, health, path and position of water and runoff particles
 */
public class Water 
	implements java.io.Serializable{
	private Point location;
	//ArrayList<Node> path = new ArrayList<Node>();
	//TODO: create linked listed of water instead of nodes?
	private int health;
	private double speed = 1.0;
	private boolean removed;
	private int RunoffParticles;
	private Color runoffC;
	private JLabel wbutton;
	BufferedImage water = createImage("images/textures/water_map.png");
	private ImageIcon wimg = new ImageIcon(water.getScaledInstance(100, 100, 20));
	private SplashScreen splashScreen;
	
	public Water(Point loc, int Health, int RP, Color RO) {
		this.location = loc;
		this.health = Health;
		this.RunoffParticles = RP; 
		Color runoffC = RO;
		this.wbutton.putClientProperty("position", loc);
		this.removed = false;
	}
	public Water(SplashScreen ss, Point loc, int Health, int RP, Color RO, double speed) {
		this.splashScreen = ss;
		this.location = loc;
		this.health = Health;
		this.speed = speed;
		this.RunoffParticles = RP; 
		Color runoffC=RO;
		this.wbutton = ss.createWaterLabel(loc, Health);
		this.removed = false;
	}
	public int getHealth(){
		return this.health;
	}
	public Point getLocation(){
		return this.location;
	}
	public JLabel getWaterButton() {
		return this.wbutton;
	}
	/**
	 * Dependent on the level of the game, there will be a certain amount 
	 * of "particles" of dirt per runoff tile, this method sets
	 * the number of dirt particles per tile
	 * @return RunoffParticles
	 */
	public int setRunoffParticles(int RP){
		return this.RunoffParticles = RP;
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
	public boolean getRemoved() {
		return this.removed;
	}
	
	public void paintWater() {
         wbutton.setIcon(this.wimg);
         wbutton.setLocation(this.location);
    }
	public void setrunoffC(Water health){
		int h = this.health;
		if (h > -50 && h <= 0) {
			this.runoffC = Color.CYAN;
		} else if (h > 0 && h <= 50){
			this.runoffC = Color.YELLOW;
		} else if (h > 50 && h <= 100){
			this.runoffC = Color.GREEN;
		}
	}
	public void decreaseHealth(int plantEff) {
		this.health -= plantEff; 	// Health will be proportional to width, this
		this.RunoffParticles -= 1;	// will be triggered by check proximity of the
								 	// plants radius
		setrunoffC(this);
		if (this.health <= 0) {
			this.removed = true; // On the next update in game, removed all water tiles with removed set to true
		} else {
			wimg = new ImageIcon(water.getScaledInstance(health, 100, 20)); //change image width with health
			this.wbutton.setIcon(wimg);
		}
	}
	public Color getrunoffC(){
		return this.runoffC;
	}
	public void move() {
		int x, y;
		x = (int) this.location.getX();
		y = (int) this.location.getY();
		if (y < GameView.getWorldHeight() - 2*this.speed) { // Not in water yet, continue moving down
			y += 2*this.speed; // TODO: finalize movement amount
		}
		if (y >= GameView.getWorldHeight() - 30) { //TODO: change this hard coded value
			this.removed = true; // in water, remove on next update
		}
		// maybe have the water check if it collides with water to change x?
		//TODO: come up with x algorithm
		this.location.setLocation(x, y);
	}
	public String toString(){
		return "[Water: location="+location+"RunoffParticles="+RunoffParticles
				+"Health="+health+"Color="+runoffC+"]";
	}
	private BufferedImage createImage(String file) {
        BufferedImage bufferedImage;
        try {
        	bufferedImage=ImageIO.read(new File(file));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
	public boolean isStopping() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setStopping(boolean b) {
		// TODO Auto-generated method stub
		
	}

}

