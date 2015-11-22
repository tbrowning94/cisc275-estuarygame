package cisc275.game.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import cisc275.game.controller.PlaceObject;
import cisc275.game.model.Plant;
import javax.swing.SwingConstants;

public class SplashScreen extends JPanel implements ActionListener, MouseListener{
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	private static SplashScreen instance = null;
	int deletenum = -1; //with use of crabs
	 static ArrayList<CrabView> crabs = new ArrayList<CrabView>();//array of crabviews
	int numpics = 10;
    int imgHeight;
    int imgWidth;
    private JPanel splashPanel;
    private JLabel viewName;
    private JButton placePlant, placeGC;
    private GridBagLayout gb2;
    private SimpleModel simpleModel;
	private BufferedImage pics[];
    
	private enum click {
		plant1, plant2, plant3, gC1, gC2, gC3
	}
	private click isClicked;
	
	public SplashScreen() {
		pics = new BufferedImage[numpics];
    	BufferedImage bi = createImage("images/BackImg1.jpg");
    	BufferedImage plant1 = createImage("images/Grass.png");
    	BufferedImage GarbCol = createImage("images/Squirrel/Squirrel1.png");
    	//System.out.print("PrintPics");
    	pics[0] = bi;
    	pics[1] = plant1;
    	pics[2] = GarbCol;
    	 
    	splashPanel = locationPanel();
    	this.add(splashPanel);
    	gb2 = new GridBagLayout();
    	this.setLayout(gb2);
    	Dimension size = new Dimension(getWidth()*getScale(), getHeight()*getScale()); // create window dimension
		this.setMinimumSize(size); // set window dimension
		this.setPreferredSize(size); // set window dimension
    	
		viewName = new JLabel("Estuary Defense");
		//viewName.setVerticalAlignment(SwingConstants.TOP);
		//viewName.setHorizontalAlignment(SwingConstants.CENTER);
		placePlant = new JButton("Plant");
		placePlant.setIcon(new ImageIcon(pics[1].getScaledInstance(50,50,20)));
		placePlant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				//TODO
			}
		});
		placePlant.setActionCommand("Plant");
		placePlant.setBorderPainted(false);
		placePlant.setFocusPainted(false);
		placePlant.setContentAreaFilled(false);
		placeGC = new JButton("Garbage Collector");
		placeGC.setIcon(new ImageIcon(pics[2].getScaledInstance(50,50,20)));
		placeGC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				//TODO
			}
		});
		placeGC.setActionCommand("Garbage Collector");
		placeGC.setBorderPainted(false);
		placeGC.setFocusPainted(false);
		placeGC.setContentAreaFilled(false);
		
		addGridItem(splashPanel,viewName,0,0,1,1,GridBagConstraints.CENTER,new Insets(80,100,40,100));
		addGridItem(splashPanel,placePlant,0,1,1,1,GridBagConstraints.CENTER,new Insets(80,100,5,100));
		addGridItem(splashPanel,placeGC,0,2,1,1,GridBagConstraints.CENTER,new Insets(5,100,80,100));
		
		this.setVisible(true);
	}
	
	public void setModel(final SimpleModel simpleModel) {
		this.simpleModel = simpleModel;
		simpleModel.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent pce) {
				if (simpleModel.getAction().equals(pce.getPropertyName())) {
					//TODO
				}
			}
		});
	}
	public JPanel getSplashPanel() {
		return this.splashPanel;
	}
	public int getScale() {
		return SCALE;
	}
	private void addGridItem(JPanel panel, JComponent comp, int x, int y, int width, int height, int align, Insets padding) {
		GridBagConstraints gcon = new GridBagConstraints();
		gcon.gridx = x;
		gcon.gridy = y;
		gcon.gridwidth = width;
		gcon.gridheight = height;
		gcon.weightx = 0.5;
		gcon.weighty = 0.5;
		gcon.insets = padding;
		gcon.anchor = align;
		gcon.fill = GridBagConstraints.NONE;
		panel.add(comp, gcon);
	}
	private JPanel locationPanel() {
		JPanel spanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(pics[0], 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
            }
        };
        spanel.addMouseListener(new MouseAdapter() {
            private Color background;
            @Override
            public void mouseClicked(MouseEvent e) {
            	Point loc = new Point(e.getX(), e.getY()); //e.getLocationOnScreen();
        		
            	switch (isClicked) {
            		case plant1:
            			paintPlantComponent(e.getComponent().getGraphics(), loc);
            			break;
            			
            		case plant2:
            			paintPlantComponent(e.getComponent().getGraphics(), loc);
            			break;
            			
            		case plant3:
            			paintPlantComponent(e.getComponent().getGraphics(), loc);
            			break;
            			
            		case gC1:
            			paintGarbageCollectorComponent(e.getComponent().getGraphics(), loc);
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
        spanel.setLayout(new GridBagLayout());
		//this.setLayout(gb1);
		Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE); // create window dimension
		//this.setPreferredSize(size);
		spanel.setPreferredSize(size);
		spanel.setMinimumSize(size);
		return spanel;
	}
		
	public static SplashScreen getInstance() {
		if (instance == null) {
			instance = new SplashScreen();
		}
		return instance;
	}

	void initialize() {
	}
	void onClick() {
	}
	void inValidate() {
	}
	
	public JButton getPButton() {
		return this.placePlant;
	}
	
	public JButton getGCButton() {
		return this.placeGC;
	}

	public void paint(Graphics g) {
    	for(CrabView c: crabs){
    		if(c.removel == true){
    			deletenum = crabs.indexOf(c);
    		}
    		c.paintcrab(this, g);
    	}
    	if(deletenum != -1){
    		this.remove(crabs.get(deletenum).cbutton);
    		crabs.remove(deletenum);
    		deletenum = -1;
    	}
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
			simpleModel.setAction("Plant");
        } else if(cmd.equals("Garbage Collector")){
			//PlaceObject placegc = new PlaceObject();
			//same thing here. maybe just set the button enable and then 
			//invoke a call to update based on a click action listener which
			//would give the location to place
        	isClicked = click.gC1;
        	simpleModel.setAction("Garbage Collector");
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
	
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}