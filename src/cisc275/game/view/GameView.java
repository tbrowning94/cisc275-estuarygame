package cisc275.game.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import cisc275.game.controller.Action;
import cisc275.game.controller.GameListener;
import cisc275.game.controller.Player;
import cisc275.game.model.Crab;
import cisc275.game.model.Game;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameView extends JFrame implements GameListener<Game>, Runnable, ActionListener {
	//game constants
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	public static String title = "Estuary Defense";
	private JFrame frame;
	int deletenum = -1; //with use of crabs
	static ArrayList<CrabView> crabs = new ArrayList<CrabView>();//array of crabviews
	private static GameView gameView = null;
	public int imgHeight;
	public int imgWidth;
	
	private Player player;
	//private Key, Mouse?
	private boolean running = false;
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
	
	private JPanel gamePanel, buttonPanel;
	private JButton next, previous;
	private CardLayout gv1;
	private SimpleModel simpleModel = new SimpleModel();
	
	private InstructionsView instructionsView;
	private SplashScreen splashScreen;
   	
	public GameView() {
		splashScreen = SplashScreen.getInstance();
		instructionsView = InstructionsView.getInstance();
		
		splashScreen.setModel(simpleModel);
		instructionsView.setModel(simpleModel);
		
		final Image image = createImage();
		gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWorldWidth(), getWorldHeight(), null);
                
            }
        };
		gv1 = new CardLayout();
		gamePanel.setLayout(gv1);
		gamePanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		System.out.println("clicked: "+arg0.getX()+","+arg0.getY());
        	}
        });
		//gamePanel.add(gameView, "1");
		gamePanel.add(splashScreen, "2");
		gamePanel.add(instructionsView, "3");
		Dimension size = new Dimension(getWorldWidth()*getScale(), getWorldHeight()*getScale()); // create window dimension
		gamePanel.setPreferredSize(size); // set window dimension
		gamePanel.setBorder(BorderFactory.createLineBorder(Color.blue)); // creates a border, not really needed
		gv1.show(gamePanel, "2");
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//next = new JButton("Next");
		//next.addActionListener(new NextButtonAction());
		//previous = new JButton("Previous");
		
		//buttonPanel.add(next);
		//buttonPanel.add(previous);
		
		JLabel Name = new JLabel("WELCOME TO ESTUARY DEFENSE!");
		JButton button1 = new JButton("Start");
		button1.addActionListener(this);
		button1.setActionCommand("Open");
		JButton button2 = new JButton("Tutorial");
		button2.addActionListener(this);
		button2.setActionCommand("OpenTut");
		Name.setAlignmentY(Component.TOP_ALIGNMENT);
		buttonPanel.add(Name); 	
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		
		this.setLayout(new BorderLayout());
		this.add(gamePanel, "Center");
		this.add(buttonPanel, "South");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
	private class NextButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			gv1.next(gamePanel);
		}
	}
	
	public JFrame getFrame() {
		return this.frame;
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
	      if(cmd.equals("Open")){
	            //getContentPane().removeAll();//dispose();
	            //getContentPane().add(splashScreen.getInstance());
	            gv1.show(gamePanel,  "2");
	            gameView.remove(buttonPanel);
	            pack();
	        }
	      if(cmd.equals("OpenTut")){
				//getContentPane().removeAll();
				//getContentPane().add(instructionsView.getInstance());
				gv1.show(gamePanel, "3");
				gameView.remove(buttonPanel);
				pack();
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
//	public synchronized void start() {
//		running = true;
//		thread = new Thread(this, "Display");
//		thread.start();
//	}
	
//	public synchronized void stop() {
//		running = false;
//		try {
//			thread.join();
//			
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			System.out.println("Try/catch failure in GameView.stop()");
//		}
//	}
	
//	@Override
//	public void run() {
//		long lastTime = System.nanoTime();
//		long timer = System.currentTimeMillis();
//		final double ns = 1000000000.0 / 60.0;
//		double delta = 0;
//		int frames = 0;
//		int updates = 0;
//		frame.requestFocus();
//		while (running) {
//			long now = System.nanoTime();
//			delta += (now - lastTime) / ns;
//			lastTime = now;
//			while (delta >= 1) {
//				update();
//				updates++;
//				delta--;
//			}
//			render();
//			frames++;
//			
//			if (System.currentTimeMillis() - timer > 1000) {
//				timer += 1000;
//				// System.out.println(updates+" UPS, "+frames+" FPS");
//				frame.setTitle(title+"  |  "+updates+" UPS, "+frames+" FPS");
//				updates = 0;
//				frames = 0;
//			}
//		}
//		stop();
//	}
	public static int getWorldWidth() {
		return WORLD_WIDTH;
	}
	public static int getWorldHeight() {
		return WORLD_HEIGHT;
	}
	public static int getScale() {
		return SCALE;
	}
	public static void main(String[] args) { //move to view, windows are central thread of game
		SwingUtilities.invokeLater(new Runnable(){	
			@Override
			public void run() {
				if (gameView == null) {
					gameView = new GameView();
					gameView.setVisible(true);
				}
			}
		});
	}
	@Override
	public void run() {
		if (gameView == null) {
			gameView = new GameView();
			gameView.setVisible(true);
		}
	}
}


