package cisc275.game.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import cisc275.game.controller.Action;
import cisc275.game.controller.GameListener;
import cisc275.game.controller.Player;
import cisc275.game.model.Crab;
import cisc275.game.model.Game;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameView extends JPanel implements GameListener<Game>, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3555168036929980855L;
	//game constants
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	public static String title = "Estuary Defense";
	int deletenum = -1; //with use of crabs
	static ArrayList<CrabView> crabs = new ArrayList<CrabView>();//array of crabviews
	private static GameView instance = null;
	public int imgHeight;
	public int imgWidth;
	
	private Player player;
	//private Key, Mouse?
	private BufferedImage image = new BufferedImage(getWorldWidth(), getWorldHeight(), BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	// # of milliseconds between state updates, probably will be 
	//important when we figure out how to loop game
	private long speed; 	
	//number of rows and columns in the "world"
	private int rows;
	private int cols;
	//this level and the list of all possible levels
	private int level;
	
	Image crab;
	Image mcrab;
	Image garbage;
	Image plant;
	Image garbageCollector;
	
	private JPanel gamePanel;
	private GridBagLayout gb1;
	private SimpleModel simpleModel = new SimpleModel();
   	
	public GameView() {
		gamePanel = locationPanel();
		this.add(gamePanel);
		gb1 = new GridBagLayout();
		this.setLayout(gb1);
		Dimension size = new Dimension(getWorldWidth()*getScale(), getWorldHeight()*getScale()); // create window dimension
		this.setMinimumSize(size); // set window dimension
		
		JLabel name = new JLabel("WELCOME TO ESTUARY DEFENSE!");
		addGridItem(gamePanel,name,0,0,1,1,GridBagConstraints.CENTER,new Insets(80,100,40,100));
		JButton button1 = new JButton("Start");
		button1.addActionListener(this);
		button1.setActionCommand("Open");
		addGridItem(gamePanel,button1,0,1,1,1,GridBagConstraints.CENTER,new Insets(80,100,5,100));
		JButton button2 = new JButton("Tutorial");
		button2.addActionListener(this);
		button2.setActionCommand("OpenTut");
		addGridItem(gamePanel,button2,0,2,1,1,GridBagConstraints.CENTER,new Insets(5,100,80,100));	
		
		this.setVisible(true);
	}
	
	private JPanel locationPanel() {
		final Image image = createImage();
		JPanel gpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWorldWidth(), getWorldHeight(), null);
                
            }
        };
		gpanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		System.out.println("clicked: "+arg0.getX()+","+arg0.getY());
//        		if (instructionsView.getInstance().getSimpleModel().getEnum() == "Back") {
//        			gv1.show(gamePanel,"1");
//        		}
        	}
        });
		gpanel.setLayout(new GridBagLayout());
		//this.setLayout(gb1);
		Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE); // create window dimension
		//this.setPreferredSize(size);
		gpanel.setPreferredSize(size);
		gpanel.setMinimumSize(size);
		return gpanel;
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
	public JPanel getGamePanel() {
		return this.gamePanel;
	}
	public int getlevel(){
		return level;
	}
	public int getRows() {
		return rows;
	}
	public int getCols() {
		return cols;
	}
	//sets the list of available levels
	void setLevel() {
	}		
	public static void getLevel(){			
	}
	/**
	 * @return prints the current level, money, and pH
	 */
	public String getStatus() {
		return null; 
    }
	/**
	 * acts as onTick
	 */
	void update() {
	}
	//no idea what these two do
	void remove() {
	}
	void render() {
	}
	//if sewage has stopped and game is not ended advance to next level
	void nextlevel() {
	}
    protected BufferedImage createImage() {
        BufferedImage bufferedImage;
        try {
        	//image=ImageIO.read(file);
            bufferedImage = ImageIO.read(new File("images/BackImg3.jpg"));
            imgHeight=bufferedImage.getHeight();
            imgWidth=bufferedImage.getWidth();
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	@Override
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		//System.out.println("in gv action performed: "+cmd);
	      if(cmd.equals("Open")){
	    	  	//gv1.show(splashScreen.getParent(),  "2");
	    	  	//setMainView("2");
	    	  	simpleModel.setAction("Open");
	        }
	      if(cmd.equals("OpenTut")){
				//gv1.show(instructionsView.getParent(), "3");
	    	  	//setMainView("3");
	    	  	simpleModel.setAction("OpenTut");
			}
	      if(cmd.equals("Back")){
	    	  //System.out.println("Back in gv");
	    	  //gv1.show(gamePanel.getParent(), "1");
	      }
	    }
    public static int rando(){
    	Random rnd = new Random();
    	return(rnd.nextInt(100));
    }
	void drawGarbage() {
	}
	void drawPlants() {
	}
	void drawGarbageCollectors() {
	}
	void drawHills() {
	}
	void drawWater() {
	}
	void drawHealthBar() {
	}
	void drawMoneyBar() {
	}
	void playSound() {
	}
	@Override
	public void onPerformActionEvent(Action<Game> action, Game game) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onTickEvent(Game game) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onStartEvent(Game game) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onEndEvent(Game game) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onEvent(String event, Game game) {
		// TODO Auto-generated method stub
	}
	public static int getWorldWidth() {
		return WORLD_WIDTH;
	}
	public static int getWorldHeight() {
		return WORLD_HEIGHT;
	}
	public static int getScale() {
		return SCALE;
	}
	public static GameView getInstance() {
		if (instance == null) {
			instance = new GameView();
		}
		return instance;
	}

	public void setModel(final SimpleModel simpleModel) {
		this.simpleModel = simpleModel;
		simpleModel.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent pce) {
				if (SimpleModel.ACTION_TEXT.equals(pce.getPropertyName())) {
					System.out.println("Action: " + simpleModel.getAction());
				}
			}
		});	
	}
	public SimpleModel getSimpleModel() {
		return simpleModel;
	}
}


