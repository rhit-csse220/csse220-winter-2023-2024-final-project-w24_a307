package mainApp.domain;

import java.awt.Graphics;

public class ShieldPowerUp extends PowerUp {

	public static final int SHIELD_WIDTH = 20;
	public static final int SHIELD_HEIGHT = 20;
	public ShieldPowerUp(int x, int y) {
		super(x, y, SHIELD_WIDTH, SHIELD_HEIGHT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handlePickup(Hero hero) {
		hero.setShielded(true);
	}

	@Override
	public void drawOn(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
