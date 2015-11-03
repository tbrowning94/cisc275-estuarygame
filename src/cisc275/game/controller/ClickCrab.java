package cisc275.game.controller;
import java.awt.Point;
import cisc275.game.model.Game;


/**
 * @author Team 6
 *
 * ClickCrab will be used to determine if the player has selected 
 * a crab which will then be removed if it is a mitten crab
 */
public class ClickCrab implements Action<Game>{
	Point location;
	boolean remove = false;
	
	/**
	 * The constructor will check the given location for a valid
	 * action(clicking a crab) then seeing if it equals a mitten
	 * crab. If so a cage will be used to remove the crab from the
	 * game and update
	 * @param location
	 */
	public ClickCrab(Point location) {
		super();
		// check is valid and equals at the given
		// location, is so cage and remove in update
		this.location = location;
	}
	
	@Override
	public void update(Game g) {
		// update level, remove clicked crabs
		
	}
	@Override
	public boolean equals(Object obj) {
		// check that click point object is a crab
		// if its a mitten crab return true, else false
		return false;
		
	}
	@Override
	public boolean isValid(Game g) {
		// check that the click is a valid operation
		// should return true as long as it is called
		// on a crab during the wave phase, then equals
		// determines whether its a mitten crab to remove
		// the object
		return false;
	}
	
}
