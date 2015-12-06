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
 *sets the number of fishermen based on water health,
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
	public void paintFM() {
		getFLabel().setIcon(this.bimg);
		getFLabel().setLocation(this.curLocation);
	}
//	public JProgressBar getbarMoney(){
//		return barMoney;
//	}
//
//	public JProgressBar getbarPh(){
//		return barPh;
//	}

	public JLabel getFLabel() {
		return this.boatman;
	}
	
	public void setFButton(JLabel fbutton) {
		this.boatman = fbutton;
	}
	public boolean isRemoved() {
		return this.removed;
	}
	void onTick() {
	}
	/**
	 * @param ph
	 * @return number of fishermen on screen
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
	/**healthier the water, more money that is generated, 
	takes in health of water and returns an amount
	checked every time a water tile reaches estuary*/
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