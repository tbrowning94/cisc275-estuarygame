package cisc275.game.model.test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import cisc275.game.model.Crab;
import cisc275.game.model.Mob;
import cisc275.game.model.Plant;

public class MobTest {

	@Test
	public void test() { 
		//tests if checkProximity correctly creates
		//a list of mobs in the proximity of plant
		Point point1 = new Point(1,1);
		Point point2 = new Point(0,0);
		Plant p = new Plant(point1);
		Crab c = new Crab(true, point2);
		c.setlocation(point2);
		ArrayList<Mob> mobs = new ArrayList<Mob>();
		mobs.add(c);
		//assertEquals(mobs,Plant.checkProximity(Crab.getCrabs()));
	}
	public void test2(){
		//makes sure checkProximity did not find anything
		Point point1 = new Point(13,13);
		Point point2 = new Point(0,0);
		Plant p = new Plant(point1);
		Crab c = new Crab(true, point2);
		c.setlocation(point2);
		ArrayList<Mob> mobs = new ArrayList<Mob>();
		//assertEquals(mobs,Plant.checkProximity(Crab.getCrabs()));
	}
	}
