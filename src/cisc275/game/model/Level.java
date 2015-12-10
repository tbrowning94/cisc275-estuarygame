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
	public int crabcount = 0;
	public int watercount = 1;
	public int garbcount = 0;
	
	public Level(int lvl) {
		if(lvl == 0){
			generateTutorial();
		}
	}

	public void generateTutorial() {
		
	}
}
