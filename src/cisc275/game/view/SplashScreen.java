package cisc275.game.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import cisc275.game.controller.PlaceObject;
import cisc275.game.model.Plant;

public class SplashScreen extends JFrame implements ActionListener, MouseListener{
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	private JPanel panel2;
	int deletenum = -1; //with use of crabs
	 static ArrayList<CrabView> crabs = new ArrayList<CrabView>();//array of crabviews
	public static boolean crabby = true;
	Button startGame;
	Button instructions;
	Image splashimage;
	int numpics = 10;
	private JButton pbutton, gcbutton;
    int imgHeight;
    int imgWidth;
    
	private BufferedImage pics[];
    
	private enum click {
		plant1, plant2, plant3, gC1, gC2, gC3, norm
	}
	
	private click isClicked = click.norm;
	
	private File file;
	
	public SplashScreen() {
		pics = new BufferedImage[numpics];
    	BufferedImage bi = createImage("images/BackImg1.jpg");
    	BufferedImage plant1 = createImage("images/Grass.png");
    	BufferedImage GarbCol = createImage("images/Squirrel/Squirrel1.png");
    	System.out.print("PrintPics");
    	pics[0] = bi;
    	pics[1] = plant1;
    	pics[2] = GarbCol;
    	  	
     	//for(int i = 0; i < pics.size(); i++)
    		//pics.get(i).getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
     	
     	this.panel2 = GameFrame();
		
		
	}

	void initialize() {
	}
	void onClick() {
	}
	void inValidate() {
	}
	
	public JPanel getPanel2() {
		return this.panel2;
	}
	
	public JButton getPButton() {
		return this.pbutton;
	}
	
	public JButton getGCButton() {
		return this.gcbutton;
	}

	   private BufferedImage createImage(String file) {
	        BufferedImage bufferedImage;
	        try {
	        	bufferedImage=ImageIO.read(new File(file));
	            return bufferedImage;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	public JPanel GameFrame(){
        panel2 = new JPanel() {
        	
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(pics[0], 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
            }
        };
        panel2.addMouseListener(new MouseAdapter() {
            private Color background;

            @Override
            public void mouseClicked(MouseEvent e) {
            	Point loc = new Point(e.getX(), e.getY()); //e.getLocationOnScreen();
        		
            	switch (isClicked) {
            	case norm:
            		System.out.println(loc);
            		break;
            	case plant1:
        			paintPlantComponent(e.getComponent().getGraphics(), loc);
        			getPButton().setBorderPainted(false);
        			crabby = true;
        			isClicked = click.norm;
        			break;
        		
        		case plant2:
        			paintPlantComponent(e.getComponent().getGraphics(), loc);
        			break;
        			
        		case plant3:
        			paintPlantComponent(e.getComponent().getGraphics(), loc);
        			break;
        			
        		case gC1:
        			paintGarbageCollectorComponent(e.getComponent().getGraphics(), loc);
        			getGCButton().setBorderPainted(false);
        			isClicked = click.norm;
        			crabby = true;
        			break;
        			
        		case gC2:
        			paintGarbageCollectorComponent(e.getComponent().getGraphics(), loc);
        			break;
        			
        		case gC3:
        			paintGarbageCollectorComponent(e.getComponent().getGraphics(), loc);
        			break;
            	}
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(background);
            }
        });

		Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE); // create window dimension
		panel2.setPreferredSize(size); // set window dimension
		panel2.setBorder(BorderFactory.createLineBorder(Color.blue)); // creates a border, not really needed
		
		panel2.setLayout(null); // default layout is Flowlayout, we need to decide what we want

		//panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		//panel2.add(Box.createRigidArea(new Dimension(50, 0)));
	
		
		//ImageIcon plantIcon = createImageIcon("images/Grass.png", "picture of grass");
		BufferedImage plant1 = createImage("images/Grass.png");
		pbutton = new JButton();
		
		Dimension size2 = pbutton.getPreferredSize();
		
		//pbutton.setFont(new Font("Georgia",Font.BOLD, 12));
		pbutton.setBounds(1250, 300, 100 , 100);
		
		pbutton.setIcon(new ImageIcon(plant1.getScaledInstance(100, 100, 20)));
		pbutton.addActionListener(this);
		pbutton.setActionCommand("Plant");
		pbutton.setBorderPainted(true);
		pbutton.setFocusPainted(false);
		pbutton.setContentAreaFilled(false);
		
		BufferedImage GarbCol = createImage("images/Squirrel/Squirrel1.png");
		gcbutton = new JButton();
		size2 = gcbutton.getPreferredSize();
		gcbutton.setBounds(1250, 200, 100 , 100);
		
		//gcbutton.setLocation(1000,1000);
		gcbutton.setIcon(new ImageIcon(GarbCol.getScaledInstance(100, 100, 20)));
		gcbutton.addActionListener(this);
		gcbutton.setActionCommand("Garbage Collector");
	
		panel2.add(pbutton);
		panel2.add(gcbutton);
		gcbutton.setBorderPainted(true);
		gcbutton.setFocusPainted(false);
		gcbutton.setContentAreaFilled(false);
		
        return panel2;
    	
    }

    protected void paintPlantComponent(Graphics g, Point loc ) {    
    	BufferedImage plant = pics[1];
    	g.drawImage(plant, (int)loc.getX()-33, (int)loc.getY()-36, 75, 75, null); //TODO:Move hard coded 30 pixels offset elsewhere for loading plants
    }
    
    protected void paintGarbageCollectorComponent(Graphics g, Point loc ) {    
    	BufferedImage GarbC = pics[2];
    	g.drawImage(GarbC, (int)loc.getX()-33, (int)loc.getY()-36, 75, 75, null); //TODO:Move hard coded 30 pixels offset elsewhere for loading plants
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Plant")){
			//PlaceObject placeplant = new PlaceObject();
			//we might not want this here, but this could invoke a call to update
			//which could then place a plant at the next clicked location based on the 
			//next mouse click that still has this button enabled
			isClicked = click.plant1;
			crabby = false;
			getPButton().setBorderPainted(true);
			getGCButton().setBorderPainted(false);
        } else if(cmd.equals("Garbage Collector")){
			//PlaceObject placegc = new PlaceObject();
			//same thing here. maybe just set the button enable and then 
			//invoke a call to update based on a click action listener which
			//would give the location to place
        	isClicked = click.gC1;
        	crabby = false;
        	getGCButton().setBorderPainted(true);
        	getPButton().setBorderPainted(false);
//        	crabs.add(new CrabView());
//        	for(int i = 0; i < 10000; i++){
//        		panel2.repaint();
//        		if(rando() == 1){
//        		crabs.add(new CrabView(panel2));
//        		}
//        		try {
//        			Thread.sleep(30);
//        		} catch (InterruptedException j) {
//        			j.printStackTrace();
//        		}
//        	}
		} 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    public static int rando(){
    	Random rnd = new Random();
    	return(rnd.nextInt(100));
    }
	


}
