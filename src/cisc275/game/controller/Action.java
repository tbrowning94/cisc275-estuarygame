package cisc275.game.controller;
import cisc275.game.model.Game;
import javax.swing.AbstractAction;

/**
 * An Action is something that a player can perform
 * on a game model. 
 * 
 * @author Team 6
 * @param <G> - extension of game
 */
public interface Action<G extends Game> {
	
	/**
     * Returns true if this Action is valid to perform
     * on the given state of the game
     * 
     * @param g - instance of game
     * @return boolean - true for valid action, false otherwise
     */
	public boolean isValid(Game g);
	
    /**
     * Mutates state of the game according to the properties
     * of this Action
     * 
     * @param g - instance of game
     */
	public void update(Game g);

}
