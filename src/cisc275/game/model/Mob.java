package cisc275.game.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * A Mob is anything in the game that has a given location and needs to interact
 * with other objects 
 * @author Team 6
 *
 */
public class Mob {
	/**
	 * location - location of the mob within the game and within 
	 * the mob matrix
	 * 
	 * radius - determines how far out the mob can detect 
	 * our mobs with the matrix
	 * 
	 * mobs - holds all mobs within matrix, underlying
	 * board of game for interaction purposes
	 */
	Point location;
	int radius;
	static Mob[][] mobs;
	public Mob() {
		// TODO Auto-generated constructor stub
	}
	
	/**The method will be called within the methods of Mob 
	 * subclasses(Plant uses checkefficiency() and blockwater(), garbage 
	 * uses checkcollector()), checks proximity according to the Mob's radius
	 * and the Mob matrix. 
	 * @return ArrayList<Mob> containing all Mob objects found in the matrix
	 * within the given Mob's radius
	 */
	ArrayList<Mob> checkProximity(){
		return null; 
		
	}

}
