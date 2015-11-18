package crabview;
//T Harvey  *modified by Ryan Boucher
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm
 
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
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
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
public class Animation2 extends JFrame {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
    static ArrayList<CrabView> crabs = new ArrayList<CrabView>();
    final static int frameWidth = 1366;
    final static int frameHeight = 768;
    int deletenum = -1;
    static int TIMER_DELAY = 50;
    public static int rando(){
    	Random rnd = new Random();
    	return(rnd.nextInt(100));
    }
    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paintc() {
    	int i = 0;
    	System.out.println("test2 " + i);
		i++;
    	for(CrabView c: crabs){
    		if(c.removel == true){ //checks if crab needs to be removed
    			deletenum = crabs.indexOf(c);
    		}
    		c.paintcrab();
    		panel.remove(c.cbutton);
    		panel.add(c.cbutton);
    		
    	}
    	if(deletenum != -1){ //removes crab
    		panel.remove(crabs.get(deletenum).cbutton);
    		crabs.remove(deletenum);
    		deletenum = -1;
    	}
    	System.out.println("test5");
    }
    
    //Make frame, loop on repaint and wait
    public static void main(String[] args) {
    	crabs.add(new CrabView());
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Animation2();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
//    	cbutton.addActionListener(new ActionListener() {
//    		public void actionPerformed(ActionEvent e) {
//    			 JOptionPane.showMessageDialog(null, "Test");
//    		}
//    	});
//    	for(int i = 0; i < 10000; i++){
//    		frame.repaint();
//    		if(rando() == 1){ //randomly makes a crab (1/50 chance)
//    		crabs.add(new CrabView(true));
//    		}
//    		try {
//    			Thread.sleep(50);
//    		} catch (InterruptedException e) {
//    			e.printStackTrace();
//    		}
//    	}
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {
        	System.out.println("test");
           paintc();
           System.out.println("test6");
//           for(CrabView c: crabs){
//        	   frame.remove(c.cbutton);
//       	}
           if(rando() == 1){ //randomly makes a crab (1/50 chance)
       		crabs.add(new CrabView(true));
       		}
        };
     }
    //Constructor: get image, segment and store in array
    public Animation2() throws Exception{
    	panel = new JPanel(null);
        panel.setBackground(Color.YELLOW);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        setSize(frameWidth, frameHeight);
        setLocationByPlatform(true);
        setVisible(true);
       // panel.add(crabs.get(0).cbutton);
    	new Timer(TIMER_DELAY, new TimerListener()).start();
    }
}