package cisc275.game.view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame implements Runnable, ActionListener {
		/**
	 * 
	 */
	private static final long serialVersionUID = 3215378592431621424L;
		//game constants
		private static final int WORLD_WIDTH = 1366;
		private static final int WORLD_HEIGHT = 768;
		private static final int SCALE = 1;
		public static String title = "Estuary Defense";
		private JFrame frame;
		int deletenum = -1; //with use of crabs
		public int imgHeight;
		public int imgWidth;
		
		//private Key, Mouse?
		private boolean running = false;
		private BufferedImage image = new BufferedImage(getWorldWidth(), getWorldHeight(), BufferedImage.TYPE_INT_RGB);
		// # of milliseconds between state updates, probably will be 
		//important when we figure out how to loop game
		private long speed; 	
		//number of rows and columns in the "world"
		private int rows;
		private int cols;
		
		private JPanel gamePanel, buttonPanel;
		private CardLayout gv1;
		private SimpleModel simpleModel = new SimpleModel();

		private GameView gameView;
		private InstructionsView instructionsView;
		private SplashScreen splashScreen;
	   	
		public MainView() {
			gameView = GameView.getInstance();
			splashScreen = SplashScreen.getInstance();
			instructionsView = InstructionsView.getInstance();
			
			splashScreen.setModel(simpleModel);
			instructionsView.setModel(simpleModel);
			
			gamePanel = locationPanel();
			gv1 = new CardLayout();
			this.setLayout(gv1);
			//this.add(buttonPanel, "South");
			this.add(gamePanel, "1");
			this.add(splashScreen, "2");
			this.add(instructionsView, "3");
			//gv1.show(getContentPane(), "1");
			gv1.show(gamePanel.getParent(), "1");
			
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(true);
			this.setLocationRelativeTo(null);
			this.pack();
			this.setVisible(true);
		}
		
		private JPanel locationPanel() {
			final Image image = createImage();
			JPanel panel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(image, 0, 0, getWorldWidth(), getWorldHeight(), null);
	                
	            }
	        };
			gb1 = new GridBagLayout();
			panel.setLayout(gb1);
			panel.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent arg0) {
	        		System.out.println("clicked: "+arg0.getX()+","+arg0.getY());
//	        		if (instructionsView.getInstance().getSimpleModel().getEnum() == "Back") {
//	        			gv1.show(gamePanel,"1");
//	        		}
	        	}
	        });
			Dimension size = new Dimension(getWorldWidth()*getScale(), getWorldHeight()*getScale()); // create window dimension
			panel.setMinimumSize(size); // set window dimension
			
			JLabel name = new JLabel("WELCOME TO ESTUARY DEFENSE!");
			addGridItem(panel,name,0,0,1,1,GridBagConstraints.CENTER,new Insets(80,100,40,100));
			JButton button1 = new JButton("Start");
			button1.addActionListener(this);
			button1.setActionCommand("Open");
			addGridItem(panel,button1,0,1,1,1,GridBagConstraints.CENTER,new Insets(80,100,5,100));
			JButton button2 = new JButton("Tutorial");
			button2.addActionListener(this);
			button2.setActionCommand("OpenTut");
			addGridItem(panel,button2,0,2,1,1,GridBagConstraints.CENTER,new Insets(5,100,80,100));	
			
			return panel;
		}
		
		public void setView(String viewNumber) {
			if (viewNumber == "1") {
				gv1.show(gamePanel, viewNumber);
			} else if (viewNumber == "2") {
				gv1.show(splashScreen, viewNumber);			
			} else if (viewNumber == "3") {
				gv1.show(instructionsView, viewNumber);
			}
		}
		public CardLayout getgv1() {
			return this.gv1;
		}
		public JPanel getGamePanel() {
			return this.gamePanel;
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
		//no idea what these two do
		void remove() {
		}
		void render() {
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
		    	  	gv1.show(splashScreen.getParent(),  "2");
		            //gameView.remove(buttonPanel);
		            //pack();
		        }
		      if(cmd.equals("OpenTut")){
					//getContentPane().removeAll();
					//getContentPane().add(instructionsView.getInstance());
					gv1.show(instructionsView.getParent(), "3");
					//gameView.remove(buttonPanel);
					//pack();
				}
		      if(cmd.equals("Back")){
		    	  System.out.println("Back in gv");
		    	  gv1.show(gamePanel.getParent(), "1");
		      }
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

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}



}
