package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

/**
 * Class: MainApp
 * @author Put your team name here
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	private static final int DELAY = 50;
	public void mainApp()
	{
		
	}
	private void runApp() {
		MainComponent component = new MainComponent();
		Timer t = new Timer(DELAY, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				component.tick();
			}
		});
		
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