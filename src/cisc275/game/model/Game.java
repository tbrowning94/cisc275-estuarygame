package cisc275.game.model;

import java.util.List;


public class Game { //need to figure out how to loop - do it in view

	//game constants
	public static final int WORLD_WIDTH = 0;
	public static final int WORLD_HEIGHT = 0;
	public static final int pH_START = 0;
	public static final long SPEED_START = 0;
	public static final int MONEY_START = 0;
	
	//current amount of money the player has
	int money;
	
	//current health of the estuary
	int ph;
	
	//Basic objects for the game
	Crab[] crabs;
	Plant[] plants;
	GarbageCollector[] GarbageCollectors;
	
	// # of milliseconds between state updates, probably will be 
	//important when we figure out how to loop game
	private long speed; 
	
	//number of rows and columns in the "world"
	private int rows;
	private int cols;
	
	//this level and the list of all possible levels
	private int level;
	private List<Level> levels;
	
	
	public Game(int money, int ph, Crab[] crabs, Plant[] plants, GarbageCollector[] garbageCollectors, long speed,
			int rows, int cols, int level, List<Level> levels) {
		
	}
	
	//not sure what this does
	void nodeSorter() {
	}
	
	
	public int getMoney() {
		return 0;
	}

	public void setMoney(int money) { 
		
	}

	public static int getPh() {
		return 0;
	}
	
	public static void IntoEstuary(){
		
	}
	
	public static void setHealth(Water RunoffParticles, Garbage damage, Game Ph){
		Game.IntoEstuary();
	}
	public void setPh(int ph) { 
		
	}

	public Crab[] getCrabs() {
		return null;
	}


	public Plant[] getPlants() {
		return null;
	}

	public GarbageCollector[] getGarbageCollectors() {
		return null;
	}

	
	public int getRows() {
		return 0;
	}

	public int getCols() {
		return 0;
	}

	//prints the current level, money, and pH
	public String getStatus() {
		return null; 
    }
	
	//I'm assuming this is like the onTick method in Atlas' game
	void update() {
	}
	
	//no idea what these two do
	void remove() {
	}
	void render() {
	}
	
	//checks if the game is in an ending state.
	//happens when the pH of the estaury is at a dangerous level (need to determine that number)
	boolean isEnd() {
		return false;
	}
	
	
	//if sewage has stopped and game is not ended advance to next level
	void nextlevel() {
	}
	
	//adds crabs to the level
	public void addRandomCrabs() {
		
	}
	
	//adds plant to level when player chooses
	public void addPlant() {
		
	}
	//sets the list of available levels
	void setLevel() {
	}
	
	public static void getLevel(){
		
	}
	
	
	//makes a default start game
	void startGame() {
	}
	
	//Runs Fisherman's fishing method then multiplies by number of fisherman
	int moneyFish() { 
		return 0;
	}
	
	//runs game
	public static void main(String[] args) { //move to view, windows are central thread of game
		
	}
}
