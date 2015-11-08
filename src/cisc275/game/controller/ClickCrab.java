package cisc275.game.controller;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cisc275.game.model.Crab;
import cisc275.game.model.Game;


/**
 * ClickCrab will be used to determine if the player has selected 
 * a crab which will then be removed if it is a mitten crab
 * 
 * @author Team 6
 */
public class ClickCrab extends AbstractAction implements Action<Game> {
	private Point location;
	private Game g;
	private boolean remove = false;
	
	/**
	 * The constructor will check the given location for a valid
	 * action(clicking a crab) then seeing if it equals a mitten
	 * crab. If so a cage will be used to remove the crab from the
	 * game and update
	 * 
	 * @param location - point where the player clicked
	 */
	public ClickCrab(Point location) {
		// check is valid and equals at the given
		// location, is so cage and remove in update
		this.location = location;
		this.remove = false;
	}
	
	public Point getLocation() {
		return location;
	}
	
	public boolean getRemove() {
		return remove;
	}
	
	public void setRemove(Point p) {
		
	}
	
	@Override
	public void update(Game g) {
		// update level, remove clicked crabs
		
	}
	@Override
	public boolean equals(Object obj) {
		// check that click point object is a crab
		// if its a mitten crab return true, else false
		return false;
		
	}
	@Override
	public boolean isValid(Game g) {
		// check that the click is a valid operation
		// should return true as long as it is called
		// on a crab during the wave phase, then equals
		// determines whether its a mitten crab to remove
		// the object
		return false;
	}
	
	public String toString() {
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkButton(e);
		
	}

	private void checkButton(ActionEvent e) {
		int lidx = 0;
		for (Crab crab : g.getCrabs()) { // loop though crabs
			if (crab.getlocation() == ((Crab) e.getSource()).getlocation()) { // check if crabs location matches clicked location
				System.out.println("crab location matchs");
			}
		}
		
	}
	
}
