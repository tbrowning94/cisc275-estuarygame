package cisc275.game.view;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GarbageCollectorView extends InstanceView{
	static BufferedImage[] pics;
    double xloc;
    double yloc;
    final static int scaledimgWidth = ViewTemplate.scalex(75);
    final static int scaledimgHeight = ViewTemplate.scaley(75);
    JLabel gcbutton = new JLabel("test");
	public static void InitializeGarbage() {
		pics = new BufferedImage[4];
   		pics[0] = createImage("images/Squirrel1.png");
		
	}
	public GarbageCollectorView(int num, Point location){
		//loci = location;
		gcbutton.setIcon(new ImageIcon(pics[0].getScaledInstance(ViewTemplate.scalex(75), ViewTemplate.scaley(75), Image.SCALE_DEFAULT)));;
        gcbutton.setLocation(location);
        gcbutton.setSize(scaledimgWidth, scaledimgHeight);
	}

}
