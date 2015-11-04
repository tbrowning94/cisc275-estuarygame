package cisc275.game.model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import cisc275.game.model.GarbageCollector;
import cisc275.game.model.GarbageCollector1;

public class RandomMoverTest {

	/**
	 * tests if g successfully, randomly moved to a space 1 away from its current location
	 */
	@Test
	
	public void test() {
		Point point1 = new Point(1,1);
		GarbageCollector1 g = new GarbageCollector1(point1);
		g.moveRandomly();
		assertEquals(true, checkcoords(point1, g));
		
	}
	
	/**
	 * @param p1 
	 * @param gg
	 * @return true if p1 and gg's location are within one space of each other
	 */
	public boolean checkcoords(Point p1, GarbageCollector1 gg){
		Point p2 = gg.getLocation();
		if(p2.getX()-1 == p1.getX()&&p2.getY()==p1.getY()){
			return true;
		}
		else if(p2.getX()+1 == p1.getX()&&p2.getY()==p1.getY()){
			return true;
		}
		else if(p2.getX() == p1.getX()&&p2.getY()+1==p1.getY()){
			return true;
		}
		else if(p2.getX() == p1.getX()&&p2.getY()-1==p1.getY()){
			return true;
		}
		else{
			return false;
		}
	}
}
