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

public class CrabView {
	static ArrayList<CrabView> crabs = new ArrayList<CrabView>();
	Image ing;
	int picNum = 1;
    int picNums;
    boolean removel = false;
    static boolean side = true;
    final int frameCount = 8;
    static Image[] pics;
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 8;
    final int yIncr = 2;
    final static int frameWidth = 1440;
    final static int frameHeight = 900;
    final static int imgWidth = 315;
    final static int imgHeight = 230;
    private int oneX = 7;
    private int oneY = 7;
    int randcount = 0;
    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;
    JLabel cbutton = new JLabel("test");

    Image current;
    public int rando(int l){
    	Random rnd = new Random();
    	if(l == 1){
    		return(rnd.nextInt(8)+1);
    	}
    	else if(l == 2){
    		return(rnd.nextInt(4)+1);
    	}
    	else{
    		int j = rnd.nextInt(269)+358;
    		return(j);
    	}
    }
    
    public void paintcrab() {
    	//picNum = (picNum + 1) % frameCount;
    	//System.out.println(picNum);
    	if(picNum == 1 || picNum == 2){
    		picNum++;
    		ing = pics[0];
    	}
    	else if(picNum == 3){
    		picNum++;
    		ing = pics[1];
    	}
    	else{
    		picNum = 1;
    	}
    	
    	randcount= rando(1);
    	int rand = 0;
    	//System.out.println(cbutton);
    	if(randcount == 1){
    		randcount = 0;
    		rand = rando(2);
    	}
    	 if (oneX >= 1275 || rand == 1)
         {
             right = false;
             left = true;
         }
         
         if (oneX <= 0 || rand == 2)
         {
             right = true;
             left = false;
         }
         
         if (oneY >=  627 || rand == 3)
         {
             up = true;
             down = false;
         }
         
         if (oneY <= 358  || rand == 4)
         {
             up = false;
             down = true;
         }
         rand = 0;
         if (up) oneY-=yIncr;
         if (down) oneY+=yIncr;
         if (left) oneX-=xIncr;
         if (right) oneX+=xIncr;
//         picNums = 0;
//         if(up && left ){ //decides which part of the pic array to read depending on the direction
//        	 picNums = picNum + 30;
//         }
//         if(up && right ){
//        	 picNums = picNum + 20;
//         }
//         if(down && left ){
//        	 picNums = picNum + 10;
//         }
//         if(down && right ){
//        	 picNums = picNum;
//         }
         //System.out.println(panel);
        // panel.remove(cbutton);
         cbutton.setIcon(new ImageIcon(ing));
         cbutton.setLocation(oneX, oneY);
        // panel.add(cbutton);
         
        // g.drawImage(pics[picNums], oneX, oneY, Color.gray, panel);
    	
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
		//Be sure that animation picture direction matches what is happening on screen.
    }

    public CrabView(boolean b){
    	crabs.add(this);
		oneY = rando(3);
		if(side == true){
			side = false;
			oneX = 1275;
		}
		else{
			side = true;
		}
		cbutton.setSize(79, 57);
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
	public CrabView() {
		
		crabs.add(this);
		oneY = rando(3);
		if(side == true){
			side = false;
			oneX = 1275;
		}
		else{
			side = true;
		}
		cbutton.setSize(79, 57);
    	pics = new Image[2];
    	 //loads all subimages into array, separated by their type
    		
    		//pics[i] = pics[i].getScaledInstance(82, 82, Image.SCALE_DEFAULT);
    		try {
    			pics[0] = ImageIO.read(getClass().getResource("crabby.png")).getScaledInstance(79, 57, Image.SCALE_DEFAULT);
    			pics[1] = ImageIO.read(getClass().getResource("crab1.png")).getScaledInstance(79, 57, Image.SCALE_DEFAULT);
    			//System.out.println(pics[1]+ "crab1");
    			//System.out.println(pics[0]+ "crab2");
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
	 private BufferedImage[] createImage(){
	    	BufferedImage[] bufferedImage = new BufferedImage[8];
	    	try {
	    		bufferedImage[0] = ImageIO.read(getClass().getResource("orc_jump_southeast.png"));
	    		bufferedImage[1] = ImageIO.read(getClass().getResource("orc_jump_southwest.png"));
	    		bufferedImage[2] = ImageIO.read(getClass().getResource("orc_jump_northeast.png"));
	    		bufferedImage[3] = ImageIO.read(getClass().getResource("orc_jump_northwest.png"));
	    		bufferedImage[4] = ImageIO.read(getClass().getResource("orc_jump_east.png"));
	    		bufferedImage[5] = ImageIO.read(getClass().getResource("orc_jump_west.png"));
	    		bufferedImage[6] = ImageIO.read(getClass().getResource("orc_jump_south.png"));
	    		bufferedImage[7] = ImageIO.read(getClass().getResource("orc_jump_north.png"));
	    		return bufferedImage;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	    	
	    	// TODO: Change this method so you can load other orc animation bitmaps
	    }
}
