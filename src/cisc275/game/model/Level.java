package cisc275.game.model;

import java.util.ArrayList;

import cisc275.game.view.CrabView;
import cisc275.game.view.GarbageCollectorView;
import cisc275.game.view.PlantView;

public class Level {
	int deletenum = -1; //with use of crabs
	int deletenumWater = -1; // with water
	int deletenumFM = -1; // with fisherman
	int deletenumG = -1; // with garbage
	static ArrayList<Crab> crabs = new ArrayList<Crab>();//array of crabviews
	static ArrayList<CrabView> crabss = new ArrayList<CrabView>();
	static ArrayList<PlantView> plants = new ArrayList<PlantView>();
	static ArrayList<Water> waterTiles = new ArrayList<Water>();
	static ArrayList<Fisherman> fms = new ArrayList<Fisherman>();
	static ArrayList<Garbage> garb = new ArrayList<Garbage>();
	static ArrayList<GarbageCollectorView> garbColl = new ArrayList<GarbageCollectorView>();
	public static boolean crabby = false;
	boolean intersection = false;
	public int crabcount = 1;
	public int watercount = 1;
	public int garbcount = 1;
	
	public Level(int lvl) {
		if(lvl == 0){
			generateTutorial();
		}
	}

	public void generateTutorial() {
		// stall game, set intro text, spawn one water and enable
		// the player to place a plant
		// if they place it and decrease water size move to next state
		// stall game, explain buffers and water effect, allow player to place buffer
		// if water removed stall game, introduce crabs and spawn one mitten
		// make the crab move to the plant manually, when it stall plant, stall game
		// explain effect, allow player to remove
		// if crabcount = 0, spawn a native crab, explain that player can remove them for 
		// money, but if they remove too many the health goes down
		// if the player removes the crab again, remove all and reset
		// this time spawn garbage, explain the effect
		// introduce garbage collector and allow them to place one
		// if garbage is removed stall the game, remind the player
		// of fisherman, remove all and advance game state to level 1
		
	}
}
