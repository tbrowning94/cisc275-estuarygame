package cisc275.game.model;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import cisc275.game.view.GameView;
import cisc275.game.view.InstanceView;
import cisc275.game.view.PlantView;
import cisc275.game.view.ViewTemplate;

/**
 * @author Team 6
 *	Generates health, label, and position of water and runoff particles
 *	Stopping tracks when water is blocked by a plant buffer
 *  Removed tracks when the water has reached the estuary
 */
public class Water extends InstanceView implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1875698292843123801L;
	private Point location;
	private boolean Stopping = false;
	static BufferedImage[] pics; //view
	private int health;
	private double speed = ViewTemplate.scaley(1);;
	private boolean removed;
	private int scaledimagex = ViewTemplate.scalex(48);
	private int scaledimagey = ViewTemplate.scalex(48);
	private int RunoffParticles;
	private Color runoffC;
	private JLabel wbutton;
	BufferedImage water = createImage("images/textures/water_map.png");
	private ImageIcon wimg = new ImageIcon(water.getScaledInstance(scaledimagex, scaledimagey, Image.SCALE_DEFAULT));
	public ArrayList<PlantView> affected = new ArrayList<PlantView>();
	
	/**
	 * Water constructor, creates a water object and label
	 * @param loc - The (x,y) position of the water
	 * @param Health - The width of the water, determines effect to estuary
	 * @param RP - runoff particles, currently not implemented
	 * @param RO - runoff color, currently not implemented
	 * @param speed - speed that the runoff moves at
	 */
	public Water(Point loc, int Health, int RP, Color RO, double speed) {
		this.location = loc;
		this.health = Health;
		this.speed = speed;
		this.RunoffParticles = RP; 
		this.runoffC = RO;
		this.setWbutton(createWaterLabel(loc, Health));
		this.removed = false;
	}
	
//------Getters and Setters--------------------------------------------//
	/**
	 * @return health of the specific water object
	 */
	public int getHealth(){
		return this.health;
	}
	/**
	 * @return location of the specific water object
	 */
	public Point getLocation(){
		return this.location;
	}
	/**
	 * @return number of runoff particles for the specific water object
	 */
	public int getRunoffParticles(){
		return this.RunoffParticles;
	}
	/**
	 * @return color of the specific water object
	 */
	public Color getrunoffC(){
		return this.runoffC;
	}
	/**
	 * @return whether or no the water needs to be removed from the level
	 */
	public boolean getRemoved() {
		return this.removed;
	}
	/**
	 * @return label for the specific water object
	 */
	public JLabel getWbutton() {
		return wbutton;
	}
	/**
	 * @return whether the specific water object is being blocked by a plant
	 */
	public boolean isStopping() {
		return Stopping;
	}
	/**
	 * Sets this water objects stopping boolean
	 * @param b - new stopping boolean value
	 */
	public void setStopping(boolean b) {
		Stopping = b;
		
	}
	/**
	 * @param wbutton - new JLabel for water
	 */
	public void setWbutton(JLabel wbutton) {
		this.wbutton = wbutton;
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
	
	/**
	 * Currently not implemented
	 * @param damage
	 * @param RunoffParticles
	 * @return health of runoff
	 * decides what color runoff  will be
	 */
	public int setHealthOfRunoff(Garbage damage, Water RunoffParticles ){
		return this.health;
	}
	/**
	 * Sets runoff color based on current health of water
	 */
	public void setrunoffC(){
		int h = this.health;
		if (h > -50 && h <= 0) {
			this.runoffC = Color.CYAN;
		} else if (h > 0 && h <= 50){
			this.runoffC = Color.YELLOW;
		} else if (h > 50 && h <= 100){
			this.runoffC = Color.GREEN;
		}
	}
	
//------Water Methods--------------------------------------------------//
	/**
	 * Currently not implemented
	 */
	void update() {
	}
	
	/**
	 * Repaints the water objects label at its new location
	 */
	public void paintWater() {
         getWbutton().setIcon(this.wimg);
         getWbutton().setLocation(this.location);
    }
	
	/**
	 * Decreases the health and width of the water based on the plant it contacts
	 * @param plantEff - plant efficiency level effecting this water object
	 */
	public void decreaseHealth(int plantEff) {
		this.health -= plantEff; 	// Health will be proportional to width, this
		this.RunoffParticles -= 1;	// will be triggered by check proximity of the
								 	// plants radius
		this.setrunoffC();
		if (this.health <= 0) {
			this.removed = true; // On the next update in game, removed all water tiles with removed set to true
		} else {
			wimg = new ImageIcon(water.getScaledInstance(health, scaledimagey, 20)); //change image width with health
			this.getWbutton().setIcon(wimg);
		}
	}

	/**
	 * Updates water location, moves straight down from its starting location
	 * unless effected by a plant. If a plant is in the way the water will
	 * change direction unless it is completely stopped
	 */
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
	
	/**
	 * Also decreases water health/width
	 * @param p - plant view object within water's radius
	 */
	public void shrink(PlantView p){
		affected.add(p);
		if(affected.size()==0){
			this.Stopping = true;
		}
		else{
		wimg = new ImageIcon(water.getScaledInstance((int) (health/(affected.size()*(1.75))), scaledimagey, Image.SCALE_DEFAULT)); //change image width with health
		this.getWbutton().setIcon(wimg);
		this.getWbutton().setSize((int) (health/(affected.size()*(1.75))), scaledimagey);
		}
	}
	/**
	 * Returns the water to its normal size when the plant is effected by a crab
	 * @param p - plant view object within water's radius
	 */
	public void normal(PlantView p) {
		affected.remove(p);
		if(affected.size()==0){
			wimg = new ImageIcon(water.getScaledInstance((int) health, scaledimagey, 20));
		}
		else{
			return;
		}
		
		this.getWbutton().setIcon(wimg);
		this.getWbutton().setSize((int) (health/(affected.size()*(1.75))), scaledimagey);
		
	}
	/**
	 * Initializes the water's label
	 * @param loc - position of label
	 * @param health - width of label
	 * @return JLabel for water objects
	 */
	public JLabel createWaterLabel(Point loc, int health) {
    	BufferedImage water = pics[0];
    	ImageIcon waterIcon = new ImageIcon(water.getScaledInstance(ViewTemplate.scalex(health), ViewTemplate.scaley(scaledimagey), 20));
    	JLabel newWater = new JLabel();
    	newWater.setIcon(waterIcon);
    	newWater.setLocation(loc);
    	newWater.setSize(ViewTemplate.scalex(health),ViewTemplate.scaley(scaledimagey));
    	return newWater;
    }
	/**
	 * Loads in water images
	 */
	public static void InitializePicturesW() {
		pics = new BufferedImage[4];
   		pics[0] = createImage("images/textures/water_map.png");
		pics[1] = createImage("images/textures/water_map.png");
		pics[2] = createImage("images/textures/water_map.png");
		pics[3] = createImage("images/textures/water_map.png");
	}

	public String toString(){
		return "[Water: location="+location+"RunoffParticles="+RunoffParticles
				+"Health="+health+"Color="+runoffC+"]";
	}
}

