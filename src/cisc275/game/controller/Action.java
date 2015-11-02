package cisc275.game.controller;
import java.awt.Point;

import cisc275.game.model.Game;

/**
 * An Action is something that a player can perform
 * on a game model. 
 * 
 * @param <G>
 */
public interface Action<G extends Game> {
	
	/**
     * Returns true if this Action is valid to perform
     * on the given state of the game
     * 
     * @param game
     * @return
     */
	public boolean isValid(Game g);
	
    /**
     * Mutates state of the game according to the properties
     * of this Action
     * 
     * @param level
     */
	public void update(Game g);

}
