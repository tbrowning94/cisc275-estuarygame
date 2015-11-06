package cisc275.game.model;

import java.util.ArrayList;

/**
 * @author Team 6
 * Mult will be used in the case of multiple objects needing to
 * be present on the same space on the matrix. It contains an ArrayList
 * of Mobs that will add any mobs that need to be present at it's specified
 * location
 *
 */
public class Mult extends Mob{
	
	/**
	 * contains - ArrayList of mobs used to represent multiple objects
	 * on the same space
	 */
	ArrayList<Mob> contains = new ArrayList<Mob>();
	public ArrayList<Mob> getContains() {
		return contains;
	}

	public Mult() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * will add mob to arraylist if it needs to be on the same space
	 * of another object
	 * @param m
	 */
	public void addto(Mob m){
	}
}
