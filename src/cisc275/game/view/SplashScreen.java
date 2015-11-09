package cisc275.game.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
	private static final int WORLD_WIDTH = 1440;
	private static final int WORLD_HEIGHT = 900;
	private static final int SCALE = 1;
	//private JFrame frame;
	private JPanel panel2;
	Button startGame;
	Button instructions;
	Image splashimage;
	BufferedImage[] pics;
	int numpics = 10;
	private JButton pbutton, gcbutton;
	
	private boolean plantClick, garbageCollectorClick = false;
	
	public SplashScreen() {
		//pack();
		//setVisible(true);
		//System.out.print("hEELOOEOEOE");
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

	public boolean getPlantBool() {
		return this.plantClick;
	}
	
	public boolean getGarbageCollectorBool() {
		return this.garbageCollectorClick;
	}
	
	public void setPlantBool(boolean b) {
		this.plantClick = b;
	}
	
	public void setGarbageCollectorBool(boolean b) {
		this.garbageCollectorClick = b;
	}
	
	public JPanel GameFrame(){
        final Image image = createImage();
        panel2 = new JPanel() {
        	
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //g.drawImage(image, 0, 0, null);
                g.drawImage(image, 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
            }
        };
        
        panel2.addMouseListener(new MouseAdapter() {
            private Color background;

            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println("Mouse clicked");
        		if (plantClick) {
        			System.out.println("Mouse clicked after plant clicked");
        			Point loc = e.getLocationOnScreen();
        			paintPlantComponent(e.getComponent().getGraphics(), loc);
        			setPlantBool(false);
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
		
		//getContentPane().add(panel2, BorderLayout.NORTH); // adds panel to content pane, this is what we will paint to and update
		panel2.setLayout(null); // default layout is Flowlayout, we need to decide what we want

		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		panel2.add(Box.createRigidArea(new Dimension(50, 0)));
		
		pbutton = new JButton("Plant");
		pbutton.addActionListener(this);
		pbutton.setActionCommand("Plant");
//		  try {
//			    Image img = ImageIO.read(new File("images/Grass.png"));
//			    button.setIcon(new ImageIcon(img));
//			  } catch (IOException ex) {
//			  }
		gcbutton = new JButton("Garbage Collector");
		gcbutton.addActionListener(this);
		gcbutton.setActionCommand("Garbage Collector");
		panel2.add(pbutton);
		panel2.add(gcbutton);
		
    	//pack();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		//setResizable(true);
        return panel2;
    	
    }
    protected BufferedImage createImage() {
        BufferedImage bufferedImage;
        try {
        	//bufferedImage=ImageIO.read(file);
            bufferedImage = ImageIO.read(new File("images/BackImg1.jpg"));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    protected BufferedImage createPlantImage() {
        BufferedImage bufferedImage;
        try {
        	//bufferedImage=ImageIO.read(file);
            bufferedImage = ImageIO.read(new File("images/RedMaple/RedMaple0005.png"));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    protected void paintPlantComponent(Graphics g, Point loc ) {    
    	BufferedImage plant = createPlantImage();
        g.drawImage(plant, (int)loc.getX(), (int)loc.getY(), 100, 100, null);
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Plant")){
			//PlaceObject placeplant = new PlaceObject();
			//we might not want this here, but this could invoke a call to update
			//which could then place a plant at the next clicked location based on the 
			//next mouse click that still has this button enabled
			plantClick = true; //should these be done through a setter?
			garbageCollectorClick = false;
			System.out.println("plant button enabled");
        } else if(cmd.equals("Garbage Collector")){
			//PlaceObject placegc = new PlaceObject();
			//same thing here. maybe just set the button enable and then 
			//invoke a call to update based on a click action listener which
			//would give the location to place
        	garbageCollectorClick = true;
			plantClick = false;
        	System.out.println("garbage collector button enabled");
		} 
//        	else {
//			plantClick = false;
//			garbageCollectorClick = false;
//			System.out.println("no buttons enabled"); //doesn't seem to reach this, need to disable the buttons elsewhere
//			//this could manually be done with a setter after updating the actions related to the button
//		}
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

	



}
