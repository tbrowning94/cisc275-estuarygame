package cisc275.game.model;
import java.awt.Point;
import java.io.Serializable;

/**
 * First level of Plant. Every plant has to have a location, a radius, an efficiency and a way to decrease that efficiency. 
 * As the level of the plant increases, the values for these parameters, and possibly the way efficiency is decreased, will change.
 * @author rachelbruckel
 * 
 */
 public class Plant extends Mob{
	
	//plant constants
	private static final int RADIUS = 0; //radius of the are the plant can block water
	static final int START_EFFICIENCY = 0; //efficiency before being attacked by crab
	
	
	//plant variables
	Point location; //where the plant was placed
	public int efficiency; //the amount the plant can reduce the water's flow
	public int radius; //radius of where the plant can block water
	
	
	
	/**
	 * Location will be determined by user action. All other attributes will have default values
	 * based on the level of plant (see RADIUS and START_EFFICIENCY).
	 * @param loc
	 * 
	 */
	public Plant(Point loc) { 
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * lowers the efficiency of the plant by half,
	 * will run checkProximity(Crab matrix) to determine whether there are any crabs
	 * present to decrease Efficiency
	 */
	public void decreaseEfficiency(){ 	
	}
	
	
	/**
	 * runs checkProximity(Water matrix) to determine whether there is any water nearby
	 * and will reduce the size(health) of that water
	 */
	public void blockwater(){
	}
	public String toString() {
		return null;
	}
}
