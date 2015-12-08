package cisc275.game.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Component;

/**
 * @author Team 6
 * Creates a panel for instructions on how to play the game
 */
public class InstructionsView extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2836003860167359725L;
	private static final int WORLD_WIDTH = 1366;
	private static final int WORLD_HEIGHT = 768;
	private static final int SCALE = 1;
	private JPanel panel3;
	private GameView gameView;
	JButton back;
	JTextArea instructions;
	
	/**
	 * Instruction view constructor, create a panel to display
	 */
	public InstructionsView() {
		this.panel3 = GameFrame();
	}
	
//------Getters and Setters--------------------------------------------//	
	/**
	 * @return panel for instruction view
	 */
	public JPanel getPanel3() {
		return this.panel3;
	}
	
//------Water Methods--------------------------------------------------//	
	/**
	 * @return initialized panel for instruction view
	 * Creates all need buttons and text areas, loads images
	 */
	public JPanel GameFrame(){
        final Image image = InstanceView.createImage("images/Tower Defense Paths/800x600_path1.png");
        panel3 = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1684401414823542668L;
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
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(background);
            }
        });
		Dimension size = new Dimension(WORLD_WIDTH*SCALE, WORLD_HEIGHT*SCALE); // create window dimension
		panel3.setPreferredSize(size); // set window dimension
		panel3.setBorder(BorderFactory.createLineBorder(Color.blue)); // creates a border, not really needed
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

		instructions = new JTextArea("Instructions:\r\n\r\n\t- Place plants to stop runoff\r\n\t- Place garbage collectors to pick up trash which \r\n\t  decreases plant effectiveness\r\n\t- Click mitten crabs to cage and remove them before they \r\n          ruin your defense");
		instructions.setRows(4);
		instructions.setSize(1438, 200);
		instructions.setFont(new Font("Courier New", Font.PLAIN, 36));
		
		panel3.add(back);
		panel3.add(instructions);
        return panel3;
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
			System.out.println("back button enabled");
			getContentPane().removeAll();//dispose();
	        gameView = new GameView();
	        getContentPane().add(gameView.getPanel());
	        pack();
        } 
	}
}