package cisc275.game.model;

import java.awt.Point;

public class Plant {
	Point location; //where the plant was placed 
	int ranking; //whether the plant is level one, two, or three (I think this might be easier to do as subclasses)
	private int radius; //radius of the are the plant can filter/block water
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
