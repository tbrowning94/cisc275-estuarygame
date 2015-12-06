package cisc275.game.view;

import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GarbageCollectorView extends InstanceView{
	static Image[] pics;
    double xloc;
    double yloc;
    final static int scaledimgWidth = ViewTemplate.scalex(75);
    final static int scaledimgHeight = ViewTemplate.scaley(75);
    JLabel gcbutton = new JLabel("test");
	public GarbageCollectorView() {
		pics = new Image[4];
   	 //loads all subimages into array, separated by their type
   		
   		//pics[i] = pics[i].getScaledInstance(82, 82, Image.SCALE_DEFAULT);
   		try {
   			pics[0] = ImageIO.read(getClass().getResource("Squirrel1.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
   			pics[1] = ImageIO.read(getClass().getResource("Squirrel1.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
   			pics[2] = ImageIO.read(getClass().getResource("Squirrel1.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
   			pics[3] = ImageIO.read(getClass().getResource("Squirrel1.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
   			//System.out.println(pics[1]+ "crab1");
   			//System.out.println(pics[0]+ "crab2");
   		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	public GarbageCollectorView(int num, Point location){
		//loci = location;
		gcbutton.setIcon(new ImageIcon(pics[num]));
        gcbutton.setLocation(location);
        gcbutton.setSize(scaledimgWidth, scaledimgHeight);
	}

}
