//package cisc275.game.model.test;
//
//import static org.junit.Assert.*;
//
//import java.awt.Point;
//
//import org.junit.Test;
//
//import cisc275.game.model.Crab;
//import cisc275.game.model.Garbage;
//import cisc275.game.model.GarbageCollector;
//
//public class GarbageTest {
//	Garbage tester = new Garbage(1);
//	@Test
//	public void getdirection() {
//		tester.setdirection(1);
//		assertEquals(1, tester.getdirection());
//	}
//	@Test
//	public void getlocation(){
//		Point j = new Point();
//		tester.setlocation(j);
//		assertEquals(j, tester.getlocation());
//	}
//	@Test
//	public void test(){
//		Garbage j = new Garbage(1);
//		Point point1 = new Point(1,1);
//		GarbageCollector k = new GarbageCollector(point1);
//		j.setlocation(point1);
//		j.checkcollector();
//		assertEquals(1,k.getCurrGarb());
//	}
//}
