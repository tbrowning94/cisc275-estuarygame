package cisc275.game.model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import cisc275.game.view.SplashScreen;

/**
 * @author Nile
 *sets the number of fishermen based on water health,
 *and the amount of money generated from fishermen
 */
public class Fisherman implements java.io.Serializable {
	Point finalLocation;
	Point entryLocation;
	int manTotal;
	int money;
	int pHbar;
	private JLabel boatman;
	BufferedImage boat = createImage("images/boatman.png");
	private ImageIcon bimg = new ImageIcon(boat.getScaledInstance(150, 50, 20));
	JProgressBar barPh = new JProgressBar();
	JProgressBar barMoney = new JProgressBar();

		public void JProgressBar(int orientation){
			JProgressBar barPh = new JProgressBar(JProgressBar.HORIZONTAL);
			JProgressBar barMoney = new JProgressBar(JProgressBar.HORIZONTAL);
			}
		public void JProgressBar(int minimum, int maximum){
			JProgressBar barPh = new JProgressBar(0, 500);
			JProgressBar barMoney = new JProgressBar(0, 500);
			}
			
		public void JProgressBar(){
			DefaultBoundedRangeModel model = new DefaultBoundedRangeModel(0, 0, 0, 14);
			JProgressBar barPh = new JProgressBar(model);
			DefaultBoundedRangeModel model2 = new DefaultBoundedRangeModel(0, 0, 0, 500);
			JProgressBar barMoney = new JProgressBar(model2);
			}
		
		public void JProgressBarSetValue() {
	        int value1 = getpHbar();
	        barPh.setValue(value1);
	        int value2 = Fishing();
	        barMoney.setValue(value2);
	      }


//	    getContentPane().add(bar, EAST);
//	    pack();
//	    setVisible(true);
	

	public Fisherman(Point FL, Point EL, int MT, int M) {
		this.finalLocation=FL; this.entryLocation=EL;this.manTotal=MT; this.money=M;
		}
	
	private BufferedImage createImage(String file) {
        BufferedImage bufferedImage;
        try {
        	bufferedImage=ImageIO.read(new File(file));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
	}

	void onTick() {
	}
	/**
	 * @param ph
	 * @return number of fishermen on screen
	 */
	public int ManNum(Water health){
		if (Water.getHealth() <= 20){
			manTotal = 0;
			pHbar=pHbar-4;
		}
		if (Water.getHealth() <= 40){
			manTotal = 1;
			pHbar=pHbar-3;
			
		}
		if (Water.getHealth() <= 60){
			manTotal = 3;
			pHbar=pHbar-2;
		}
		if (Water.getHealth() <= 80){
			manTotal = 5;
			pHbar=pHbar-1;
		}
		else {
			manTotal = 10;
			pHbar = 8;
		}
		return 0;
	}
	/**healthier the water, more money that is generated, 
	takes in health of water and returns an amount
	checked every time a water tile reaches estuary*/
	public int Fishing(){
		money = money+Water.getHealth()/10;
		return money;
	}
	public int getpHbar(){
		return pHbar;
	}
	public String toString(){
		return "[Fisherman: finalLocation="+finalLocation+"entryLocation="+entryLocation
				+"manTotal="+manTotal+"money="+money+"]";
	}

}

