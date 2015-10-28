package cisc275.game.controller;

import java.awt.Point;

import cisc275.game.model.Level;

public class ClickCrab implements Action<Level>{
	Point location;
	
	public ClickCrab(Point location) {
		super();
		this.location = location;
	}
	
	@Override
	public void update(Level l) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
		
	}
	@Override
	public boolean isValid(Level l) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
