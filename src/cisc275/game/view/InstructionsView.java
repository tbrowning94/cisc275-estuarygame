package cisc275.game.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.soap.Text;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

public class InstructionsView extends JPanel implements ActionListener, MouseListener {
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	private static InstructionsView instance = null;
	private JLabel viewName, description;
	private JTextArea instructions;
	private JButton back;
	private GameView gameView;
	
	private BoxLayout bl;
	private SimpleModel simpleModel;
	
	public InstructionsView() {
		description = new JLabel("Defend your local estuary!");
		
		back = new JButton("Back");
		back.setVerticalAlignment(SwingConstants.BOTTOM);
		back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setLocation(720, 2);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (simpleModel != null) {
					simpleModel.setEnum(back.getText());
				}
			}
		});
		back.setActionCommand("Back");
		
		//bl = new BoxLayout(this, BoxLayout.Y_AXIS);
		//this.setLayout(bl);
		this.setLayout(new FlowLayout());
		//this.add(description, bl);
		this.add(locationPanel());
		Dimension size = new Dimension(getWidth()*getScale(), getHeight()*getScale()); // create window dimension
		this.setPreferredSize(size); // set window dimension
	}
	
	public void setModel(SimpleModel simpleModel) {
		this.simpleModel = simpleModel;
	}
	public int getScale() {
		return SCALE;
	}
	
	private JPanel locationPanel() {
		final Image image = createImage();
		JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, WORLD_WIDTH, WORLD_HEIGHT, null);
            }
        };
        panel.addMouseListener(new MouseAdapter() {
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
		
		instructions = new JTextArea();
		panel.add(instructions);
		instructions.setFont(new Font("Courier New", Font.PLAIN, 12));
		instructions.setText("Defend this estuary with plants and garbage collectors");
		instructions.setEditable(false);
		instructions.setColumns(40);
		viewName = new JLabel("Instructions");
		panel.add(viewName);
		panel.add(back);
		
		return panel;
	}
	
	public static InstructionsView getInstance() {
		if (instance == null) {
			instance = new InstructionsView();
		}
		return instance;
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
			
			//getContentPane().removeAll();//dispose();
	        //System.out.print("hello");
	        //gameView = new GameView();
	        //getContentPane().add(gameView.getPanel());
	        //pack();
        } 
	}

}
