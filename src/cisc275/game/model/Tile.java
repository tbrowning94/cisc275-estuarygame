package cisc275.game.model;

import java.awt.Point;

public class Tile { //Tiles for background sprites, ie grass, sand, building, etc
					//All view related objects get painted on top of tiles, so a
					//crab is able to walk on grass etc
					//Currently, we have no view related classes or sprites so not
					//much can be implemented here yet
	Point location;
	public Tile(Point loc) {
		// TODO Auto-generated constructor stub
	}

	public boolean solid() { //is the tile solid?
		return false;
	}
	
	public boolean breakable() { //is the tile breakable?(crab breaking plant)
		return false;
	}

}
