package cisc275.game.model;

import java.util.List;


public class Game implements java.io.Serializable{ //need to figure out how to loop - do it in view

	//game constants
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
	
	public Game() {
		
	}
	
	public Game(int money, int ph, Crab[] crabs, Plant[] plants, GarbageCollector[] garbageCollectors, long speed,
			int rows, int cols, int level) {
		
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
	
	/**
	 * Sees how much of the runoff and garbage crosses the estuary boarder and 
	 * contaminates the estuary using its location
	 */
	public static void IntoEstuary(Water location, Garbage loc){
		
	}
	
	/**
	 * uses the result from IntoEstuary to then set what the 
	 * health of the estuary is
	 * and ph defines the health, 7 is the best, ph lowers
	 * as more particle filled runoff and garbage enters it
	 * @return ph
	 */
	public int setHealthOfEstuary(Water health){
		IntoEstuary(null, null);
		return ph;
	}
	public int getHealthOfEstuary(){
		return ph;
	}
	
	public int getlevel() {// might not need this here, but removing it causes an error in water test
		return 0;
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
	
	/**
	 * checks if the game is in an ending state.
	 * happens when the pH of the estaury is at a dangerous level (need to determine that number)
	 * @return boolean value
	 */
	boolean isEnd() {
		return false;
	}
	
	//adds crabs to the level
	public void addRandomCrabs() {
		
	}
	
	//adds plant to level when player chooses
	public void addPlant() {
		
	}
	
	//Runs Fisherman's fishing method then multiplies by number of fisherman
	int moneyFish() { 
		return 0;
	}
}
