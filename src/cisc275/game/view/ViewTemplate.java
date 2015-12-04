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
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import cisc275.game.controller.Action;
import cisc275.game.controller.GameListener;
import cisc275.game.controller.Player;

import cisc275.game.model.Game;
import cisc275.game.model.Water;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewTemplate extends JFrame implements GameListener<Game>, Runnable, ActionListener {
	//game constants
	private static final int SCALE = 1;
	static int TIMER_DELAY = 50;
	public static String title = "Estuary Defense";
	private JButton button;
	private JPanel panel;
	private JFrame frame;
	static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	static GraphicsDevice gs = ge.getDefaultScreenDevice();
	static DisplayMode dm = gs.getDisplayMode();
	protected static int WORLD_WIDTH = dm.getWidth();;
	protected static int WORLD_HEIGHT = dm.getHeight();
	//protected static int WORLD_WIDTH = 1366;
	//protected static int WORLD_HEIGHT = 768;
	static double regwidth=1366.0;
	static double regheight=768.0;
	static double widthscale = WORLD_WIDTH/regwidth;
	static double heightscale = WORLD_HEIGHT/regheight;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
	static public int scalex(int p){
		return ((int)Math.round(p*ViewTemplate.widthscale));
	}
	static public int scaley(int p){
		return ((int)Math.round(p*ViewTemplate.heightscale));
	}

}


