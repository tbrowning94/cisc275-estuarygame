package cisc275.game.controller;
import java.awt.Point;
import cisc275.game.model.Game;

/**
 * PlaceObject is used whenever the player uses
 * a plant or collector. It checks the the location
 * is valid for the object and that the player
 * has money for the object
 * 
 * @author Team 6
 */
public class PlaceObject implements Action<Game>{
	Point location;
	
	/**
	 * PlaceObject constructor determines is the action
	 * is valid and updates the game accordingly
	 * 
	 * @param loc - point where click was made
	 * @param obj - object to be placed(plant or collector)
	 * @param g - instance of game
	 */
	public PlaceObject(Point loc, Object obj, Game g) { //TODO: remove this, replace with a new method
		/** Used to place plants or collectors
		 must check that money is available for passed
	 	object first, if so update money
		 second check that placement is available
		 ie not solid or ontop of another object
		 and must be during placement phase
		if placement is valid update needed list
		 and set location of object*/
		if (isValid(g)) { // if placement valid
			this.location = loc; // set location
			update(g); // update level with new object
		}
		// return null or -1 on failure?
	}
	
	public Point getLocation() {
		return null;
	}
	
	@Override
	public boolean isValid(Game g) {
		// make sure point is available and player has enough money
		return false;
	}
	
	@Override
	public void update(Game g) {
		// update level with new objects, add to
		// relevant list etc.
		
	}
	
	public String toString() {
		return null;
	}
}
