package cisc275.game.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.MouseMotionListener;
import cisc275.game.controller.PlaceObject;
import cisc275.game.model.Fisherman;
import cisc275.game.model.Game;
import cisc275.game.model.GarbageCollector;
import cisc275.game.model.Plant;
import cisc275.game.model.Water;


public class SplashScreen extends ViewTemplate implements ActionListener, MouseListener, MouseMotionListener {
	static int TIMER_DELAY = 50;
	
	private static JLayeredPane panel2;
	int deletenum = -1; //with use of crabs
	int deletenumWater = -1; // with water
	int deletenumFM = -1; // with fisherman
	 static ArrayList<CrabView> crabs = new ArrayList<CrabView>();//array of crabviews
	 static ArrayList<PlantView> plants = new ArrayList<PlantView>();
	 static ArrayList<Water> waterTiles = new ArrayList<Water>();
	 static ArrayList<Fisherman> fms = new ArrayList<Fisherman>();
	 static ArrayList<GarbageCollectorView> garbColl = new ArrayList<GarbageCollectorView>();
	public static boolean crabby = false;
	Button startGame;
	boolean intersection = false;
	int money = 200;
	Button instructions;
	Image splashimage;
    JLabel cloud = new JLabel("cloud");
	int numpics = 10;
	private JButton pbutton, gcbutton;
	private int theX=3;
	private int theY=3;
	final int xincr = 3;
	final int yincr = 2;
	public int crabcount = 1;
	public int watercount = 1;
	public int fmcount = 1;
	Game game;
	
	
	boolean run =true;
    int imgHeight;
    int imgWidth;
    
	private BufferedImage pics[];

    
	private enum click {
		plant1, plant2, plant3, gC1, gC2, gC3, norm
	}
	
	private click isClicked = click.norm;
	
	private File file;
	
