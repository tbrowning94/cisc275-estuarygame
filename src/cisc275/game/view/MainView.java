package cisc275.game.view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class MainView extends JFrame implements Runnable, ActionListener {
	/**
	* 
	*/
	private static final long serialVersionUID = 3215378592431621424L;
	// game constants
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	public static String title = "Estuary Defense";
	private JFrame frame;
	private JPanel mainPanel;
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

		mainPanel = locationPanel();
		gv1 = new CardLayout();
		mainPanel.setLayout(gv1);
		//gv1.addLayoutComponent(gameView.getGamePanel(), "1");
		//gv1.addLayoutComponent(splashScreen.getSplashPanel(), "2");
		//gv1.addLayoutComponent(instructionsView.getInstPanel(), "3")
		mainPanel.add(gameView, "1");
		mainPanel.add(splashScreen, "2");
		mainPanel.add(instructionsView, "3");
		gv1.show(mainPanel, "1");
		//gv1.sh
			
		gameView.getSimpleModel().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent pce) {
				if (SimpleModel.ACTION_TEXT.equals(pce.getPropertyName())) {
					System.out.println("Action in mv: " + gameView.getSimpleModel().getAction());
				}
				if (gameView.getSimpleModel().getAction() == "Open") {
					gv1.show(mainPanel, "2");
				}
				if (gameView.getSimpleModel().getAction() == "OpenTut") {
					gv1.show(mainPanel, "3");
				}
			}
		});
		
		instructionsView.getSimpleModel().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent pce) {
				if (SimpleModel.ACTION_TEXT.equals(pce.getPropertyName())) {
					System.out.println("Action in mv: " + instructionsView.getSimpleModel().getAction());
				}
				if (instructionsView.getSimpleModel().getAction() == "Back") {
					gv1.show(mainPanel, "1");
				}
			}			
		});
		
		this.setLayout(new BorderLayout());
		this.add(mainPanel, "Center");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE); // create window dimension
		//this.getContentPane().setMaximumSize(size);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	private JPanel locationPanel() {
		JPanel panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
            private Color background;
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println("Mouse clicked");
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(background);
            }
        });
        this.setLayout(gv1);
        Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE); // create window dimension
		this.setPreferredSize(size);
		return panel;
	}
	public void setView(String viewNumber) {
		if (viewNumber == "1") {
			gv1.show(mainPanel, viewNumber);
		} else if (viewNumber == "2") {
			gv1.show(mainPanel, viewNumber);
		} else if (viewNumber == "3") {
			gv1.show(mainPanel, viewNumber);
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
		System.out.println("in mv ap: "+cmd);
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