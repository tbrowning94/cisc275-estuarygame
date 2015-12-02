package cisc275.game.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
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
//import cisc275.game.view.GameView.TimerListener;

public class SplashScreen extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
	static int TIMER_DELAY = 50;
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	private JLayeredPane panel2;
	int deletenum = -1; //with use of crabs
	int deletenumWater = -1; // with water
	 static ArrayList<CrabView> crabs = new ArrayList<CrabView>();//array of crabviews
	 static ArrayList<PlantView> plants = new ArrayList<PlantView>();
	 static ArrayList<Water> waterTiles = new ArrayList<Water>();
	 static ArrayList<GarbageCollectorView> garbColl = new ArrayList<GarbageCollectorView>();
	public static boolean crabby = true;
	Button startGame;
	int money = 200;
	JLabel moneyvalue = new JLabel("<html><span style='font-weight: bold; color: green; font-size:27px'>"+"$"+ money+ "</span></html>");
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
	Game game;
	
	boolean run =true;
    int imgHeight;
    int imgWidth;
    
	private BufferedImage pics[];
	//List<JLabel> plants;
    
	private enum click {
		plant1, plant2, plant3, gC1, gC2, gC3, norm
	}
	
	private click isClicked = click.norm;
	
	private File file;
	
	public SplashScreen() {
		PlantView p = new PlantView();
		GarbageCollectorView tempgarb = new GarbageCollectorView();
		pics = new BufferedImage[numpics];
    	BufferedImage bi = createImage("images/BackTrial1.png");
    	BufferedImage plant1 = createImage("images/Fern.png");
    	BufferedImage GarbCol = createImage("images/Squirrel/Squirrel1.png");
    	BufferedImage Cloud = createImage("images/cloud.png");
    	BufferedImage bi2 = createImage("images/back1_pipe_2.png");
    	BufferedImage water1 = createImage("images/textures/water_map.png");
    	System.out.print("PrintPics");
    	pics[0] = bi;
    	pics[1] = plant1;
    	pics[2] = GarbCol;
    	pics[3] = Cloud;
    	pics[4] = bi2;
    	pics[5] = water1;
    	  	
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
	
	public JLayeredPane getPanel2() {
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

	public JLayeredPane GameFrame(){
		new Timer(TIMER_DELAY, new TimerListener()).start();
        panel2 = new JLayeredPane() {
        	
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
               // g.drawImage(pics[0], 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
               g.drawImage(pics[0], 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
            }
        };
        moneyvalue.setLocation(1200, -75);
        moneyvalue.setSize(200,200);
        panel2.add(moneyvalue);
        crabs.add(new CrabView()); // creates initial crab
        waterTiles.add(new Water(this, new Point (615,330), 100, 5, Color.BLUE, 1.0));
        panel2.addMouseListener(new MouseAdapter() { //change to addMouseMotionListener if using drag 
            private Color background;

            @Override
            public void mouseClicked(MouseEvent e) {
            	Point loc = new Point(e.getX(), e.getY()); //e.getLocationOnScreen();
        		//System.out.println("motion detected");
            	switch (isClicked) {
            	
            	case norm:
            		System.out.println(loc);
            		break;
            		
            	case plant1:
            		loc.setLocation(loc.getX()-30, loc.getY()-30);
            		PlantView tempplant = new PlantView(1, loc);
            		checkbuffer(tempplant);
            		getPanel2().add(tempplant.pbutton);
            		plants.add(tempplant);
            		money-=10;
            		moneyvalue.setText("<html><span style='font-weight: bold; color: green; font-size:27px'>"+"$"+ money+ "</span></html>");
        			//paintPlantComponent(e.getComponent().getGraphics(), loc);
        			//getPButton().setBorderPainted(false);
            		//plants.get(plantindex).setLocation(loc);
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
            		moneyvalue.setText("<html><span style='font-weight: bold; color: green; font-size:27px'>"+"$"+ money+ "</span></html>");
//        			paintGarbageCollectorComponent(e.getComponent().getGraphics(), loc);
//        			getGCButton().setBorderPainted(false);
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
//                isClicked = click.norm;
//                getPButton().setBorderPainted(false);
//                crabby = true;
//    			isClicked = click.norm;
            }
        });
        Fisherman f = new Fisherman(null, null, 8, 200);
        panel2.add(f.getContentPane().add(f.getbarMoney()));
        panel2.add(f.getContentPane().add(f.getbarPh()));
        pack();
        setVisible(true);
        
		Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE); // create window dimension
		panel2.setPreferredSize(size); // set window dimension
		panel2.setBorder(BorderFactory.createLineBorder(Color.blue)); // creates a border, not really needed
		
		panel2.setLayout(null); // default layout is Flowlayout, we need to decide what we want

		//panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		//panel2.add(Box.createRigidArea(new Dimension(50, 0)));
	
		
		//ImageIcon plantIcon = createImageIcon("images/Grass.png", "picture of grass");
		//paintComponent(null);
		BufferedImage plant1 = createImage("images/Fern.png");
		pbutton = new JButton();
		
		Dimension size2 = pbutton.getPreferredSize();
		
		//pbutton.setFont(new Font("Georgia",Font.BOLD, 12));
		pbutton.setBounds(1250, 100, 100 , 100);
		
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
		gcbutton.setBorderPainted(true);
		gcbutton.setFocusPainted(false);
		gcbutton.setContentAreaFilled(false);
		
		BufferedImage Cloud = createImage("images/cloud.png");
		size2=cloud.getPreferredSize();
		cloud.setIcon(new ImageIcon(Cloud.getScaledInstance(100, 100, 20)));
		if (run == true){
		cloud.setBounds(500, 50, 100, 150);
		theX+=xincr;
		//theY+=yincr;
		}
		
		
		panel2.add(pbutton);
		panel2.add(gcbutton);
		//panel2.add(cloud);

		
        return panel2;
    	
    }
//	public void paintComponent(Graphics c){
//		BufferedImage Cloud = createImage("images/cloud.png");
//		if(run == true){
//			cloud = new JLabel();
//			cloud.setLocation(theX, theY);
//			cloud.setBounds(50, 500, 200, 200);
//			theX += xincr;
//			if(theX > 1500 || theX < 0){
//            	theX=0;
//            }
//			paintComponent(c);
//			if (theY < 300){
//				theY+=yincr;
//			}
//			else if(theY<=300){theY-=yincr;}
//			
//			//c.createGraphics();
//            //cloud.createGraphics();
//        }
//	}
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
    	ImageIcon waterIcon = new ImageIcon(water.getScaledInstance(health, 100, 20));
    	JLabel newWater = new JLabel("water");
    	newWater.setIcon(waterIcon);
    	newWater.setLocation(loc);
    	newWater.setSize(75,75);
    	return newWater;
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
	private class TimerListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {
        	if(crabby == true && SplashScreen.crabby == true){
        		//System.out.println("test");
               paintcrab();
               paintwater();
               plantcheck();
                //System.out.println("test6");
//                for(CrabView c: crabs){
//             	   frame.remove(c.cbutton);
//            	}
                if(rando() == 1 && crabcount < 50){ //randomly makes a crab (1/50 chance)
            		crabs.add(new CrabView(true));
            		crabcount += 1;
            		}
                if(rando() == 1 && watercount < 10){ //randomly makes a crab (1/50 chance)
            		waterTiles.add(new Water(SplashScreen.this, new Point (615,330), 100, 5, Color.BLUE, 1.0));
            		watercount += 1;
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
    		//System.out.println("deleting");
    		if(crabs.get(deletenum).mitten!= true){
    			if(crabs.get(deletenum).nativelimit > 6){
    				System.out.println("subtractmoney");
    				money -= 10;
    				moneyvalue.setText("<html><span style='font-weight: bold; color: green; font-size:27px'>"+"$"+ money+ "</span></html>");
    				
    				getPanel2().remove(moneyvalue);
    				getPanel2().add(moneyvalue);
    			}
    			else{
    				System.out.println("addmoney");
    				money += 10;
    				moneyvalue.setText("<html><span style='font-weight: bold; color: green; font-size:27px'>"+"$"+ money+ "</span></html>");
    				getPanel2().remove(moneyvalue);
    				getPanel2().add(moneyvalue);
    			}
    			
    		}
    		getPanel2().remove(crabs.get(deletenum).cbutton);
    		crabs.remove(deletenum);
    		crabcount -=1;
    		deletenum = -1;
    	}
    	//System.out.println("test5");
    }
	public void paintwater() {
		//Problem with is stopping,method needs to be implemented
		//in water class
    	for(Water w: waterTiles){
    		//System.out.println(w.isStopping());
    		if(!w.isStopping()){
    			w.move();
    		}
    		if(w.getRemoved() == true){ //checks if crab needs to be removed
    			deletenumWater = waterTiles.indexOf(w);
    			//System.out.println("deletenum:"+deletenumWater);
    		}
    		w.paintWater();
    		getPanel2().remove(w.getWaterButton());
    		getPanel2().add(w.getWaterButton());
    		
    	}
    	if(deletenumWater != -1){ //removes water
    		//System.out.println("deleting");
    		getPanel2().remove(waterTiles.get(deletenumWater).getWaterButton());
    		waterTiles.remove(deletenumWater);
    		watercount -=1;
    		deletenumWater = -1;
    	}
    	//System.out.println("test5");
    }
	void plantcheck(){
		for(PlantView p:plants){
			
			for(Water w:waterTiles){
				if(!p.intersecting){
					if(p.checkintersectw(w)){
						//System.out.println("work");
						w.setStopping(true);
						//System.out.println(w.isStopping());
					}
				}
				else{
					w.setStopping(false);
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
							c.left = !c.left;
							c.right = !c.right;
							c.up = !c.up;
							c.down = !c.down;
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
	public void checkbuffer(PlantView pl){
		int deleteslot;
		 ArrayList<PlantView> tempp = new ArrayList<PlantView>();
		for(PlantView p: plants){
			if(p != pl){
				if(pl.checkintersectp(p)){
					tempp.add(p);
				}
			}
		}
		if(tempp.size() == 2){
			for(PlantView q: tempp){
				plants.remove(q);
				getPanel2().remove(q.pbutton);
			}
			pl.changepic(3);
			pl.buffer = true;
		}
	}
}
