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
		gameObjects = new ArrayList<GameObject>();
		hero = new Hero();
		gameObjects.add(new Zapper(10, 10, 50, Math.PI/4));
		Zapper onZapper = new Zapper(100, 10, 50, Math.PI/4);
		gameObjects.add(onZapper);
		gameObjects.add(new Laser(40));
		Laser onLaser = new Laser(200);
		onLaser.turnOn();
		gameObjects.add(onLaser);
		onZapper.turnOn();
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e)
			{
				System.out.println("key pressed");
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println("SPACE PRESSED");
					hero.setBoosting(true);
				}

			}
			@Override
			public void keyReleased(KeyEvent e)
			{
				System.out.println("key released");
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println("SPACE RELEASED");
					hero.setBoosting(false);
				}
			}
		});
		this.setFocusable(true);
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
