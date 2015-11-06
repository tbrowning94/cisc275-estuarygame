package cisc275.game.controller;

import cisc275.game.model.Game;

/**
 * Player will be used to handle all listeners
 * for actions available by the person playing our game
 * 
 * @author Team 6
 */
public class Player implements GameListener<Game>{ //May not need game listener here? implemented in game view where the main loop will be
	//TODO: Handle action listeners here
	
	public Player() { // Atlas uses activities, do we want our player to have similar functionality?
		// TODO: Implement this class
	}
	
	public boolean onTouch() {
		return false;
	}
	
	public boolean onClick() {
		return false;
	}
	
	public boolean onKey() {
		return false;
	}

	@Override
	public void onPerformActionEvent(Action<Game> action, Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTickEvent(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartEvent(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEndEvent(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEvent(String event, Game game) {
		// TODO Auto-generated method stub
		
	}

}
