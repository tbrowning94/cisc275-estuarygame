package cisc275.game.model;

import java.awt.Point;
import java.util.ArrayList;

public class Fisherman {
	Point finalLocation;
	Point entryLocation;
	int manTotal;
	int money;
	
	public Fisherman(Point FL, Point EL, int MT, int M) {
		this.finalLocation=FL; this.entryLocation=EL;this.manTotal=MT; this.money=M;
		}

	void onTick() {
	}
	/**
	 * from the 
	 * @param pH
	 * @param damage
	 * @return number of fishermen
	 */
	public int ManNum(Game pH, Garbage damage){
		return 0;
	}
	/**healthier the water, more money that is generated, 
	takes in health of water and returns an amount
	checked every time a water tile reaches estuary*/
	public int Fishing(Water health){
		return money;
		
	}
	public String toString(){
		return "[Fisherman: finalLocation="+finalLocation+"entryLocation="+entryLocation
				+"manTotal="+manTotal+"money="+money+"]";
	}
	
	private Point FL;
	private Point EL;
	private int MT;
	private int M;
}
