package cisc275.game.model;

/**
 * Class for objects that move randomly (such as crab and garbage collector)
 * @author rachelbruckel
 *
 */
public abstract class RandomMover extends Mob{
	
	/**
	 * defines how objects extending this class will move.
	 * after, spawn, the object will randomly move one space up, down,
	 * left, or right(except if on a wall)
	 *  
	 */
	public void moveRandomly() {
		
	}
}
