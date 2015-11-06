package cisc275.game.view;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import cisc275.game.controller.Action;
import cisc275.game.controller.GameListener;
import cisc275.game.controller.Player;
import cisc275.game.model.Game;

public class GameView implements GameListener<Game>, Runnable {
	//game constants
	private static final int WORLD_WIDTH = 800;
	private static final int WORLD_HEIGHT = 448;
	private static final int SCALE = 1;
	public static String title = "Estuary Defense";
	
	private Thread thread;
	private JFrame frame;
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
	
	void InitializeBoardsize() {
		frame = new JFrame();
		Game game = new Game(); // Not sure if this should go here?
		Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE);
		frame.setPreferredSize(size);
		frame.setResizable(false);
		frame.setTitle(title);
		//frame.add(gameview);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
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
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Try/catch failure in GameView.stop()");
		}
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		frame.requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println(updates+" UPS, "+frames+" FPS");
				frame.setTitle(title+"  |  "+updates+" UPS, "+frames+" FPS");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	//runs game
	public static void main(String[] args) { //move to view, windows are central thread of game
		GameView gv = new GameView();
		gv.InitializeBoardsize();
		gv.startGame(); // Not sure about this either
		gv.start(); // runs thread which calls run()
	}
}
