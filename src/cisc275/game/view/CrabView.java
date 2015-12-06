package cisc275.game.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cisc275.game.model.Crab;
import cisc275.game.view.ViewTemplate;
public class CrabView {
//	boolean stop = false; //model
//	boolean mitten; //model
	static int nativelimit; //model (game)
	Image ing; //view
	int picNum = 1; //view
    int picNums; //view
    boolean removel = false;
    static boolean side = true;
    final int frameCount = 8; //view
    static Image[] pics; //view
//    int xloc = 0; //model
//    int yloc = 0; //model
    //both model and view. Controller will need to translate between the two. 
//    int upxbound = ViewTemplate.scalex(1275);
//    int upybound = ViewTemplate.scalex(627);
//    int downxbound = ViewTemplate.scalex(0);
//    int downybound = ViewTemplate.scalex(358);
//    final int xIncr = ViewTemplate.scalex(8);
//    final int yIncr = ViewTemplate.scaley(2);
    final static int frameWidth = 1440; //view
    final static int frameHeight = 900; //view
    final static int imgWidth = 315; //view
    final static int imgHeight = 230; //view
    final static int scaledimgWidth = ViewTemplate.scalex(79); //view
    final static int scaledimgHeight = ViewTemplate.scaley(57); //view
//    private int oneX = 7;
//    private int oneY = 7;
//    int randcount = 0;
//    boolean up = false; //model
//    boolean down = true; //model
//    boolean left = false; //model
//    boolean right = true; //model
    JLabel cbutton = new JLabel("test");

    Image current;
	public PlantView planta;
	
	
//    /**
//     * Move to model
//     * 
//     * Method controlling all random actions for crabs (mitten or native, y-axis spawn
//     * location, direction change) 
//     * @param l
//     * @return int
//     */
//    public int rando(int l){
//    	Random rnd = new Random();
//    	if(l == 1){ //1 in 8 chance of randomly changing direction
//    		return(rnd.nextInt(8)+1);
//    	}
//    	else if(l == 2){ //determines which direction it moves
//    		return(rnd.nextInt(4)+1);
//    	}
//    	else if(l == 5){ //1 in four chance of making a mitten crab
//    		System.out.print(rnd.nextInt(1));
//    		return(rnd.nextInt(4));
//    	}
//    	else{ //where on the y axis crab spawns
//    		int j = rnd.nextInt(ViewTemplate.scalex(269))+ViewTemplate.scalex(358);
//    		return(j);
//    	}
//    	
//    }
    
    /**
     * Determines the image that should be drawn to create animation
     */
    public void paintcrab(Crab crab) {
    	if(picNum == 1 || picNum == 2){
    		picNum++;
    		if(crab.isMitten() ==true){
    			ing = pics[0];
    		}
    		else{
    			ing = pics[3];
    		}
    	}
    	else if(picNum == 3){
    		picNum++;
    		if(crab.isMitten()==true){
    			ing = pics[1];
    		}
    		else{
    			ing = pics[2];
    		}
    	}
    	else{
    		picNum = 1;
    	}
    	//changes location if not attached to a plant (needs to be made it's own method in model)
//    	if(!stop){
//    		randcount= rando(1);
//        	int rand = 0;       	
//        	if(randcount == 1){
//        		randcount = 0;
//        		rand = rando(2);
//        	}
//        	 if (oneX >= upxbound || rand == 1)
//             {
//                 right = false;
//                 left = true;
//             }
//             
//             if (oneX <= downxbound || rand == 2)
//             {
//                 right = true;
//                 left = false;
//             }
//             
//             if (oneY >=  upybound || rand == 3)
//             {
//                 up = true;
//                 down = false;
//             }
//             
//             if (oneY <= downybound  || rand == 4)
//             {
//                 up = false;
//                 down = true;
//             }
//             rand = 0;
//             if (up) oneY-=yIncr;
//             if (down) oneY+=yIncr;
//             if (left) oneX-=xIncr;
//             if (right) oneX+=xIncr;
//    	}
    	//this stays in view
         cbutton.setIcon(new ImageIcon(ing));
         cbutton.setLocation(crab.getXloc(), crab.getYloc());
    }

    public CrabView(boolean b){
    	//this should be in model and replaced with something that checks mitten attribute from model crab
//    	if(rando(5)== 1){
//    		mitten = false;
//    	}
//    	else{
//    		mitten = true;
//    	}
//    	crabs.add(this); //should add to list in game
//		oneY = rando(3);
//		if(side == true){
//			side = false;
//			oneX = ViewTemplate.scalex(1275);
//		}
//		else{
//			side = true;
//		}
		
		//i think everything below this should be view
		cbutton.setSize(scaledimgWidth, scaledimgHeight);
		cbutton.addMouseListener(new MouseAdapter()  
    	{  
    	    public void mouseClicked(MouseEvent e)  
    	    {  
    	       // you can open a new frame here as
    	       // i have assumed you have declared "frame" as instance variable
    	    	
    	    			removel = true;
    	    			System.out.println(nativelimit);
    	    	}  
    	}); 
		
    }
	public CrabView() {
		
//		//this is model
//		oneY = rando(3);
//		if(side == true){
//			side = false;
//			oneX = 1275;
//		}
//		else{
//			side = true;
//		}
		//this is view
		cbutton.setSize(scaledimgWidth, scaledimgHeight);
    	pics = new Image[4];
    	 //loads all subimages into array, separated by their type
    
    		try {
    			pics[0] = ImageIO.read(getClass().getResource("crabby.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
    			pics[1] = ImageIO.read(getClass().getResource("crab1.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
    			pics[2] = ImageIO.read(getClass().getResource("crab3.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
    			pics[3] = ImageIO.read(getClass().getResource("crab4.png")).getScaledInstance(scaledimgWidth, scaledimgHeight, Image.SCALE_DEFAULT);
    		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    	cbutton.addMouseListener(new MouseAdapter()  
    	{  
    	    public void mouseClicked(MouseEvent e)  
    	    {  
    	       // you can open a new frame here as
    	       // i have assumed you have declared "frame" as instance variable
    	    	//JOptionPane.showMessageDialog(null, "You Win");
    	    	removel = true;
    	    }  
    	}); 
	}
 
	 /**
	 * Handles direction change during collision with plant. Should be moved to model.
	 */
//	public void setrandom(){
//		 int rand = rando(2);
//		 if (rand == 1)
//         {
//             right = false;
//             left = true;
//         }
//         
//         if (rand == 2)
//         {
//             right = true;
//             left = false;
//         }
//         
//         if (rand == 3)
//         {
//             up = true;
//             down = false;
//         }
//         
//         if (rand == 4)
//         {
//             up = false;
//             down = true;
//         }
//	 }
}
