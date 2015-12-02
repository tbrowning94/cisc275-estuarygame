package cisc275.game.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Nile
 *sets the number of fishermen based on water health,
 *and the amount of money generated from fishermen
 */
public class Fisherman implements java.io.Serializable {
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
	 * @param ph
	 * @return number of fishermen on screen
	 */
	public int ManNum(Water health){
		if (Water.getHealth() <= 50){
			
		}
		
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

}
