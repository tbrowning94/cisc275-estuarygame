package cisc275.game.view;
import java.awt.Image;

import cisc275.game.controller.Action;
import cisc275.game.controller.GameListener;
import cisc275.game.model.Game;

public class GameView implements GameListener<Game>{
	Image crab;
	Image mcrab;
	Image garbage;
	Image plant;
	Image garbageCollector;
	public GameView() {
		// TODO Auto-generated constructor stub
	}
	void InitializeBoardsize() {
	}
	void drawCrabs() {
	}
	void drawGarbage() {
	}
	void drawPlants() {
	}
	void drawGarbageCollectors() {
	}
	void drawHills() {
	}
	void drawWater() {
	}
	void drawHealthBar() {
	}
	void drawMoneyBar() {
	}
	void playSound() {
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

	//runs game
	public static void main(String[] args) { //move to view, windows are central thread of game
			
	}
}
