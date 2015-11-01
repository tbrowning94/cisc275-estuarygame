package cisc275.game.model;

import java.awt.Point;

public class Plant {
	
	//plant constants
	static final int ranking = 1; //whether the plant is level one, two, or three (I think this might be easier to do as subclasses)
	private static final int RADIUS = 0; //radius of the are the plant can filter/block water
	static final int START_EFFICIENCY = 0; //efficiency before being attacked by crab
	static final int START_RATE = 0; //rate before being attacked by crab
	
	//plant variables
	Point location; //where the plant was placed
	private int efficiency; //I'm still not sure what the difference between this and rate is
	private int rate; //rate at which the plant filters/blocks the water
	
	//ranking will determine radius efficiency and rate - how would we be able to call different constructors based on the ranking? I definitely think it should be multiple classes. 
	public Plant(Point loc) { 
		// TODO Auto-generated constructor stub
	}
	
	//lowers the efficiency/rate of the plant (essentially a setter, will be called by crab) howMuch can be changed based on level if desired
	public void decreaseEfficiency(int howMuch){ 	
	}
}
