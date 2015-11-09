package cisc275.game.view.test;
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

public class CrabView {
	static ArrayList<CrabView> crabs = new ArrayList<CrabView>();
	int picNum = 0;
    int picNums;
    boolean removel = false;
    static boolean side = true;
    final int frameCount = 8;
    BufferedImage[] pics;
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 8;
    final int yIncr = 2;
    final static int frameWidth = 1440;
    final static int frameHeight = 900;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
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
    		int j = rnd.nextInt(500)+1;
    		return(j);
    	}
    }
    public void paintcrab(JFrame frame) {
    	picNum = (picNum + 1) % frameCount;
    	randcount= rando(1);
    	int rand = 0;
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
         
         if (oneY >= 735 || rand == 3)
         {
             up = true;
             down = false;
         }
         
         if (oneY <= 0 || rand == 4)
         {
             up = false;
             down = true;
         }
         rand = 0;
         if (up) oneY-=yIncr;
         if (down) oneY+=yIncr;
         if (left) oneX-=xIncr;
         if (right) oneX+=xIncr;
         picNums = 0;
         if(up && left ){ //decides which part of the pic array to read depending on the direction
        	 picNums = picNum + 30;
         }
         if(up && right ){
        	 picNums = picNum + 20;
         }
         if(down && left ){
        	 picNums = picNum + 10;
         }
         if(down && right ){
        	 picNums = picNum;
         }
         frame.remove(cbutton);
         cbutton.setIcon(new ImageIcon(pics[picNums]));
         cbutton.setLocation(oneX, oneY);
         frame.add(cbutton);
    	//g.drawImage(pics[picNums], oneX, oneY, Color.gray, this);
    	
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
		//Be sure that animation picture direction matches what is happening on screen.
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
		cbutton.setSize(165, 165);
		BufferedImage[] img = createImage();
    	pics = new BufferedImage[80];
    	for(int i = 0; i < frameCount; i++){ //loads all subimages into array, separated by their type
    		pics[i] = img[0].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    		pics[i+10] = img[1].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    		pics[i+20] = img[2].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    		pics[i+30] = img[3].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    		pics[i+40] = img[4].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    		pics[i+50] = img[5].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    		pics[i+60] = img[6].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    		pics[i+70] = img[7].getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
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
	    		bufferedImage[0] = ImageIO.read(getClass().getResource("orc_animation/orc_jump_southeast.png"));
	    		bufferedImage[1] = ImageIO.read(getClass().getResource("orc_animation/orc_jump_southwest.png"));
	    		bufferedImage[2] = ImageIO.read(getClass().getResource("orc_animation/orc_jump_northeast.png"));
	    		bufferedImage[3] = ImageIO.read(getClass().getResource("orc_animation/orc_jump_northwest.png"));
	    		bufferedImage[4] = ImageIO.read(getClass().getResource("orc_animation/orc_jump_east.png"));
	    		bufferedImage[5] = ImageIO.read(getClass().getResource("orc_animation/orc_jump_west.png"));
	    		bufferedImage[6] = ImageIO.read(getClass().getResource("orc_animation/orc_jump_south.png"));
	    		bufferedImage[7] = ImageIO.read(getClass().getResource("orc_animation/orc_jump_north.png"));
	    		return bufferedImage;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	    	
	    	// TODO: Change this method so you can load other orc animation bitmaps
	    }
}
