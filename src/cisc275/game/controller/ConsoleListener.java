package cisc275.game.controller;
import cisc275.game.model.Game;

/**
 * A very basic GameListener that can be added to a Game so that
 * every tick and every action produces console output using
 * System.out.
 *  
 * @author Team 6
 */
public class ConsoleListener implements GameListener<Game> {

    public void onTickEvent(Game game) {
        //System.out.println("Tick #: " + game.getTickId());
        System.out.println(game);
    }
    
    public void onPerformActionEvent(Action<Game> action, Game game) {
        System.out.println("Action: " + action);
        System.out.println(game);
    }

    public void onStartEvent(Game game) {
        System.out.println("Start:");
        System.out.println(game);
            
    }

    public void onEndEvent(Game game) {
        System.out.println("End:");
        System.out.println(game);
    }
    
    public void onEvent(String event, Game game) {
        System.out.println(event);
        System.out.println(game);
    }
}
