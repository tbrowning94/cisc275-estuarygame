package cisc275.game.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SplashScreen extends GameView{
	Button startGame;
	Button instructions;
	Image splashimage;
	private JPanel panel2;
	public SplashScreen() {
		pack();
		setVisible(true);
		GameFrame();
	}
	GameView G = new GameView();
	void initialize() {
	}
	void onClick() {
	}
	void inValidate() {
	}

	public Component GameFrame(){
        final Image image = createImage();
        JPanel panel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //g.drawImage(image, 0, 0, null);
                g.drawImage(image, 0, 0, getWorldWidth()-75, getWorldHeight()-150, null);
                
            }
        };

		Dimension size = new Dimension(getWorldWidth()*getScale(), getWorldHeight()*getScale()); // create window dimension
		panel2.setPreferredSize(size); // set window dimension
		panel2.setBorder(BorderFactory.createLineBorder(Color.blue)); // creates a border, not really needed
		
//		getContentPane().add(panel2, BorderLayout.NORTH); // adds panel to content pane, this is what we will paint to and update
//		panel2.setLayout(null); // default layout is Flowlayout, we need to decide what we want
//
//		panel2.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//		//panel2.add(Box.createRigidArea(new Dimension(50, 0)));
//		
//		JButton button3 = new JButton("Plant");
//		JButton button4 = new JButton("Garbage Collector");
//		panel2.add(button3);
//		panel2.add(button4);
//		
    	pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		
        return panel2;
    	
    }
    protected BufferedImage createImage() {
        BufferedImage bufferedImage;

        try {
        	//image=ImageIO.read(file);
            bufferedImage = ImageIO.read(new File("images/BackImg1.jpg"));
            imgHeight=bufferedImage.getHeight();
            imgWidth=bufferedImage.getWidth();
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
