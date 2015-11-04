package cisc275.game.model.test;
import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import cisc275.game.model.Tile;
import cisc275.game.view.SpriteView;

public class TileTest {
	Point p1 = new Point(0,0);
	SpriteView s1 = new SpriteView();
	Tile testtile = new Tile(p1, s1);
	
	
	@Test
	public void test_Tile() {
		//test tile placement and rendering
		assertEquals(s1, testtile.getSprite());
		assertEquals(p1, testtile.getLocation());
	}

	@Test
	public void test_solid() {
		//test collision of tile functions properly
		assertTrue(testtile.solid());
	}

	@Test
	public void test_breakable() {
		//test breakable objects and their removal
		assertTrue(testtile.breakable());
	}

}
