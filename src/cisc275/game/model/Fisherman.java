package cisc275.game.model;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import cisc275.game.view.GameView;
import cisc275.game.view.InstanceView;
import cisc275.game.view.ViewTemplate;

/** 
 * @author Team 6
 * Sets the number of fishermen and pH based on water health,
 * and the amount of money generated from fishermen, creates label
 */
public class Fisherman extends InstanceView implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1289859063590233038L;
	Point finalLocation;
	Point entryLocation;
	Point curLocation;
	static BufferedImage[] pics; //view
	int manTotal=0;
	int money=200;
	int pHbar=200;
	int EstHealth=500;
	private boolean removed;
	private JLabel boatman;
	BufferedImage boat = createImage("images/boatmanRE.png");
	private ImageIcon bimg = new ImageIcon(boat.getScaledInstance(90, 70, 20));


	/**
	 * Fisherman constructor, creates a fisherman object and label
	 * @param FL - final location of fisherman
	 * @param EL - entry location of fisherman
	 * @param MT - fisherman count?
	 * @param M - player money for use placing plants
	 * Fisherman constructor and creates a fisherman label in splashscreen
	 */
	public Fisherman(Point FL, Point EL, int MT, int M) {
		this.finalLocation = FL; 
		this.entryLocation = EL;
		this.curLocation = EL;
		this.manTotal = MT; 
		this.money = M;
		this.removed = false;
		this.setFButton(createFLabel(EL));
	}
	
//------Getters and Setters--------------------------------------------//
	/**
	 * @return label for the specific fisherman object
	 */
	public JLabel getFLabel() {
		return this.boatman;
	}
	/**
	 * @return health of estuary stored on fisherman
	 */
	public int getHeatlth(){
		return EstHealth;
	}
	/**
	 * @return pH value stored on fisherman based on health
	 */
	public int getpH(){
		return pHbar;
	}
	/**
	 * @return player money stored on fisherman
	 */
	public int getMoney(){
		return money;
	}
	/**
	 * @return this.removed
	 * boolean if fisherman has been removed
	 */
	public boolean isRemoved() {
		return this.removed;
	}
	/**
	 * @param m - new money value for player
	 * sets players money to a new value
	 */
	public void setMoney(int m) {
		this.money = m;
	}
	/**
	 * @param fbutton
	 * sets fisherman label, updates location
	 */
	public void setFButton(JLabel fbutton) {
		this.boatman = fbutton;
	}

//------Fisherman Methods----------------------------------------------//
	/**
	 * finds the coordinates of the location of a fisherman, then compares the location to the 
	 * x coordinate at the end of the screen(finalLocation) to see if the fisherman should keep 
	 * moving across the screen, removes if the fisherman label reaches the finalLocation
	 */
	public void move() {
		int x, y;
		x = (int) this.curLocation.getX();
		y = (int) this.curLocation.getY();
		if (x < this.finalLocation.getX() - 2) { // Not in water yet, continue moving down
			x += 2; // TODO: finalize movement amount
		}
		if (this.curLocation.getX() == this.finalLocation.getX() - 2) { //TODO: change this hard coded value
			this.removed = true; // in water, remove on next update
		}
		// maybe have the water check if it collides with water to change x?
		//TODO: come up with x algorithm
		this.curLocation.setLocation(x, y);
	}
	/**
	 * Sets the location and image of the fisherman label, and updates
	 */
	public void paintFM() {
		getFLabel().setIcon(this.bimg);
		getFLabel().setLocation(this.curLocation);
	}
	/**
	 * Currently not implemented
	 */
	void onTick() {
	}
	/**
	 * @param EstHealth
	 * @return 0
	 * Changes the amount of fisherman on screen, pH health based on the health of the estuary
	 * and calls fishing to update the amount of money being made from the fishermen
	 */
	public int ManNum(Water health){
		if (EstHealth <= 150){
			manTotal = 0;
			pHbar=pHbar-100;
		}
		if (EstHealth <= 250){
			manTotal = 1;
			pHbar=pHbar-75;
			Fishing();
		}
		if (EstHealth <= 350){
			manTotal = 4;
			pHbar=pHbar-50;
			Fishing();
		}
		if (EstHealth <= 400){
			manTotal = 7;
			pHbar=pHbar-25;
			Fishing();
		}
		else {
			manTotal = 8;
			pHbar = 200;
			Fishing();
		}
		return 0;
	}
	public int getManNum(){
		return manTotal;
	}
	/**
	 *@param runoffloc
	 *@return EstHealth
	 *Uses the location of a water tile to determine if it has run into the estuary
	 *then gets the health of that tile to see how it will affect the health of the estuary
	 *updated the health of the estuary in EstHealth
	*/
	public int Health(Water runoffloc){
		if (runoffloc.getLocation().getY()>=GameView.getWorldHeight()-30){
			EstHealth= EstHealth - runoffloc.getHealth();
		}
		return EstHealth;
	}
	/**
	 * @return money
	 * decides the amount of money that will be generated and added to the current amount of money
	 * based on the total number of fishermen and the health of the estuary
	 */
	public int Fishing(){
		money = money+(EstHealth/10)*manTotal;
		return money;
	}
	/**
	 * @param loc - location of label for fisherman object
	 * @return label for this fisherman object
	 */
	public JLabel createFLabel(Point loc) {
    	BufferedImage fisherman = createImage("images/boatman.png");
    	ImageIcon fmIcon = new ImageIcon(fisherman.getScaledInstance(ViewTemplate.scalex(150), ViewTemplate.scaley(100), 20));
    	JLabel newFM = new JLabel("fisherman");
    	newFM.setIcon(fmIcon);
    	newFM.setLocation(loc);
    	newFM.setSize(ViewTemplate.scalex(75),ViewTemplate.scaley(75));
    	return newFM;
    }
	/**
	 * Loads in fisherman images
	 */
	public static void InitializePicturesF() {
		pics = new BufferedImage[4];
   		pics[0] = createImage("images/boatman.png");
		pics[1] = createImage("images/boatman.png");
		pics[2] = createImage("images/boatman.png");
		pics[3] = createImage("images/boatman.png");
	}
	
	public String toString(){
		return "[Fisherman: finalLocation="+finalLocation+"entryLocation="+entryLocation
				+"manTotal="+manTotal+"money="+money+"]";
	}
}