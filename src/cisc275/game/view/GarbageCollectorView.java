package cisc275.game.view;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Team 6
 * Handles view for garbage collectors, initializes images and sets label icons
 */
public class GarbageCollectorView extends InstanceView{
	static BufferedImage[] pics;
    final static int scaledimgWidth = ViewTemplate.scalex(75);
    final static int scaledimgHeight = ViewTemplate.scaley(75);
    JLabel gcbutton = new JLabel("gc");
    
	/**
	 * @param location - location for garbage collector label
	 * Set the label icon and position for garbage collector
	 */
	public GarbageCollectorView(Point location){
		gcbutton.setIcon(new ImageIcon(pics[0].getScaledInstance(ViewTemplate.scalex(75), ViewTemplate.scaley(75), Image.SCALE_DEFAULT)));;
        gcbutton.setLocation(location);
        gcbutton.setSize(scaledimgWidth, scaledimgHeight);
	}
	
	/**
	 * Initializes garbage collector images
	 */
	public static void InitializeGarbage() {
		pics = new BufferedImage[4];
   		pics[0] = createImage("images/Squirrel1.png");
	}
}
