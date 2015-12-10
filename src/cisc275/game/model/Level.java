package cisc275.game.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JLabel;

import cisc275.game.view.CrabView;
import cisc275.game.view.GarbageCollectorView;
import cisc275.game.view.PlantView;
import cisc275.game.view.SplashScreen;
import cisc275.game.view.ViewTemplate;

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
	// we need to always have one fm separate from out list to track health
	private static Fisherman mainFM = new Fisherman(new Point(ViewTemplate.scalex(1200),ViewTemplate.scaley(700)),new Point (ViewTemplate.scalex(500),ViewTemplate.scaley(700)), 1);
	private static JLabel text = new JLabel();
	int defualtX = ViewTemplate.scalex(10); // Change these to move text location
	int defualtY = ViewTemplate.scalex(10);
	
	
	public Level(int lvl) {
		if(lvl == 0){
			generateTutorial();
		}
	}

	public void generateTutorial() {
		// stall game, set intro text, spawn one water and enable
		crabby = false;
		removeAll();
		text.setText("Place plants to stop water!");
		text.setLocation(new Point(ViewTemplate.scalex(10), ViewTemplate.scaley(10)));
		SplashScreen.getPanel2().add(text);
		mainFM.setMoney(10);
		SplashScreen.getPanel2().add(mainFM.getFLabel());
		waterTiles.add(new Water(new Point (ViewTemplate.scalex(575),ViewTemplate.scaley(210)), ViewTemplate.scaley(48), 5, Color.BLUE, 1.0));
		watercount += 1;
		SplashScreen.paintwater();
		crabby = true;
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
	
	public void removeAll() {
		crabs.removeAll(crabs);
		crabcount = 0;
		crabss.removeAll(crabss);
		plants.removeAll(plants);
		waterTiles.removeAll(waterTiles);
		watercount = 0;
		fms.removeAll(fms);
		garb.removeAll(garb);
		garbcount = 0;
		garbColl.removeAll(garbColl);
	}
}
