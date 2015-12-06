package cisc275.game.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import cisc275.game.view.GameView;
import cisc275.game.view.SplashScreen;

/** 
 * @author Nile
 *sets the number of fishermen and pH based on water health,
 *and the amount of money generated from fishermen
 */
public class Fisherman extends JFrame implements java.io.Serializable{
	Point finalLocation;
	Point entryLocation;
	Point curLocation;
	int manTotal=0;
	int money=200;
	int pHbar=200;
	int EstHealth=500;
	private boolean removed;
	private JLabel boatman;
	private SplashScreen splashScreen;
	BufferedImage boat = createImage("images/boatman.png");
	private ImageIcon bimg = new ImageIcon(boat.getScaledInstance(150, 100, 20));


	/**
	 * @param ss
	 * @param FL
	 * @param EL
	 * @param MT
	 * @param M
	 * Fisherman constructor and creates a fisherman label in splashscreen
	 */
	public Fisherman(SplashScreen ss, Point FL, Point EL, int MT, int M) {
		this.splashScreen = ss;
		this.finalLocation = FL; 
		this.entryLocation = EL;
		this.curLocation = EL;
		this.manTotal = MT; 
		this.money = M;
		this.removed = false;
		this.setFButton(ss.createFLabel(EL));
	}
	
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
	public Fisherman getThis(){
		return this;
	}
	/**
	 * Sets the location and image of the fisherman label, and updates
	 */
	public void paintFM() {
		getFLabel().setIcon(this.bimg);
		getFLabel().setLocation(this.curLocation);
	}


	public JLabel getFLabel() {
		return this.boatman;
	}
	
	/**
	 * @param fbutton
	 * sets fisherman label to be a button
	 */
	public void setFButton(JLabel fbutton) {
		this.boatman = fbutton;
	}
	/**
	 * @return this.removed
	 * boolean if fisherman has been removed
	 */
	public boolean isRemoved() {
		return this.removed;
	}
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
	
	public int getHeatlth(){
		return EstHealth;
	}
	public int getpH(){
		return pHbar;
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
	
	public int getMoney(){
		return money;
	}
	

	public String toString(){
		return "[Fisherman: finalLocation="+finalLocation+"entryLocation="+entryLocation
				+"manTotal="+manTotal+"money="+money+"]";
	}

/**
 * @param file
 * @return null
 * when called creates and loads a usable image which is buffered from a string file name
 */
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
}