package cisc275.game.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import cisc275.game.controller.Action;
import cisc275.game.controller.GameListener;
import cisc275.game.controller.Player;

import cisc275.game.model.Game;
import cisc275.game.model.Water;



import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameView extends ViewTemplate implements GameListener<Game>, Runnable, ActionListener {
	//game constants
	private static final int SCALE = 1;
	static int TIMER_DELAY = 50;
	public static String title = "Estuary Defense";
	private JButton button;
	private JPanel panel;
	private JFrame frame;
	 static ArrayList<Water> waterTiles = new ArrayList<Water>();
	private SplashScreen splashscreen = new SplashScreen();
	private InstructionsView instructionsView;
	private GameView gameView;
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
	
	Image garbage;
	Image plant;
	Image garbageCollector;
	
    private GameView create() {
        frame.getContentPane().add(createContent());
        
        return this;
    }
   
    
	public GameView() {
		new Timer(TIMER_DELAY, new TimerListener()).start();
		this.panel = createContent();
		 getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
			        getRootPane().getActionMap().put("Cancel", new AbstractAction()
			        { 

			            public void actionPerformed(ActionEvent e)
			            {
			                System.exit(0);
			                //framename.setVisible(false);
			            }
			       });
		this.gameView = this;
		//initUI();
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	public JPanel getPanel() {
		return this.panel;
	}
	public GameView getGameView() {
		return this.gameView;
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
	
	private JPanel createContent() {
        final Image[] image = createImage();
//      panel = new JPanel(); // Initialize panel
//		Game game = new Game(); // Not sure if this should go here?
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image[0], 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
                g.drawImage(image[1], ViewTemplate.scalex(228), ViewTemplate.scaley(100), ViewTemplate.scalex(915), ViewTemplate.scaley(121), null);
                //g.drawImage(image, 0, 0, getWorldWidth(), getWorldHeight(), null);
                
            }
        };
        panel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		System.out.println("clicked: "+arg0.getX()+","+arg0.getY());
        	}
        });
        
		Dimension size = new Dimension(getWorldWidth()*getScale(), getWorldHeight()*getScale()); // create window dimension
		panel.setPreferredSize(size); // set window dimension
		panel.setBorder(BorderFactory.createLineBorder(Color.blue)); // creates a border, not really needed
		
		getContentPane().add(panel, BorderLayout.NORTH); // adds panel to content pane, this is what we will paint to and update
		panel.setLayout(null); // default layout is Flowlayout, we need to decide what we want


    	pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setResizable(true);
		
		panel.setLayout(null);
		Insets insets = panel.getInsets();
	
		//panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		//panel.add(Box.createRigidArea(new Dimension(300, 300)));
		
		JLabel Name = new JLabel("",JLabel.CENTER);
		Name.setForeground(Color.black);
		
		
		Dimension size1 = Name.getPreferredSize();
		System.out.println(size1);
		Name.setSize(size1);
		
		JButton button1 = new JButton("Start");
		button1.setForeground(Color.blue);
		button1.setFont(new Font("Georgia",Font.BOLD,20));
		size1=button1.getPreferredSize();
		button1.setBounds(ViewTemplate.scalex(600), ViewTemplate.scaley(300), ViewTemplate.scalex(150), ViewTemplate.scaley(50));
		
		button1.addActionListener(this);
		button1.setActionCommand("Open");
		JButton button2 = new JButton("Tutorial");
		size1 = button2.getPreferredSize();
		button2.setBounds(ViewTemplate.scalex(600), ViewTemplate.scaley(375), ViewTemplate.scalex(150), ViewTemplate.scaley(50));
		button2.setForeground(Color.blue);
		//button2.setIcon(new ImageIcon("images/textures/grassTile05.png"));
		button2.setFont(new Font("Georgia",Font.BOLD,20));
		button2.addActionListener(this);
		button2.setActionCommand("OpenTut");
		//Name.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.add(Name); 	
		panel.add(button1);
		panel.add(button2);
		
		//button2.setLocation(0, 300);
        return panel;
    }

    protected BufferedImage[] createImage() {
        BufferedImage[] bufferedImage = new BufferedImage[2];

        try {
        	//image=ImageIO.read(file);
            bufferedImage[0] = ImageIO.read(new File("images/BackTrial1.png"));
            bufferedImage[1]= ImageIO.read(new File("images/maintext.png"));
            
            imgHeight=ViewTemplate.scaley(bufferedImage[0].getHeight());
            imgWidth=ViewTemplate.scalex(bufferedImage[0].getWidth());
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
	            getContentPane().removeAll();//dispose();
	           // System.out.print("hello");
	            //waterTiles.add(new Water(new Point(20,20), 100, 5, Color.BLUE));
	            getContentPane().add(splashscreen.getPanel2());
	            pack();
	        }
	      if(cmd.equals("OpenTut")){
				getContentPane().removeAll();
				instructionsView = new InstructionsView();
				getContentPane().add(instructionsView.getPanel3());
				pack();
			}
	    }
	
    public static int rando(){
    	Random rnd = new Random();
    	return(rnd.nextInt(50));
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
	public class TimerListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {

        };
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
//		GameView gv = new GameView();
//		gv.InitializeBoardsize();
//		gv.startGame(); // Not sure about this either
//		gv.start(); // runs thread which calls run()
		
		SwingUtilities.invokeLater(new Runnable(){
//		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				GameView gv = new GameView();
				//gv.setVisible(true);
				try {
					gv.dispose();
					gv.setUndecorated(true);
				   gs.setFullScreenWindow(gv);
				   
				   
				} finally {
				    gs.setFullScreenWindow(null);
				}
			
			}
		});
	}

	@Override
	public void run() {
		
		GameView gv = new GameView();
		gv.setVisible(true);
	}



}


