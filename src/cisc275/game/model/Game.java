package cisc275.game.model;

import java.util.List;


public class Game implements java.io.Serializable{ 

	//game constants
	public static final int pH_START = 0;
//	public static final long SPEED_START = 0;
	public static final int MONEY_START = 0;
	
	public static int nativelimit = 0;
	
	//current amount of money the player has
	int money;
	
	//current health of the estuary
	int pH;
	
	//Basic objects for the game
	Crab[] crabs;
	List<Plant> plants;
	GarbageCollector[] garbageCollectors;
	List<Garbage> garbs;
	List<Fisherman> fMen;
	List<Water> water;
	
	public Game() {
		
	}
	
	public Game(int money, int ph, Crab[] crabs, Plant[] plants, GarbageCollector[] garbageCollectors, long speed,
			int rows, int cols, int level) {
		
	}
	
	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) { 
		this.money = money;
	}

	public int getPh() {
		return pH;
	}
	
	/**
	 * Sees how much of the runoff and garbage crosses the estuary boarder and 
	 * contaminates the estuary using its location
	 */
	public static void IntoEstuary(List<Water> water, List<Garbage> garb){
		for (Water w:water) {
			//w.getLocation() <= was going to determine if each water at estuary but game doesn't have size attributes
		}
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
		return pH;
	}
	public int getHealthOfEstuary(){
		return pH;
	}
	
	public int getlevel() {// might not need this here, but removing it causes an error in water test
		return 0;
	}

	public Crab[] getCrabs() {
		return crabs;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public GarbageCollector[] getGarbageCollectors() {
		return garbageCollectors;
	}	
	
	/**
	 * checks if the game is in an ending state.
	 * happens when the pH of the estaury is at a dangerous level (need to determine that number)
	 * @return boolean value
	 */
	boolean isEnd() {
		return false;
	}
}
