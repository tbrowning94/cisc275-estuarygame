package cisc275.game.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import cisc275.game.view.GameView;
import cisc275.game.view.SplashScreen;

/**
 * @author Nile
 *sets the number of fishermen based on water health,
 *and the amount of money generated from fishermen
 */
public class Fisherman extends JFrame implements java.io.Serializable{
	Point finalLocation;
	Point entryLocation;
	int manTotal=0;
	int money=200;
	int pHbar=8;
	int EstHealth=500;
	private JLabel boatman;
	BufferedImage boat = createImage("images/boatman.png");
	private ImageIcon bimg = new ImageIcon(boat.getScaledInstance(150, 50, 20));
	JProgressBar barPh = new JProgressBar();
	JProgressBar barMoney = new JProgressBar();
//	 private static JPanel contentPane;
//	 private JPanel bottomPane;
//	 private JButton btnCancel;
//	private Task task;
//	private DoSomething ds;
//public void CreateBox(){
//	setTitle("Money");
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	setBounds(100,100,450,350);
//	
//    contentPane = new JPanel(new BorderLayout());
//    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//    setContentPane(contentPane);
//    //Create panel for progress bar/cancel button
//    bottomPane = new JPanel();
//    bottomPane.setLayout(new BoxLayout(bottomPane, BoxLayout.Y_AXIS));
//
//    barMoney = new JProgressBar(0, 100);
//    barMoney.setStringPainted(true);
//    barMoney.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//    barMoney.setValue(0);
//
//    btnCancel = new JButton("Cancel");
//    btnCancel.addActionListener(new ActionListener() {
//        public void actionPerformed(ActionEvent e) {
//            closeWindow();
//            
//	
//}
//    });
//
//    bottomPane.add(barMoney);
//    bottomPane.add(btnCancel);
//    contentPane.add(bottomPane, BorderLayout.SOUTH);
//
//    PropertyChangeListener listener = new PropertyChangeListener(){
//        public void propertyChange(PropertyChangeEvent event){
//            if("progress".equals(event.getPropertyName())){
//                barMoney.setValue(Fishing());
//                barMoney.setString(Integer.toString(Fishing()));
//            }
//        }
//    };
//
//    setVisible(true);
//    task = new Task();
//    task.execute();
//}
//
//class Task extends SwingWorker<Void, String>{
//    public Task(){
//        ds = new DoSomething(ManNum(null));
//    }
//    @Override
//    public Void doInBackground(){
//        for(int i = 0; i < 100; i++){
//            ds.ManNum();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//    @Override
//    public void done(){
//        closeWindow();
//    }
//    public void updateProgress(int tick){
//        setProgress(money + tick);
//    }
//}
//
//public class DoSomething{
//    Task task;
//    public DoSomething(int i){
//        this.task = i;
//    }
//    public void incrementPercent(){
//        task.updateProgress(1);
//    }
//}
//
//public void closeWindow(){
//    WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
//    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
//}

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

	public Fisherman(Point FL, Point EL, int MT, int M) {
		this.finalLocation=FL; this.entryLocation=EL;this.manTotal=MT; this.money=M;
		
	}
	
public JProgressBar getbarMoney(){
	return barMoney;
}

public JProgressBar getbarPh(){
	return barPh;
}
	void onTick() {
	}
	/**
	 * @param ph
	 * @return number of fishermen on screen
	 */
	public int ManNum(Water health){
		if (EstHealth <= 150){
			manTotal = 0;
			pHbar=pHbar-4;
		}
		if (EstHealth <= 250){
			manTotal = 1;
			pHbar=pHbar-3;
			Fishing();
		}
		if (EstHealth <= 350){
			manTotal = 4;
			pHbar=pHbar-2;
			Fishing();
		}
		if (EstHealth <= 400){
			manTotal = 7;
			pHbar=pHbar-1;
			Fishing();
		}
		else {
			manTotal = 8;
			pHbar = 8;
			Fishing();
		}
		return 0;
	}
	/**healthier the water, more money that is generated, 
	takes in health of water and returns an amount
	checked every time a water tile reaches estuary*/
	public int Health(Water runoffloc){
	if (runoffloc.getLocation().getY()>=GameView.getWorldHeight()-30){
		EstHealth= EstHealth - runoffloc.getHealth();
	}
	return EstHealth;
	}
	public int Fishing(){
		money = money+(EstHealth/10)*manTotal;
		return money;
	}
	public int getpHbar(){
		return pHbar;
	}
	public String toString(){
		return "[Fisherman: finalLocation="+finalLocation+"entryLocation="+entryLocation
				+"manTotal="+manTotal+"money="+money+"]";
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
}