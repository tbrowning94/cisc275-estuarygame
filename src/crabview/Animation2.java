package crabview;
//T Harvey  *modified by Ryan Boucher
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Animation2 extends JPanel {
	static JFrame frame = new JFrame();
    static ArrayList<CrabView> crabs = new ArrayList<CrabView>();
    final static int frameWidth = 1440;
    final static int frameHeight = 900;
    int deletenum = -1;
    public static int rando(){
    	Random rnd = new Random();
    	return(rnd.nextInt(100));
    }
    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paint(Graphics g) {
    	for(CrabView c: crabs){
    		if(c.removel == true){
    			deletenum = crabs.indexOf(c);
    		}
    		c.paintcrab(frame);
    	}
    	if(deletenum != -1){
    		frame.remove(crabs.get(deletenum).cbutton);
    		crabs.remove(deletenum);
    		deletenum = -1;
    	}
    }

    //Make frame, loop on repaint and wait
    public static void main(String[] args) {
    	frame.getContentPane().add(new Animation2());
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	crabs.add(new CrabView());
    	frame.setVisible(true);
    	frame.setLayout(null);
//    	cbutton.addActionListener(new ActionListener() {
//    		public void actionPerformed(ActionEvent e) {
//    			 JOptionPane.showMessageDialog(null, "Test");
//    		}
//    	});
    	for(int i = 0; i < 10000; i++){
    		frame.repaint();
    		if(rando() == 1){
    		crabs.add(new CrabView(true));
    		}
    		try {
    			Thread.sleep(30);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
   
    //Constructor: get image, segment and store in array
    public Animation2(){
    }
}