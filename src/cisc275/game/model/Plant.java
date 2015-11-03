package cisc275.game.model;

import java.awt.Point;

/**
 * @author rachelbruckel
 * First level of Plant. Every plant has to have a location, a radius, an efficiency and a way to decrease that efficiency. 
 * As the level of the plant increases, the values for these parameters, and possibly the way efficiency is decreased, will change.
 */
 class Plant {
	
	//plant constants
	private static final int RADIUS = 0; //radius of the are the plant can filter/block water
	static final int START_EFFICIENCY = 0; //efficiency before being attacked by crab
	
	
	//plant variables
	Point location; //where the plant was placed
	private int efficiency; //the amount the plant can reduce the water's flow
	
	
	
	/**
	 * @param loc
	 * Location will be determined by user action. All other attributes will have default values
	 * based on the level of plant (see RADIUS and START_EFFICIENCY).
	 */
	public Plant(Point loc) { 
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param howMuch
	 * //lowers the efficiency of the plant (essentially a setter, will be called by crab) 
	 * howMuch can be changed based on level, and can be factored differently for higher level plants,
	 * making them more resilient to crabs.
	 */
	public void decreaseEfficiency(int howMuch){ 	
	}
}
