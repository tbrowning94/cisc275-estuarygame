package cisc275.game.model;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Team6
 *Crab will be randomly generated and then randomly move around the map
 *it's location and type will determine how plants interact with it
 *when it is found by the plants checkefficiency function
 *
 *mittencount keeps track of the total number of crabs on the board
 *mitten determines whether the crab is harmful or not
 *speed determines how fast the crab moves(changes by level)
 */
public class Crab extends RandomMover implements java.io.Serializable{
	static int mittencount; 
	Point location;
	boolean mitten;
	int speed;
	int direction; //unclear in UML
	private Image image;
	private JButton cbutton;
	
	
	public Crab(boolean mit, Point loc) {
		this.mitten = mit;
		this.location = loc;
		cbutton = new JButton(new ImageIcon("images/textures/bush2.png"));
		cbutton.putClientProperty("position", loc);
	}
	
	public Crab(boolean mit, int speed){
		this.mitten = mit;
		this.speed = speed;
	}
	
	public int getdirection() {
		return direction;
	}
	
	public JButton getButton() {
		return cbutton;
	}
	public void setdirection(int location) {
	}
	public void setlocation(Point loc){
		
	}
	public Point getlocation() {
		return null;
	}
	void onTick() {
	}
	//Generates random starting point of crab, 
	//and random generates next direction
	//Sleep to determine how often changes direction
	
}
