package cisc275.game.view;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import cisc275.game.model.Water;

/**
 * PlantView created plant labels and checks their position and if a buffer is created
 * buffer is if three plants are next to each other, which stops water
 * plantarea is where the size of the area the plant is effective on absorbing water
 * intersecting is a boolean telling if a mitten crab is touching the plant or not and causing damage to it
 *
 */
public class PlantView extends InstanceView {
	boolean buffer = false;
	static BufferedImage[] pics;
    double xloc;
    double yloc;
    Area plantarea;
    final static int scaledimgWidth = ViewTemplate.scalex(75);
    final static int scaledimgHeight = ViewTemplate.scaley(75);
    JLabel pbutton = new JLabel("test");
	public boolean intersecting = false;
	
	/**
	 * @param num
	 * @param location
	 * setsimages to the plant labels, scales the images to the label size, and sets the area of 
	 * effectiveness of the plant
	 */
	public PlantView(int num, Point location){
		//loci = location;
		pbutton.setIcon(new ImageIcon(pics[0].getScaledInstance(ViewTemplate.scalex(75), ViewTemplate.scaley(75), Image.SCALE_DEFAULT)));;
        pbutton.setLocation(location);
        pbutton.setSize(scaledimgWidth,scaledimgWidth);
        plantarea = new Area(pbutton.getBounds());
	}
	/**
	 * InitializePictures calls create image and loads image strings into the list pics
	 */
	public static void InitializePictures() {
		pics = new BufferedImage[4];
   		pics[0] = createImage("images/Fern.png");
		pics[1] = createImage("images/Fern.png");
		pics[2] = createImage("images/Fernhurt.png");
		pics[3] = createImage("images/Fern.png");
	}
	public JLabel createPlantLabel(Point loc) {
    	BufferedImage plant = pics[0];
    	ImageIcon plantIcon = new ImageIcon(plant.getScaledInstance(100, 100, 20));
    	JLabel newPlant = new JLabel("plant");
    	newPlant.setIcon(plantIcon);
    	newPlant.setLocation(loc);
    	newPlant.setSize(75,75);
    	return newPlant;
    }
	/**
	 * @param CrabView
	 * @return boolean
	 * checks if a crab and plants label bounds are intersecting
	 */
	public boolean checkintersects(JLabel jLabel){
		Area areaA = new Area(jLabel.getBounds());
//		System.out.println("CRAB "+areaA);
//		System.out.println("PLANT " +plantarea);
		return areaA.intersects(plantarea.getBounds2D());
	    
	}
	/**
	 * @param int
	 * sets the size of the new plant label, and the image that will go on it
	 */
	public void changepic(int i) {
		pbutton.setIcon(new ImageIcon(pics[i].getScaledInstance(ViewTemplate.scalex(75), ViewTemplate.scaley(75), Image.SCALE_DEFAULT)));;
		if(i == 3){
			pbutton.setSize(scaledimgWidth*2, scaledimgHeight*2);
		}
		// TODO Auto-generated method stub
		
	}
	/**
	 * @param water
	 * @return boolean
	 * checks if a plants boundary is intersecting a water labels boundary, returns true or false
	 */
	public boolean checkintersectw(Water w) {
		Area areaA = new Area(w.getWbutton().getBounds());
//		System.out.println("CRAB "+areaA);
//		System.out.println("PLANT " +plantarea);
		return areaA.intersects(plantarea.getBounds2D());
	}
	/**
	 * @param p
	 * @return boolean
	 * checks if two plants are next to each other through comparing the bounds
	 * of each
	 */
	public boolean checkintersectp(PlantView p){
		Area areaA = new Area(p.pbutton.getBounds());
//		System.out.println("CRAB "+areaA);
//		System.out.println("PLANT " +plantarea);
		return areaA.intersects(plantarea.getBounds2D());
	}
	/**
	 * @param plantview
	 * checks if three plants are placed next to each other by calling checkintersectp(),
	 * if three plant are placed in a row buffer is set to true 
	 */
	public static void checkbuffer(PlantView pl){
		 ArrayList<PlantView> tempp = new ArrayList<PlantView>();
		for(PlantView p: SplashScreen.plants){
			if(p != pl){
				if(pl.checkintersectp(p)){
					tempp.add(p);
				}
			}
		}
		if(tempp.size() == 2){
			for(PlantView q: tempp){
				SplashScreen.plants.remove(q);
				SplashScreen.getPanel2().remove(q.pbutton);
			}
			pl.changepic(3);
			pl.pbutton.setIcon(new ImageIcon(pics[1].getScaledInstance(ViewTemplate.scalex(150), ViewTemplate.scaley(150), Image.SCALE_DEFAULT)));;
			pl.buffer = true;
		}
	}

}