package cisc275.game.view;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainView extends JFrame implements Runnable, ActionListener {
	/**
	* 
	*/
	private static final long serialVersionUID = 3215378592431621424L;
	// game constants
	public static String title = "Estuary Defense";
	private JFrame frame;
	public int imgHeight;
	public int imgWidth;

	// private Key, Mouse?
	private boolean running = false;
	// number of rows and columns in the "world"
	private int rows;
	private int cols;

	private CardLayout gv1;
	private SimpleModel simpleModel = new SimpleModel();

	private static MainView mainView = null;
	private GameView gameView;
	private InstructionsView instructionsView;
	private SplashScreen splashScreen;

	public MainView() {
		gameView = GameView.getInstance();
		splashScreen = SplashScreen.getInstance();
		instructionsView = InstructionsView.getInstance();

		gameView.setModel(simpleModel);
		splashScreen.setModel(simpleModel);
		instructionsView.setModel(simpleModel);

		// gamePanel = locationPanel();
		gv1 = new CardLayout();
		this.setLayout(gv1);
		// this.add(buttonPanel, "South");
		this.add(gameView, "1");
		this.add(splashScreen, "2");
		this.add(instructionsView, "3");
		gv1.show(gameView.getParent(), "1");

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	public void setView(String viewNumber) {
		if (viewNumber == "1") {
			gv1.show(gameView, viewNumber);
		} else if (viewNumber == "2") {
			gv1.show(splashScreen, viewNumber);
		} else if (viewNumber == "3") {
			gv1.show(instructionsView, viewNumber);
		}
	}
	public MainView getMainView() {
		return MainView.mainView;
	}
	public CardLayout getgv1() {
		return this.gv1;
	}
	public JFrame getFrame() {
		return this.frame;
	}
	public int getRows() {
		return rows;
	}
	public int getCols() {
		return cols;
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
	// no idea what these two do
	void remove() {
	}
	void render() {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Open")) {
			gv1.show(splashScreen, "2");
		}
		if (cmd.equals("OpenTut")) {
			gv1.show(instructionsView, "3");
		}
		if (cmd.equals("Back")) {
			System.out.println("Back in mv");
			gv1.show(gameView, "1");
		}
	}
//	public synchronized void start() {
//	running = true;
//	thread = new Thread(this, "Display");
//	thread.start();
//}

//public synchronized void stop() {
//	running = false;
//	try {
//		thread.join();
//		
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//		System.out.println("Try/catch failure in GameView.stop()");
//	}
//}

//@Override
//public void run() {
//	long lastTime = System.nanoTime();
//	long timer = System.currentTimeMillis();
//	final double ns = 1000000000.0 / 60.0;
//	double delta = 0;
//	int frames = 0;
//	int updates = 0;
//	frame.requestFocus();
//	while (running) {
//		long now = System.nanoTime();
//		delta += (now - lastTime) / ns;
//		lastTime = now;
//		while (delta >= 1) {
//			update();
//			updates++;
//			delta--;
//		}
//		render();
//		frames++;
//		
//		if (System.currentTimeMillis() - timer > 1000) {
//			timer += 1000;
//			// System.out.println(updates+" UPS, "+frames+" FPS");
//			frame.setTitle(title+"  |  "+updates+" UPS, "+frames+" FPS");
//			updates = 0;
//			frames = 0;
//		}
//	}
//	stop();
//}
	public static void main(String[] args) { // move to view, windows are
												// central thread of game
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (mainView == null) {
					mainView = new MainView();
					mainView.setVisible(true);
				}
			}
		});
	}
	@Override
	public void run() {
		if (mainView == null) {
			mainView = new MainView();
			mainView.setVisible(true);
		}
	}
}