	public SplashScreen() {
		try {
			PlantView.InitializePictures();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GarbageCollectorView tempgarb = new GarbageCollectorView();
		pics = new BufferedImage[numpics];
    	BufferedImage bi = createImage("images/BackTrial1.png");
    	BufferedImage plant1 = createImage("images/Fern.png");
    	BufferedImage GarbCol = createImage("images/Squirrel/Squirrel1.png");
    	BufferedImage Cloud = createImage("images/cloud.png");
    	BufferedImage bi2 = createImage("images/back1_pipe_2.png");
    	BufferedImage water1 = createImage("images/textures/water_map.png");
    	BufferedImage fm1 = createImage("images/boatman.png");
    	System.out.print("PrintPics");
    	pics[0] = bi;
    	pics[1] = plant1;
    	pics[2] = GarbCol;
    	pics[3] = Cloud;
    	pics[4] = bi2;
    	pics[5] = water1;
    	pics[6] = fm1;
    	  	
     	
     	
     	this.panel2 = GameFrame();
		
		
	}

	void initialize() {
	}
	void onClick() {
	}
	void inValidate() {
	}
	
	public static JLayeredPane getPanel2() {
		return panel2;
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

	public JLayeredPane GameFrame(){
		
		new Timer(TIMER_DELAY, new TimerListener()).start();
        panel2 = new JLayeredPane() {
        	
        	
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
               
               g.drawImage(pics[0], 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
           
        		Rectangle Hbar = new Rectangle((int)(WORLD_WIDTH * 0.7), (int)(WORLD_HEIGHT * 0.03), 20, 40);
        		Rectangle Mbar = new Rectangle((int)(WORLD_WIDTH * 0.45), (int)(WORLD_HEIGHT * 0.03), 20, 40);
        		Rectangle Cbar = new Rectangle((int)(WORLD_WIDTH * 0.2), (int)(WORLD_HEIGHT * 0.03), 20, 40);
        		int health = fms.get(0).getpH();
        		int money = fms.get(0).getMoney();
        		int crabs = CrabView.nativelimit;
        		
        		// health bar gray background
        		g.setColor(Color.GRAY);
        		
        		g.drawRoundRect(Mbar.x, Mbar.y, Mbar.width, Mbar.height, 15, 15);
        		g.fillRoundRect(Mbar.x, Mbar.y, Mbar.width, Mbar.height, 15, 15);
        		
        		g.drawRoundRect(Hbar.x, Hbar.y, Hbar.width, Hbar.height, 15, 15);
        		g.fillRoundRect(Hbar.x, Hbar.y, Hbar.width, Hbar.height, 15, 15);
        		
        		g.drawRoundRect(Cbar.x, Cbar.y, Cbar.width, Cbar.height, 15, 15);
        		g.fillRoundRect(Cbar.x, Cbar.y, Cbar.width, Cbar.height, 15, 15);
        		
        		if(money > 150){
        			g.setColor(Color.GREEN);
        		}
        		if(money > 50 && money < 150){
        			g.setColor(Color.YELLOW);
        		}
        		if(money < 50){
        			g.setColor(Color.RED);
        		}
        		g.fillRoundRect(Mbar.x, Mbar.y, 200 , Mbar.height, 15, 15);
        		g.setColor(Color.BLACK);
        		g.setFont(new Font("Purisa", Font.BOLD, 22));
        		g.drawString("Money: " + fms.get(0).getMoney(), Mbar.x, Mbar.y );
        	
        		
        		if (health < 50) {
        			g.setColor(Color.RED);
        		}
        		else if (health < 150) {
        			g.setColor(Color.YELLOW);
        		}
        		else {
        			g.setColor(Color.GREEN);
        		}
        		g.fillRoundRect(Hbar.x, Hbar.y, 200 , Hbar.height, 15, 15);
        		g.setColor(Color.BLACK);
        		g.setFont(new Font("Purisa", Font.BOLD, 22));
        		g.drawString("pH: " + fms.get(0).getpH()/25, Hbar.x , Hbar.y );
        		
        		if (crabs < 5) {
        			g.setColor(Color.GREEN);
        		}
        		else {
        			g.setColor(Color.RED);
        		}
        		g.fillRoundRect(Cbar.x, Cbar.y, 200 , Cbar.height, 15, 15);
        		g.setColor(Color.BLACK);
        		g.setFont(new Font("Purisa", Font.BOLD, 22));
        		g.drawString("Crabs Caught: " + crabs, Cbar.x , Cbar.y );
        		};
        	
        };
        
        crabs.add(new CrabView()); // creates initial crab
        waterTiles.add(new Water(this, new Point (ViewTemplate.scalex(575),ViewTemplate.scaley(280)), ViewTemplate.scaley(100), 5, Color.BLUE, 1.0));
        panel2.addMouseListener(new MouseAdapter() { //change to addMouseMotionListener if using drag 
            private Color background;

            @Override
            public void mouseClicked(MouseEvent e) {
            	Point loc = new Point(e.getX(), e.getY()); //e.getLocationOnScreen();
        		
            	switch (isClicked) {
            	
            	case norm:
            		System.out.println(loc);
            		break;
            		
            	case plant1:
            		loc.setLocation(loc.getX()-ViewTemplate.scalex(30), loc.getY()-ViewTemplate.scaley(30));
            		PlantView tempplant = new PlantView(1, loc);
            		PlantView.checkbuffer(tempplant);
            		getPanel2().add(tempplant.pbutton);
            		plants.add(tempplant);
            		money-=10;
            		
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
        			loc.setLocation(loc.getX()-30, loc.getY()-30);
            		GarbageCollectorView tempgc = new GarbageCollectorView(1, loc);
            		getPanel2().add(tempgc.gcbutton);
            		garbColl.add(tempgc);
            		money-=10;
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
        fms.add(new Fisherman(this, new Point (ViewTemplate.scalex(1200),ViewTemplate.scaley(700)), new Point (ViewTemplate.scalex(100),ViewTemplate.scaley(700)), 0, 200));
		
        pack();
        setVisible(true);
        
		Dimension size = new Dimension(WORLD_WIDTH, WORLD_HEIGHT); // create window dimension
		panel2.setPreferredSize(size); // set window dimension
		panel2.setBorder(BorderFactory.createLineBorder(Color.blue)); // creates a border, not really needed
		
		panel2.setLayout(null); // default layout is Flowlayout, we need to decide what we want

		BufferedImage plant1 = createImage("images/Fern.png");
		pbutton = new JButton();
		
		Dimension size2 = pbutton.getPreferredSize();
		pbutton.setBounds(ViewTemplate.scalex(1250), ViewTemplate.scaley(100),  ViewTemplate.scalex(100), ViewTemplate.scaley(100));
		pbutton.setIcon(new ImageIcon(plant1.getScaledInstance(ViewTemplate.scalex(100), ViewTemplate.scaley(100), Image.SCALE_DEFAULT)));
		pbutton.addActionListener(this);
		pbutton.setActionCommand("Plant");
		pbutton.setBorderPainted(true);
		pbutton.setFocusPainted(false);
		pbutton.setContentAreaFilled(false);
		System.out.println("SCALE\n"+widthscale+","+heightscale);
		System.out.println("RESOLUTION\n"+WORLD_WIDTH+","+WORLD_HEIGHT);
		System.out.println("actual scale\n"+WORLD_WIDTH/1366+","+WORLD_HEIGHT/768);
		BufferedImage GarbCol = createImage("images/Squirrel/Squirrel1.png");
		gcbutton = new JButton();
		size2 = gcbutton.getPreferredSize();
		gcbutton.setBounds(ViewTemplate.scalex(1250), ViewTemplate.scaley(200),  ViewTemplate.scalex(100), ViewTemplate.scaley(100));
		gcbutton.setIcon(new ImageIcon(GarbCol.getScaledInstance(ViewTemplate.scalex(100), ViewTemplate.scaley(100), Image.SCALE_DEFAULT)));
		gcbutton.addActionListener(this);
		gcbutton.setActionCommand("Garbage Collector");
		gcbutton.setBorderPainted(true);
		gcbutton.setFocusPainted(false);
		gcbutton.setContentAreaFilled(false);
		
		BufferedImage Cloud = createImage("images/cloud.png");
		size2=cloud.getPreferredSize();
		cloud.setIcon(new ImageIcon(Cloud.getScaledInstance(100, 100, 20)));
		if (run == true){
		cloud.setBounds(500, 50, 100, 150);
		theX+=xincr;
		}
		
		panel2.add(pbutton);
		panel2.add(gcbutton);
        return panel2;
    	
    }
	

    protected void paintPlantComponent(Graphics g, Point loc ) {    
    	BufferedImage plant = pics[1];
    	
    	g.drawImage(plant, (int)loc.getX()-33, (int)loc.getY()-36, 75, 75, null); //TODO:Move hard coded 30 pixels offset elsewhere for loading plants
    }
    public JLabel createPlantLabel(Point loc) {
    	BufferedImage plant = pics[1];
    	ImageIcon plantIcon = new ImageIcon(plant.getScaledInstance(100, 100, 20));
    	JLabel newPlant = new JLabel("plant");
    	newPlant.setIcon(plantIcon);
    	newPlant.setLocation(loc);
    	newPlant.setSize(75,75);
    	return newPlant;
    }
    public JLabel createWaterLabel(Point loc, int health) {
    	BufferedImage water = pics[5];
    	ImageIcon waterIcon = new ImageIcon(water.getScaledInstance(ViewTemplate.scalex(health), ViewTemplate.scaley(100), 20));
    	JLabel newWater = new JLabel("water");
    	newWater.setIcon(waterIcon);
    	newWater.setLocation(loc);
    	newWater.setSize(ViewTemplate.scalex(75),ViewTemplate.scaley(75));
    	return newWater;
    }
    public JLabel createFLabel(Point loc) {
    	BufferedImage fisherman = pics[6];
    	ImageIcon fmIcon = new ImageIcon(fisherman.getScaledInstance(ViewTemplate.scalex(150), ViewTemplate.scaley(100), 20));
    	JLabel newFM = new JLabel("fisherman");
    	newFM.setIcon(fmIcon);
    	newFM.setLocation(loc);
    	newFM.setSize(ViewTemplate.scalex(75),ViewTemplate.scaley(75));
    	return newFM;
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
		isClicked = click.norm;
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

	@Override
	public void mouseDragged(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	int timer = 0;
	private class TimerListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {
        	if(crabby == true && SplashScreen.crabby == true){
        		//System.out.println("test");
               paintcrab();
               paintwater();
               paintfm();
               plantcheck();
                //System.out.println("test6");
//                for(CrabView c: crabs){
//             	   frame.remove(c.cbutton);
//            	}
                if(rando() == 1 && crabcount < 50){ //randomly makes a crab (1/50 chance)
            		crabs.add(new CrabView(true));
            		crabcount += 1;
            		}
                timer +=1;
                if(timer == 30 && watercount < 50){ //randomly makes a crab (1/50 chance)
            		waterTiles.add(new Water(SplashScreen.this, new Point (ViewTemplate.scalex(575),ViewTemplate.scaley(280)), ViewTemplate.scaley(100), 5, Color.BLUE, 1.0));
            		if(fmcount < 5) {
            			fms.add(new Fisherman(SplashScreen.this, new Point (ViewTemplate.scalex(1200),ViewTemplate.scaley(700)), new Point (ViewTemplate.scalex(100),ViewTemplate.scaley(700)), 0, 200));
            			fmcount += 1;
            		}
            		watercount += 1;
            		timer = 0;
            		}
        	}
        };
     }
	public void paintcrab() {
    	int i = 0;
    	//System.out.println("test2 " + i);
		i++;
    	for(CrabView c: crabs){
    		if(c.removel == true){ //checks if crab needs to be removed
    			deletenum = crabs.indexOf(c);
    			//System.out.println("deletenum");
    		}
    		c.paintcrab();
    		getPanel2().remove(c.cbutton);
    		getPanel2().add(c.cbutton);
    		getPanel2().repaint();
    		
    	}
    	if(deletenum != -1){ //removes crab
    		if(crabs.get(deletenum).mitten!= true){
    			if(crabs.get(deletenum).nativelimit > 6){
    				money -= 10;
    			}
    			else{
    				money += 10;
    			}
    		}
    		getPanel2().remove(crabs.get(deletenum).cbutton);
    		crabs.remove(deletenum);
    		crabcount -=1;
    		deletenum = -1;
    	}
    }
	public void paintwater() {
    	for(Water w: waterTiles){
    		if(!w.isStopping()){
    			w.move();
    		}
    		if(w.getRemoved() == true){ 
    			deletenumWater = waterTiles.indexOf(w);
    		}
    		w.paintWater();
    		getPanel2().remove(w.getWbutton());
    		getPanel2().add(w.getWbutton());
    		
    	}
    	if(deletenumWater != -1){ 
    		getPanel2().remove(waterTiles.get(deletenumWater).getWbutton());
    		waterTiles.remove(deletenumWater);
    		watercount -=1;
    		deletenumWater = -1;
    	}
    }
	public void paintfm() {
    	for(Fisherman fm: fms){
    		if(!fm.isRemoved()){
    			fm.move();
    		}
    		else { 
    			deletenumFM = fms.indexOf(fm);
    		}
    		fm.paintFM();
    		getPanel2().remove(fm.getFLabel());
    		getPanel2().add(fm.getFLabel());
    	}
    	if(deletenumFM != -1){ 
    		getPanel2().remove(fms.get(deletenumFM).getFLabel());
    		fms.remove(deletenumFM);
    		fmcount -=1;
    		deletenumFM = -1;
    	}
    }
	void plantcheck(){
		for(PlantView p:plants){
			for(Water w:waterTiles){
				if(!p.intersecting){
					if(p.checkintersectw(w)){
						if(p.buffer){
							w.setStopping(true);
						}
						else if(!w.affected.contains(p)){
							w.shrink(p);
						}
					}
				}
				else if(w.affected.contains(p)){
					w.normal(p);
				}
			}
			
			p.intersecting = false;
			for(CrabView c:crabs){
				if(c.planta == null){
					if(p.checkintersects(c)){
						if(c.mitten & !p.buffer){
						c.stop = true;
						c.planta = p;
						p.intersecting = true;
						p.changepic(2);
						getPanel2().remove(p.pbutton);
						getPanel2().add(p.pbutton);
						}
						else{
							c.setrandom();
						}
					}
				}
				else if(c.planta == p){
					p.intersecting = true;
				}
			}
			if(!p.intersecting & !p.buffer){
				p.changepic(1);
			}
		}
	}
	
}
