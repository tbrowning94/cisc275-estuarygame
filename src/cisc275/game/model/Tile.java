package cisc275.game.model;

import java.awt.Point;

/**
 * Tiles for background sprites, ie grass, sand, building, etc
	All view related objects get painted on top of tiles, so a
	crab is able to walk on grass etc
	Currently, we have no view related classes or sprites so not
	much can be implemented here yet
 */
public class Tile { 
	Point location;
	/**
	 * @param loc
	 * Sets appropriate sprite, render at location
	 */
	public Tile(Point loc) {// TODO: add param sprite after adding classes
		this.location = loc;
	}
	/**
	 * See if tile things can move over tile
	 * sky will be solid(nothing can go on it) and return true
	 * Runoff/grass/beach will not be solid, return false 
	 * and garbage collector/crabs can walk on them 
	 * @return false
	 */
	public boolean solid() { 
		return false;
	}
	
	/**
	 * Crabs can "break" plants making them disappear
	 * @return false
	 */
	public boolean breakable() { //is the tile breakable?(crab breaking plant)
		return false;
	}

}
