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
	public Coin(int x, int y) {
		super(0, 0, x, y, COIN_WIDTH, COIN_HEIGHT);
		collected = false;
	}

	@Override
	public void handlePickup(Hero hero) {
		if(!collected)
		{
			hero.getPoint(1);
			collected = true;
		}
	}
	@Override 
	public boolean toRemove()
	{
		return collected;
	}
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
