package cisc275.game.controller;
import java.awt.Point;
import cisc275.game.model.Level;

/**
 * An Action is something that a player can perform
 * on a game model. 
 * 
 * @param <L>
 */
public interface Action<L extends Level> {
	
	/**
     * Returns true if this Action is valid to perform
     * on the given state of the game
     * 
     * @param level
     * @return
     */
	public boolean isValid(Level l);
	
    /**
     * Mutates state of the game according to the properties
     * of this Action
     * 
     * @param level
     */
	public void update(Level l);

}
