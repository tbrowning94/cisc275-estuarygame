package cisc275.game.model;
import java.awt.Point;


/**
 * @author Tyler
 *
 * Tile will be used for background sprites, ie grass, sand, building, etc
 * All view related objects get painted on top of tiles, so a
 * crab is able to walk on grass etc
 * Currently, we have no view related classes or sprites so not
 * much can be implemented here yet; This will probably be an abstract class
 */
public class Tile {
	Point location;
	
	/**
	 * Tile will set a sprite to a specific location
	 * @param loc
	 */
	public Tile(Point loc) {// TODO: add param sprite after adding classes
		// set appropriate sprite, render at location
		this.location = loc;
	}

	/**
	 * Solid will be used to determine pathing on Tile
	 * @return
	 */
	public boolean solid() { //is the tile solid?
		return false;
	}
	
	/**
	 * Breakable will be used to update the state of a Tile
	 * @return
	 */
	public boolean breakable() { //is the tile breakable?(crab breaking plant)
		return false;
	}

}
