package cisc275.game.view;

import java.awt.Button;
import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.soap.Text;
import java.awt.Font;
import java.awt.Component;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

public class InstructionsView extends JFrame implements ActionListener, MouseListener {
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	//private JFrame frame;
	private JPanel panel3;
	private GameView gameView;
	JButton back;
	JTextArea instructions;
	Image instimage;
	
	public InstructionsView() {
		this.panel3 = GameFrame();
	}
	
	public JPanel getPanel3() {
		return this.panel3;
	}
	
	public JPanel GameFrame(){
        final Image image = createImage();
        panel3 = new JPanel() {
        	
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //g.drawImage(image, 0, 0, null);
                g.drawImage(image, 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
            }
        };
        panel3.addMouseListener(new MouseAdapter() {
            private Color background;

            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println("Mouse clicked");
//        		if (plantClick) {
//        			System.out.println("Mouse clicked after plant clicked");
//        			Point loc = new Point(e.getX(), e.getY());//e.getLocationOnScreen();
//        			paintPlantComponent(e.getComponent().getGraphics(), loc);
//        			setPlantBool(false);
//        		}
//        		if (garbageCollectorClick){
//        			System.out.println("Mouse clicked after Garbage clicked");
//        			setGarbageCollectorBool(false);
//        		}
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(background);
            }
        });

		Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE); // create window dimension
		panel3.setPreferredSize(size); // set window dimension
		panel3.setBorder(BorderFactory.createLineBorder(Color.blue)); // creates a border, not really needed
		
		//getContentPane().add(panel2, BorderLayout.NORTH); // adds panel to content pane, this is what we will paint to and update
		panel3.setLayout(null); // default layout is Flowlayout, we need to decide what we want

		panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
		panel3.add(Box.createRigidArea(new Dimension(50, 0)));
		
		back = new JButton("Back");
		back.setPreferredSize(new Dimension(59, 50));
		back.setFont(new Font("Tahoma", Font.PLAIN, 18));
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setLocation(720, 2);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		back.addActionListener(this);
		back.setActionCommand("Back");
//		  try {
//			    Image img = ImageIO.read(new File("images/Grass.png"));
//			    button.setIcon(new ImageIcon(img));
//			  } catch (IOException ex) {
//			  }
		instructions = new JTextArea("Instructions:\r\n\r\n\t- Place plants to stop runoff\r\n\t- Place garbage collectors to pick up trash which \r\n\t  decreases plant effectiveness\r\n\t- Click mitten crabs to cage and remove them before they \r\n          ruin your defense");
		instructions.setRows(4);
		instructions.setSize(1438, 200);
		instructions.setFont(new Font("Courier New", Font.PLAIN, 36));
		panel3.add(back);
		panel3.add(instructions);
		
    	//pack();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		//setResizable(true);
        return panel3;
    	
    }
	
	protected BufferedImage createImage() {
        BufferedImage bufferedImage;
        try {
        	//bufferedImage=ImageIO.read(file);
            bufferedImage = ImageIO.read(new File("images/Tower Defense Paths/800x600_path1.png"));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Back")){
			//TODO:Fix back button
			System.out.println("back button enabled");
			getContentPane().removeAll();//dispose();
	        //System.out.print("hello");
	        gameView = new GameView();
	        getContentPane().add(gameView.getPanel());
	        pack();
        } 
	}

}
