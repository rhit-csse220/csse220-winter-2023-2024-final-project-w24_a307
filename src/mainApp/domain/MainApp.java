package mainApp.domain;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class: MainApp
 * @author Put your team name here --> a307
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	private static final int DELAY = 5;
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 400;
	public void mainApp()
	{
		
	}
	//some comment
	private void runApp() {
		MainComponent component = new MainComponent();
		JFrame frame = new JFrame("Jetpack Joyride");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		JPanel info = new JPanel();
		JLabel score = new JLabel("Score: "+component.getScore());
		JLabel lives = new JLabel("Lives: "+component.getLives());
		info.add(score);
		info.add(lives);
		frame.add(info, BorderLayout.NORTH);
		frame.add(component);
		Timer t = new Timer(DELAY, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				component.tick();
				component.repaint();
				frame.repaint();
				score.setText("Score: " + component.getScore());
				lives.setText("Lives: "+component.getLives());
			}
		});
		t.start();
		
		//component.levelLoader("Level1");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();		
	} // main

}