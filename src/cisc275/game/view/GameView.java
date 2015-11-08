package cisc275.game.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
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

public class GameView extends JFrame implements GameListener<Game>, Runnable {
	//game constants
	private static final int WORLD_WIDTH = 1440;
	private static final int WORLD_HEIGHT = 900;
	private static final int SCALE = 1;

	public static String title = "Estuary Defense";
	
	private JPanel panel;
	
	Image[] Back;
	final int BackFrames = 3; 
	
	private Player player;
	//private Key, Mouse?
	private boolean running = false;
	
	private BufferedImage image = new BufferedImage(WORLD_WIDTH, WORLD_HEIGHT, BufferedImage.TYPE_INT_RGB);
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
	
	
	public GameView() {
		createContent();
		//initUI();
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
	//makes a default start game
	void startGame() {
	}
	
	private Component createContent() {
        final Image image = createImage();
//      panel = new JPanel(); // Initialize panel
//		Game game = new Game(); // Not sure if this should go here?
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (String label : new String[]{"Start", "Take the Tutorial"}) {
            JButton button = new JButton(label);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(15, 15)));
            panel.add(button);
        }
		Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE); // create window dimension
		panel.setPreferredSize(size); // set window dimension
		panel.setBorder(BorderFactory.createLineBorder(Color.gray)); // creates a border, not really needed
		
		getContentPane().add(panel, BorderLayout.NORTH); // adds panel to content pane, this is what we will paint to and update
		panel.setLayout(null); // default layout is Flowlayout, we need to decide what we want

		// Testing adding normal buttons here
//		JButton btnPlant = new JButton("Plant"); // buttons can be created by constructors
//		btnPlant.setBounds(1355, 281, 97, 25);
//		panel.add(btnPlant); // but they need to be passed to game view in some way to add them to the panel
		
		// Testing implementing crab constructor here, can't get the image to show
//		ImageIcon crabplaceholder = new ImageIcon("images/textures/bush2.png");
//		JButton crabbutton = new JButton("crab img", crabplaceholder);
//		crabbutton.putClientProperty("position", new Point(0,0));
//		panel.add(crabbutton);
		
		// testing adding another normal button here
//		JButton btnCrab = new JButton("crab");
//		btnCrab.setBounds(727, 391, 97, 25);
//		panel.add(btnCrab);
		
		// testing adding a crab here, should create a crab button but I can't get it to display still
//		Crab c1 = new Crab(false, new Point(10,10));
//		panel.add(c1.getButton());
		//add buttons, i.e. objects, probably better to do in update
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

        return panel;
    }

    private BufferedImage createImage() {
        BufferedImage bufferedImage;

        try {
        	//image=ImageIO.read(file);
            bufferedImage = ImageIO.read(new File("images/img.jpg"));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

	void drawCrabs() {
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

	//runs game
	public static void main(String[] args) { //move to view, windows are central thread of game
//		GameView gv = new GameView();
//		gv.InitializeBoardsize();
//		gv.startGame(); // Not sure about this either
//		gv.start(); // runs thread which calls run()
//		SwingUtilities.invokeLater(new Runnable(){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				GameView gv = new GameView();
				gv.setVisible(true);
			}
		});
	}

	@Override
	public void run() {
		GameView gv = new GameView();
		gv.setVisible(true);
	}
}


