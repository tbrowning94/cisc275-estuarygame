package cisc275.game.view;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Team 6
 * Handles view for garbage collectors, initializes images and sets label icons
 */
public class GarbageCollectorView extends InstanceView{
	static ImageIcon[] pics = new ImageIcon[4];
	static int upxbound = ViewTemplate.scalex(1306);
    static int upybound = ViewTemplate.scalex(580);
    static int downxbound = ViewTemplate.scalex(20);
    static int downybound = ViewTemplate.scalex(270);
    static BufferedImage front;
    final int xIncr = 8;
    final int yIncr = 2;
    boolean up = false; //model
    boolean down = true; //model
    boolean left = false; //model
    boolean right = true; //model
    int randcount = 0;
    int picNum = 0;
    ImageIcon ing;
    final static int scaledimgWidth = ViewTemplate.scalex(75);
    final static int scaledimgHeight = ViewTemplate.scaley(75);
    JLabel gcbutton = new JLabel("gc");
    
	/**
	 * @param location - location for garbage collector label
	 * Set the label icon and position for garbage collector
	 */
	public GarbageCollectorView(Point location){
		gcbutton.setIcon(pics[0]);
        gcbutton.setLocation(location);
        gcbutton.setSize(scaledimgWidth, scaledimgHeight);
	}
	
	/**
     * If rando determines that the crab should change directions it determines the new
     * random direction
     */
    public void move() {
    		randcount= grndxdir(1);
        	int rand = 0;       	
        	if(randcount == 1){
        		randcount = 0;
        		rand = grndxdir(2);
        	}
        	 if (gcbutton.getX() >= upxbound || rand == 1)
             {
                 right = false;
                 left = true;
             }
             
             if (gcbutton.getX() <= downxbound || rand == 2)
             {
                 right = true;
                 left = false;
             }
             rand = 0;
             if(picNum == 1 || picNum == 2){
         		picNum++;
         		if(right==true){
         			ing = pics[3];
         		}
         		else{
         			ing = pics[0];
         		}
         	}
         	else if(picNum == 3){
         		picNum++;
         		if(right==true){
         			ing = pics[2];
         		}
         		else{
         			ing = pics[1];
         		}
         	}
         	else{
         		picNum = 1;
         	}
            gcbutton.setIcon(ing);
             if (left) gcbutton.setLocation(gcbutton.getX()-xIncr, gcbutton.getY());
             if (right) gcbutton.setLocation(gcbutton.getX()+xIncr, gcbutton.getY());
    }
    
    /**
     * 
     * Method controlling all random actions for crabs (mitten or native, y-axis spawn
     * location, direction change) 
     * @param l
     * @return int
     */
    public int grndxdir(int l){
    	Random rnd = new Random();
    	if(l == 1){ //1 in 8 chance of randomly changing direction
    		return(rnd.nextInt(8)+1);
    	}
    	else { //determines which direction it moves(l=2)
    		return(rnd.nextInt(4)+1);
    	}
    }
  
	/**
	 * Initializes garbage collector images
	 */
	public static void InitializeGarbage() {
		BufferedImage picss[] = new BufferedImage[4];
   		picss[0] = createImage("images/trashman1.png");
   		picss[1] = createImage("images/trashman2.png");
   		picss[2] = createImage("images/trashman3.png");
   		picss[3] = createImage("images/trashman4.png");
   		front = picss[0];
   		pics[0] = new ImageIcon(picss[0].getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT));
		pics[1] = new ImageIcon(picss[1].getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT));
		pics[2] = new ImageIcon(picss[2].getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT));
		pics[3] = new ImageIcon(picss[3].getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT));
	}
}
