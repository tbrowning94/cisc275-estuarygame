package cisc275.game.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
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
import javax.swing.JComponent;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 3646073377614320934L;
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	private static InstructionsView instance = null;
	private JLabel viewName, description;
	private JPanel ivPanel;
	private JTextArea instructions;
	private JButton back;
	private GameView gameView;
	
	private GridBagLayout gb1;
	private SimpleModel simpleModel;
	
	public InstructionsView() {
		this.gameView = getGameView();
		gb1 = new GridBagLayout();
		this.setLayout(gb1);
		ivPanel = locationPanel();
		this.add(ivPanel);
		description = new JLabel("Defend your local estuary!");
		instructions = new JTextArea();
		back = new JButton("Back");
		viewName = new JLabel("Instructions");
		
		addGridItem(this,description,0,0,1,1,GridBagConstraints.CENTER,new Insets(80,100,5,100));
		back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String cmd = ae.getActionCommand();
				if(cmd.equals("Back")){
					//TODO:Fix back button
					System.out.println("back button enabled");
					//instance.getParent().super().getParent().g
					//instance.getGameView().getgv1().next(instance.getGameView().getGamePanel().getParent());
					//gameView.getgv1().next(gameView.getGamePanel());
					//getMainView().setView("1");
					//if (instance.getSimpleModel().getEnum() == "Back") {
	        			//super().getGameView().getgv1().show(super().getGameView().getGamePanel(), "1");
	        			//gv1.show(gamePanel,"1");
					//}
					//getContentPane().removeAll();//dispose();
			        //System.out.print("hello");
			        //gameView = new GameView();
			        //getContentPane().add(gameView.getPanel());
			        //pack();
		        }
				if (simpleModel != null) {
					//System.out.println("Back click");
					simpleModel.setAction("Back");
				}
			}
		});
		back.setActionCommand("Back");
		addGridItem(this,back,3,1,1,2,GridBagConstraints.CENTER,new Insets(0,100,20,100));
		instructions.setFont(new Font("Courier New", Font.PLAIN, 12));
		instructions.setText("Defend this estuary with plants and garbage collectors");
		instructions.setEditable(false);
		addGridItem(this,instructions,1,1,1,1,GridBagConstraints.CENTER,new Insets(0,100,20,100));
		addGridItem(this,viewName,0,1,1,1,GridBagConstraints.CENTER,new Insets(0,100,20,100));

		//Dimension size = new Dimension(getWidth()*getScale(), getHeight()*getScale()); // create window dimension
		//this.setPreferredSize(size); // set window dimension
		this.setVisible(true);
	}
	
	private void addGridItem(JPanel panel, JComponent comp, int x, int y, int width, int height, int align, Insets padding) {
		GridBagConstraints gcon = new GridBagConstraints();
		gcon.gridx = x;
		gcon.gridy = y;
		gcon.gridwidth = width;
		gcon.gridheight = height;
		gcon.weightx = 0.5;
		gcon.weighty = 0.5;
		gcon.insets = padding;
		gcon.anchor = align;
		gcon.fill = GridBagConstraints.NONE;
		panel.add(comp, gcon);
	}
	
	public void setModel(final SimpleModel simpleModel) {
		this.simpleModel = simpleModel;
	}
	public JPanel getInstPanel() {
		return this.ivPanel;
	}
	public int getScale() {
		return SCALE;
	}
	public SimpleModel getSimpleModel() {
		return simpleModel;
	}
	public GameView getGameView() {
		return this.gameView;
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
        this.setLayout(gb1);
//		panel.add(instructions,gb1);
//		panel.add(viewName,gb1);
//		panel.add(back,gb1);
//		panel.add(description,gb1);
		
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
