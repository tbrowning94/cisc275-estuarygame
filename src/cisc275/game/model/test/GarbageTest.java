package cisc275.game.model.test;
import static org.junit.Assert.*;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JLabel;

import org.junit.Test;
import cisc275.game.model.Crab;
import cisc275.game.model.Garbage;
import cisc275.game.model.GarbageCollector;

public class GarbageTest {
	@Test
	public void testSetLoc() {
		Garbage.InitializePicturesG();
		Point p1 = new Point(0, 0);
		Garbage tester = new Garbage(p1, 10, 1);
		Point p2 = new Point(0, 1);
		tester.setlocation(p2);
		assertEquals(p2, tester.getlocation());
	}
	@Test
	public void testSetdmg() {
		Garbage.InitializePicturesG();
		Point p1 = new Point(0, 0);
		Garbage tester = new Garbage(p1, 10, 1);
		int dmg = 20;
		tester.setDamage(dmg);
		assertEquals(dmg, tester.getDamage());
	}
	@Test
	public void testSetrm() {
		Garbage.InitializePicturesG();
		Point p1 = new Point(0, 0);
		Garbage tester = new Garbage(p1, 10, 1);
		boolean rm = true;
		tester.setRemoved(rm);
		assertEquals(rm, tester.getRemoved());
	}
	@Test
	public void testSetrank() {
		Garbage.InitializePicturesG();
		Point p1 = new Point(0, 0);
		Garbage tester = new Garbage(p1, 10, 1);
		int rank = 2;
		tester.setRanking(rank);
		assertEquals(rank, tester.getRanking());
	}
	@Test
	public void testSetbtn() {
		Garbage.InitializePicturesG();
		Point p1 = new Point(0, 0);
		Garbage tester = new Garbage(p1, 10, 1);
		JLabel newbtn = new JLabel("new");
		tester.setGbutton(newbtn);
		assertEquals(newbtn, tester.getGbutton());
	}
	
	@Test
	public void testCheckintersects() {
		Garbage.InitializePicturesG();
		Point p1 = new Point(0, 0);
		Garbage tester = new Garbage(p1, 10, 1);
		Garbage tester2 = new Garbage(p1, 10, 1);
		assertTrue(tester.checkintersects(tester2.getGbutton()));
	}
	@Test
	public void testgenerateTrash() {
		Garbage.InitializePicturesG();
		Point p1 = new Point(0, 0);
		ArrayList<Garbage> testG = Garbage.generateTrash(5);
		assertEquals(5, testG.size());
	}
	@Test
	public void testpaintgarbage() {
		Garbage.InitializePicturesG();
		Point p1 = new Point(0, 0);
		Garbage tester = new Garbage(p1, 10, 1);
		Point p2 = new Point(0, 1);
		tester.setlocation(p2); //only sets garbage location, not label
		tester.paintGarbage(); //updates label image and location
		assertEquals(p2, tester.getGbutton().getLocation());
	}
	
	@Test
	public void testtoString() {
		Garbage.InitializePicturesG();
		Point p1 = new Point(0, 0);
		Garbage tester = new Garbage(p1, 10, 1);
		assertEquals("[Garbage: location="+p1.toString()+"damage=10ranking=1]", tester.toString());
	}
}
