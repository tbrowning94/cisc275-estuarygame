package cisc275.game.view;

import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cisc275.game.model.Water;

public class PlantView {
	//comment
	boolean buffer = false;
	static Image[] pics;
    double xloc;
    double yloc;
    Area plantarea;
    final static int scaledimgWidth = ViewTemplate.scalex(75);
    final static int scaledimgHeight = ViewTemplate.scaley(75);
    JLabel pbutton = new JLabel("test");
	public boolean intersecting = false;
	public static void InitializePictures() {
		pics = new BufferedImage[4];
   		pics[0] = createImage("images/Fern.png");
		pics[1] = createImage("images/Fern.png");
		pics[2] = createImage("images/Fern.png");
		pics[3] = createImage("images/Fern.png");
	}
	public PlantView(int num, Point location){
		//loci = location;
		pbutton.setIcon(new ImageIcon(pics[0].getScaledInstance(ViewTemplate.scalex(75), ViewTemplate.scaley(75), Image.SCALE_DEFAULT)));;
        pbutton.setLocation(location);
        pbutton.setSize(scaledimgWidth,scaledimgWidth);
        plantarea = new Area(pbutton.getBounds());
	}
	public boolean checkintersects(CrabView c){
		Area areaA = new Area(c.cbutton.getBounds());
//		System.out.println("CRAB "+areaA);
//		System.out.println("PLANT " +plantarea);
		return areaA.intersects(plantarea.getBounds2D());
	    
	}
	public void changepic(int i) {
		pbutton.setIcon(new ImageIcon(pics[i].getScaledInstance(ViewTemplate.scalex(75), ViewTemplate.scaley(75), Image.SCALE_DEFAULT)));;
		if(i == 3){
			pbutton.setSize(scaledimgWidth*2, scaledimgHeight*2);
		}
		// TODO Auto-generated method stub
		
	}
	public boolean checkintersectw(Water w) {
		Area areaA = new Area(w.getWaterButton().getBounds());
//		System.out.println("CRAB "+areaA);
//		System.out.println("PLANT " +plantarea);
		return areaA.intersects(plantarea.getBounds2D());
	}
	public boolean checkintersectp(PlantView p){
		Area areaA = new Area(p.pbutton.getBounds());
//		System.out.println("CRAB "+areaA);
//		System.out.println("PLANT " +plantarea);
		return areaA.intersects(plantarea.getBounds2D());
	}
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
	private static BufferedImage createImage(String file) {
        BufferedImage bufferedImage;
        try {
        	bufferedImage=ImageIO.read(new File(file));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}