package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComponent;

public class MainComponent extends JComponent {
	private Hero hero;
	private ArrayList<GameObject> gameObjects;
	public MainComponent()
	{
		hero = new Hero()
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyChar() == ' ')
					hero.setBoosting(true);
			}
			public void keyReleased(KeyEvent e)
			{
				if(e.getKeyChar() == ' ')
					hero.setBoosting(false);
			}
		});
	}
	public void tick()
	{
		hero.update();
		for(GameObject object : gameObjects)
		{
			object.update();
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		hero.drawOn(g2);
		for(GameObject object : gameObjects)
		{
			object.drawOn(g2);
		}
	}
}
