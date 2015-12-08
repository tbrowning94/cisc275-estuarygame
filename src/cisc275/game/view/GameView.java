package cisc275.game.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import cisc275.game.controller.Action;
import cisc275.game.controller.GameListener;
import cisc275.game.model.Game;

/**
 * @author Team 6
 * Run the main thread of the game, creates the start screen panel
 */
public class GameView extends ViewTemplate implements GameListener<Game>, Runnable, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4000773202654202342L;
	private static final int SCALE = 1;
	private JPanel panel;
	private JFrame frame;
	private SplashScreen splashScreen = new SplashScreen();
	private InstructionsView instructionsView;
	private GameView gameView;
    
	/**
	 * Game view constructor, creates panel for start screen
	 */
	public GameView() {
		this.panel = createContent();
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
			        getRootPane().getActionMap().put("Cancel", new AbstractAction() { 
			            /**
						 * 
						 */
						private static final long serialVersionUID = -909874301542551231L;
						public void actionPerformed(ActionEvent e) {
			                System.exit(0);
			            }
			       });
		this.gameView = this;
	}
	
//------Getters and Setters--------------------------------------------//
	/**
	 * @return frame for window of game view
	 */
	public JFrame getFrame() {
		return this.frame;
	}
	/**
	 * @return panel for game view
	 */
	public JPanel getPanel() {
		return this.panel;
	}
	/**
	 * @return game view instance
	 */
	public GameView getGameView() {
		return this.gameView;
	}
	/**
	 * @return world width size
	 */
	public static int getWorldWidth() {
		return WORLD_WIDTH;
	}
	/**
	 * @return world height size
	 */
	public static int getWorldHeight() {
		return WORLD_HEIGHT;
	}
	/**
	 * @return scale of game view
	 */
	public static int getScale() {
		return SCALE;
	}
	/**
	 * @return prints the current level, money, and pH
	 */
	public String getStatus() {
		return null; 
    }

//------Game View Methods----------------------------------------------//
	/**
	 * @return initialized panel for game view
	 * Creates panel and adds all needed buttons and labels
	 */
	private JPanel createContent() {
        final BufferedImage image1 = InstanceView.createImage("images/BackTrial1.png");
        final BufferedImage image2 = InstanceView.createImage("images/maintext.png");
        JPanel panel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -5664679380050387004L;
			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image1, 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
                g.drawImage(image2, ViewTemplate.scalex(228), ViewTemplate.scaley(100), ViewTemplate.scalex(915), ViewTemplate.scaley(121), null);     
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
		setResizable(true);

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
		button2.setFont(new Font("Georgia",Font.BOLD,20));
		button2.addActionListener(this);
		button2.setActionCommand("OpenTut");

		panel.add(Name); 	
		panel.add(button1);
		panel.add(button2);
        return panel;
    }
	@Override
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
	      if(cmd.equals("Open")){
	            getContentPane().removeAll();//dispose();
	           // System.out.print("hello");
	            //waterTiles.add(new Water(new Point(20,20), 100, 5, Color.BLUE));
	            SplashScreen.crabby = true;
	            getContentPane().add(SplashScreen.getPanel2());
	            pack();
	        }
	      if(cmd.equals("OpenTut")){
				getContentPane().removeAll();
				instructionsView = new InstructionsView();
				getContentPane().add(instructionsView.getPanel3());
				pack();
			}
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

	public static void main(String[] args) { //move to view, windows are central thread of game
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				GameView gv = new GameView();
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