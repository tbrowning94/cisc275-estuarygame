package cisc275.game.model;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import cisc275.game.view.InstanceView;
import cisc275.game.view.PlantView;
import cisc275.game.view.ViewTemplate;

/**
 * @author Team6
 * Garbage will randomly spawn and will need to be collected by Garbage collectors
 * Garbage does not move but can be more difficult to pick up depending on ranking
 */
public class Garbage extends InstanceView implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 611892886341823647L;
	static int upxbound = ViewTemplate.scalex(1306);
    static int upybound = ViewTemplate.scalex(580);
    static int downxbound = ViewTemplate.scalex(20);
    static int downybound = ViewTemplate.scalex(270);
	private int ranking;
	private Point location;
	private int damage;
	private boolean removed;
	static BufferedImage[] pics; //view
	private JLabel gbutton;
	BufferedImage trash = createImage("images/trash1.png");
	private ImageIcon gimg = new ImageIcon(trash.getScaledInstance(48, 48, Image.SCALE_DEFAULT));
	public boolean intersecting = false;
	Area garea;

	/**
	 * Garbage constructor, creates a garbage object and label
	 * @param loc - The (x,y) position of the trash
	 * @param dmg - The effect of the trash, determines multiplier of water's effect to estuary
	 * @param rank - determines damage multiplier and pickup difficulty
	 */
	public Garbage(Point loc, int dmg, int rank) {
		this.location = loc;
		this.damage = dmg;
		this.ranking = rank;
		this.setGbutton(createGarbageLabel(loc));
		this.garea = new Area(this.gbutton.getBounds());
		this.removed = false;
	}
	
	//------Getters and Setters--------------------------------------------//
	/**
	 * @return location of this trash object
	 */
	public Point getlocation() {
		return this.location;
	}
	/**
	 * @return damage of this trash object
	 */
	public int getDamage(){
		return this.damage;
	}
	/**
	 * @return removed of this trash object
	 */
	public boolean getRemoved(){
		return this.removed;
	}
	/**
	 * @return ranking of this trash object
	 */
	public int getRanking() {
		return this.ranking;
	}
	/**
	 * @return label for the specific trash object
	 */
	public JLabel getGbutton() {
		return this.gbutton;
	}
	/**
	 * @param loc - update location of this trash
	 */
	public void setlocation(Point loc){
		this.location = loc;
	}
	/**
	 * @param damage - update damage of this trash
	 */
	public void setDamage(int damage){
		this.damage = damage;
	}
	/**
	 * @param rm - update removed of this trash
	 */
	public void setRemoved(boolean rm){
		this.removed = rm;
	}
	/**
	 * @param rank - update ranking of this trash
	 */
	public void setRanking(int rank) {
		this.ranking = rank;
	}
	/**
	 * @param gbutton - new JLabel for trash
	 */
	public void setGbutton(JLabel gbutton) {
		this.gbutton = gbutton;
	}
	
	//------Garbage Methods-------------------------------------------------//
	/**
	 * Uses the checkproximity method with GarbageCollector Matrix as input to check if there are any 
	 * garbage collectors nearby and if so, trash will despawn
	 * and garbagecollector's currgrab will go up
	 */
	public void checkcollector(){
	}
	/**
	 * @return jlabel - label to compare for intersection
	 * checks if a trash's and garbage collector's label bounds are intersecting
	 */
	public boolean checkintersects(JLabel jLabel){
		Area areaA = new Area(jLabel.getBounds());
		intersecting = true;
		System.out.println(intersecting+" GARBAGE");
		return areaA.intersects(garea.getBounds2D());
	    
	}
	public static ArrayList<Garbage> generateTrash(int numGarb) {
		ArrayList<Garbage> newGarb = new ArrayList<Garbage>();
		for(int i = 0; i < numGarb; i++) {
			newGarb.add(new Garbage(rndGarbPoint(), 10, 1));
		}
		return newGarb;
	}
	
	public static Point rndGarbPoint() {
		Random rndx = new Random();
		Random rndy = new Random();
		Point rnd = new Point(rndx.nextInt(upxbound-downxbound)+downxbound, rndy.nextInt(upybound-downybound)+downybound);
		return rnd;
	}

	/**
	 * Repaints the trash objects label at its new location
	 */
	public void paintGarbage() {
         getGbutton().setIcon(this.gimg);
         getGbutton().setLocation(this.location);
    }
	/**
	 * Initializes the trash's label
	 * @param loc - position of label
	 * @return JLabel for trash objects
	 */
	public JLabel createGarbageLabel(Point loc) {
    	BufferedImage trash = pics[0];
    	ImageIcon trashIcon = new ImageIcon(trash.getScaledInstance(ViewTemplate.scalex(48), ViewTemplate.scaley(48), Image.SCALE_DEFAULT));
    	JLabel newTrash = new JLabel();
    	newTrash.setIcon(trashIcon);
    	newTrash.setLocation(loc);
    	newTrash.setSize(ViewTemplate.scalex(48),ViewTemplate.scaley(48));
    	return newTrash;
    }
	/**
	 * Loads in trash images
	 */
	public static void InitializePicturesG() {
		pics = new BufferedImage[1];
   		pics[0] = createImage("images/trash1.png");
	}

	public String toString(){
		return "[Garbage: location="+location+"damage="+damage
				+"ranking="+ranking+"]";
	}
	
}
