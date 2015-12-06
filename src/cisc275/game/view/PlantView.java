package cisc275.game.view;

import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Area;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cisc275.game.model.Water;

public class PlantView {
	boolean buffer = false;
	static Image[] pics;
    double xloc;
    double yloc;
    Area plantarea;
    final static int scaledimgWidth = ViewTemplate.scalex(75);
    final static int scaledimgHeight = ViewTemplate.scaley(75);
    JLabel pbutton = new JLabel("test");
	public boolean intersecting = false;
	public PlantView() {
		pics = new Image[4];
   		try {
   			pics[0] = ImageIO.read(getClass().getResource("Fern.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
   			pics[1] = ImageIO.read(getClass().getResource("Fern.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
   			pics[2] = ImageIO.read(getClass().getResource("Fernhurt.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
   			pics[3] = ImageIO.read(getClass().getResource("Fern.png")).getScaledInstance(scaledimgWidth*2, scaledimgHeight*2, Image.SCALE_DEFAULT);
   		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	public PlantView(int num, Point location){
		//loci = location;
		pbutton.setIcon(new ImageIcon(pics[num]));
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
		pbutton.setIcon(new ImageIcon(pics[i]));
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
			pl.buffer = true;
		}
	}
}
