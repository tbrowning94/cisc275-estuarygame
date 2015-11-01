package cisc275.game.controller;

import java.awt.Point;

import cisc275.game.model.Level;

public class PlaceObject implements Action{
	Point location;
	
	public PlaceObject(Point loc, Object obj, Level l) {
		// Used to place plants or collectors
		// must check that money is available for passed
		// object first, if so update money
		// second check that placement is available
		// ie not solid or ontop of another object
		// and must be during placement phase
		// if placement is valid update needed list
		// and set location of object
		if (isValid(l)) { // if placement valid
			this.location = loc; // set location
			update(l); // update level with new object
		}
		// return null or -1 on failure?
	}
	
	@Override
	public boolean isValid(Level l) {
		// make sure point is available and player has enough money
		return false;
	}
	@Override
	public void update(Level l) {
		// update level with new objects, add to
		// relevant list etc.
		
	}
	

}
