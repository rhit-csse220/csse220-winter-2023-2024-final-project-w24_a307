package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Coin extends GameObject {
	public static final int COIN_WIDTH = 20;
	public static final int COIN_HEIGHT = 20;
	public Coin(int velX, int velY, int x, int y, int width, int height) {
		super(0, 0, x, y, COIN_WIDTH, COIN_HEIGHT);
	}

	@Override
	public void handlePickup(Hero hero) {
		hero.getPoint(1);
	}

	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.YELLOW);
		g2.fillOval(x, y, COIN_WIDTH, COIN_HEIGHT);
	}

}
