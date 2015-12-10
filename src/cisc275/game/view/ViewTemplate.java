package cisc275.game.view;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

/**
 * @author Team 6
 * Used to scale all graphics based on window size
 */
public class ViewTemplate extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -721524182597281161L;
	private static final int SCALE = 1;
	static int TIMER_DELAY = 50;
	public static String title = "Estuary Defense";
	static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	static GraphicsDevice gs = ge.getDefaultScreenDevice();
	static DisplayMode dm = gs.getDisplayMode();
//	protected static int WORLD_WIDTH = dm.getWidth();;
//	protected static int WORLD_HEIGHT = dm.getHeight();
	protected static int WORLD_WIDTH = 1366;
	protected static int WORLD_HEIGHT = 768;
	static double regwidth=1366.0;
	static double regheight=768.0;
	static double widthscale = WORLD_WIDTH/regwidth;
	static double heightscale = WORLD_HEIGHT/regheight;
	
	/**
	 * @param p - size to scale
	 * @return scaled x based on window size
	 */
	static public int scalex(int p){
		return ((int)Math.round(p*ViewTemplate.widthscale));
	}
	/**
	 * @param p - size to scale
	 * @return scaled y based on window size
	 */
	static public int scaley(int p){
		return ((int)Math.round(p*ViewTemplate.heightscale));
	}
}


