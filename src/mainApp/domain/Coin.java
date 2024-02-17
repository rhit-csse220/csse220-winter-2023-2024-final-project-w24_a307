package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Coin extends GameObject {
	public static final int COIN_WIDTH = 20;
	public static final int COIN_HEIGHT = 20;
	private boolean collected;
	/*
	 *  --- coin constructor ---
	 */
	public Coin(int x, int y) {
		super(0, 0, x, y, COIN_WIDTH, COIN_HEIGHT);
		collected = false;
	}
	/* --- handlePickup overridden method ---
	 * ensures: when the hero "picks up" the coin, variable 'collected' is set to true
	 */
	@Override
	public void handlePickup(Hero hero) {
		if(!collected)
		{  
			collected = true;
		}
	}
	/* --- toRemove overridden method ---
	 * returns true if coin is collected, else false
	 */
	@Override 
	public boolean toRemove()
	{
		return collected;
	}
	/* --- coin drawOn method ---
	 * ensures: image of coin is loaded from images folder and is scaled accordingly
	 */
	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage img;
		try {
			img = ImageIO.read(new File("images/coin.gif"));
			g2.drawImage(img, x, y, COIN_WIDTH, COIN_HEIGHT, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//g2.setColor(Color.YELLOW);
		//g2.fillOval(x, y, COIN_WIDTH, COIN_HEIGHT);
	}

}
